package il.co.migdal.ins.personalaccidents.doctor;

import com.google.inject.Inject;
import il.co.migdal.ins.AbstractModelFlyweight;
import il.co.migdal.ins.iterator.operative.OperativeClaimBusinessIterator;
import il.co.migdal.ins.model.BaseOutput;
import il.co.migdal.ins.model.Message;
import il.co.migdal.ins.personalaccidents.AbstractController;
import il.co.migdal.ins.personalaccidents.AbstractServiceStation;
import il.co.migdal.ins.model.BaseProcess;
import il.co.migdal.ins.model.Claim;
import il.co.migdal.ins.personalaccidents.doctor.station.*;
import il.co.migdal.ins.util.ProcessLog;

import java.util.*;

public class PersonalAccidentsDoctorDecisionController extends AbstractController {

    /*@Inject
    public void setStations(Set<AbstractServiceStation> stations) {
        this.stations = stations;
        this.stations.stream().forEach(station -> stationMap.put(station.getClass().getSimpleName(), station));
        setupChain();
    }*/

    public enum StationMapper {
        PhysicalDecisionCopier(0),
        OperativeClaimBusinessIterator(1),
        TransactionPreparator(2),
        TransactionCaller(3),
        TransactionStatus(4),
        HistoryCreator(5),
        InjuryHistoryCreator(6),
        OperativeClaimUpdater(7);

        private int ind;

        StationMapper(int ind) {
            this.ind = ind;
        }

        public static boolean exists(String stationName) {
            for (StationMapper field : StationMapper.values()) {
                if (field.name().equals(stationName)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean exists(AbstractServiceStation station) {
            StationMapper entry = fromIndex(station.index());
            if ( entry == null )
                return false;
            if ( !entry.name().equals(station.getClass().getSimpleName()) )
                return false;
            return true;
        }

        public static StationMapper fromIndex(int ind) {
            if ( (StationMapper.values().length-1) < ind )
                return null;
            StationMapper entry = StationMapper.values()[ind];
            if ( entry != null )
                return entry;
            return null;
        }
    }

    public boolean belongs(AbstractServiceStation station) {
        // return StationMapper.exists(station.getClass().getSimpleName());
        return StationMapper.exists(station);
    }

    @Override
    public void setupChain() {
        PhysicalDecisionCopier physicalDecisionCopier = (PhysicalDecisionCopier) stationMap.get("PhysicalDecisionCopier");
        OperativeClaimBusinessIterator operativeClaimIterator = (OperativeClaimBusinessIterator) stationMap.get("OperativeClaimBusinessIterator");
        TransactionPreparator transactionPreparator = (TransactionPreparator) stationMap.get("TransactionPreparator");
        TransactionCaller transactionCaller = (TransactionCaller) stationMap.get("TransactionCaller");
        TransactionStatus transactionStatus = (TransactionStatus) stationMap.get("TransactionStatus");
        HistoryCreator historyCreator = (HistoryCreator) stationMap.get("HistoryCreator");
        InjuryHistoryCreator injuryHistoryCreator = (InjuryHistoryCreator) stationMap.get("InjuryHistoryCreator");
        OperativeClaimUpdater operativeClaimUpdater = (OperativeClaimUpdater) stationMap.get("OperativeClaimUpdater");

        physicalDecisionCopier.setNextStation(operativeClaimIterator);
        operativeClaimIterator.setNextStation(transactionPreparator);
        transactionPreparator.setNextStation(transactionCaller);
        transactionCaller.setNextStation(transactionStatus);
        transactionStatus.setNextStation(historyCreator);
        historyCreator.setNextStation(injuryHistoryCreator);
        injuryHistoryCreator.setNextStation(operativeClaimUpdater);
    }

    // This is main entry point for the SubFeature Station / Tab (one of `Clerk` | `DoctorDecision` | `Referent` | `Approval`  station)
    public BaseOutput enterDoctorDecisionStep() {
        System.out.println("");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("-- Started enterDoctorDecisionStep");
        BaseOutput output = new BaseOutput();
        OperativeClaimBusinessIterator operativeClaimIterator = (OperativeClaimBusinessIterator) stationMap.get("OperativeClaimBusinessIterator");
        int operativeClaimsCount = 3;
        operativeClaimIterator.setup(output, operativeClaimsCount);

        List<Message> messages = new ArrayList<>();
        output.setMessages(messages);
        Claim process = new Claim();
        ProcessLog log = new ProcessLog();

        finalStation = toStation("OperativeClaimUpdater");
        AbstractModelFlyweight flyweight = new AbstractModelFlyweight(process, log, output, finalStation) {};

        stationMap.get("PhysicalDecisionCopier").handleService(flyweight);
        messages = output.getMessages();
        messages.forEach(msg -> System.out.println("Result code: " + msg.getResultCode() + " Description: " + msg.getResultDesc() ));
        System.out.println("-- Finished enterDoctorDecisionStep");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("");
        return output;
    }

    // This is main exit point for the SubFeature Station / Tab (one of `Clerk` | `DoctorDecision` | `Referent` | `Approval`  station)
    public BaseOutput endDoctorDecisionStep() {
        System.out.println("");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("-- Started endDoctorDecisionStep");
        BaseOutput output = new BaseOutput();
        List<Message> messages = new ArrayList<>();
        output.setMessages(messages);
        Claim process = new Claim();
        ProcessLog log = new ProcessLog();

        AbstractServiceStation toStation = toStation("HistoryCreator");
        AbstractModelFlyweight flyweight = new AbstractModelFlyweight(process, log, output, toStation) {};
        stationMap.get("PhysicalDecisionCopier").handleService(flyweight);
        messages = output.getMessages();
        messages.forEach(msg -> System.out.println("Result code: " + msg.getResultCode() + " Description: " + msg.getResultDesc() ));
        System.out.println("-- Finished endDoctorDecisionStep");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("");
        return output;
    }


}

