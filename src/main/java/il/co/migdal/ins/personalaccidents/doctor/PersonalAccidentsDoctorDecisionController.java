package il.co.migdal.ins.personalaccidents.doctor;

import il.co.migdal.ins.common.BusinessServiceException;
import il.co.migdal.ins.common.BaseOutput;
import il.co.migdal.ins.common.Message;
import il.co.migdal.ins.personalaccidents.AbstractServiceStation;
import il.co.migdal.ins.services.ClaimProcess;
import il.co.migdal.ins.common.ProcessLog;

import com.google.inject.Inject;
import il.co.migdal.ins.personalaccidents.AbstractController;
import il.co.migdal.ins.personalaccidents.doctor.station.*;

import java.util.*;

public class PersonalAccidentsDoctorDecisionController extends AbstractController {

    /*@Inject
    public void setStations(Set<AbstractServiceStation> stations) {
        this.stations = stations;
        this.stations.stream().forEach(station -> stationMap.put(station.getClass().getSimpleName(), station));
        setupChain();
    }*/

    @Override
    public void setupChain() {
        PhysicalDecisionCopier physicalDecisionCopier = (PhysicalDecisionCopier) stationMap.get("PhysicalDecisionCopier");
        TransactionPreparator transactionPreparator = (TransactionPreparator) stationMap.get("TransactionPreparator");
        TransactionCaller transactionCaller = (TransactionCaller) stationMap.get("TransactionCaller");
        TransactionStatus transactionStatus = (TransactionStatus) stationMap.get("TransactionStatus");
        HistoryCreator historyCreator = (HistoryCreator) stationMap.get("HistoryCreator");
        InjuryHistoryCreator injuryHistoryCreator = (InjuryHistoryCreator) stationMap.get("InjuryHistoryCreator");
        OperativeClaimUpdater operativeClaimUpdater = (OperativeClaimUpdater) stationMap.get("OperativeClaimUpdater");

        physicalDecisionCopier.setNextStation(transactionPreparator);
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
        List<Message> messages = new ArrayList<Message>();
        output.setMessages(messages);
        ClaimProcess process = new ClaimProcess();
        ProcessLog log = new ProcessLog();
        stationMap.get("PhysicalDecisionCopier").handleService(process, log, output);
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
        ClaimProcess process = new ClaimProcess();
        ProcessLog log = new ProcessLog();
        stationMap.get("PhysicalDecisionCopier").handleService(process, log, output);
        messages = output.getMessages();
        messages.forEach(msg -> System.out.println("Result code: " + msg.getResultCode() + " Description: " + msg.getResultDesc() ));
        System.out.println("-- Finished endDoctorDecisionStep");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("");
        return output;
    }

}
