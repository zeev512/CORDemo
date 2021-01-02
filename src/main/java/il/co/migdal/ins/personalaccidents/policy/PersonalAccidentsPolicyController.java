package il.co.migdal.ins.personalaccidents.policy;

import il.co.migdal.ins.AbstractModelFlyweight;
import il.co.migdal.ins.iterator.operative.OperativeClaimBusinessIterator;
import il.co.migdal.ins.jtopen.BaseOutput;
import il.co.migdal.ins.jtopen.Message;
import il.co.migdal.ins.personalaccidents.AbstractController;
import il.co.migdal.ins.personalaccidents.AbstractServiceStation;
import il.co.migdal.ins.personalaccidents.policy.station.*;
import il.co.migdal.ins.services.businessProcess.claims.ClaimProcess;
import il.co.migdal.ins.util.log.ProcessLog;

import java.util.ArrayList;
import java.util.List;

public class PersonalAccidentsPolicyController  extends AbstractController {

    public enum StationMapper {
        ValidationEnterStation(0),
        ValidationUpdatePolicyStation(1),
        PolicyBusinessIteratorStation(2),
        UpdatePolicyFromTvio00n2Station(3),
        PopulateModelFromTvio00n2Station(4),
        OccupationalDisabilityClaimParticipatingNumStation(5),
        PolicyDataIteratorStation(6),
        ClaimTypeStation(7),
        CoverageStation(8),
        RemarkStation(9),
        FundStation(10),
        PolicyStatusStation(11),
        PolicyVersionStation(12),
        PolicyParagraphUpdaterStation(13),
        OccupationalDisabilityHistoryDataStation(14),
        HistoricalPhysicianDecisionLoaderStation(15),
        IrregularMarkStation(16),
        Tc0000n3Station(17),
        OccupationalDisabilityLastPaymentStation(18),
        OccupationalDisabilityPreviousCompensationPeriodsStation(19),
        OccupationalDisabilityExpectedPeriodsMsgStation(20),
        Gvi089n0Station(21),
        InfoMessageStation(22),
        NextStepSelectorStation(23),
        EnterPolicyEndStation(24);

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
        ValidationEnterStation validationEnterStation = (ValidationEnterStation) stationMap.get(ValidationEnterStation.class.getSimpleName());
        ValidationUpdatePolicyStation validationUpdatePolicyStation = (ValidationUpdatePolicyStation) stationMap.get(ValidationUpdatePolicyStation.class.getSimpleName());
        PolicyBusinessIteratorStation iteratorStation = (PolicyBusinessIteratorStation) stationMap.get(PolicyBusinessIteratorStation.class.getSimpleName());
        OccupationalDisabilityClaimParticipatingNumStation odClaimParticipatingStation = (OccupationalDisabilityClaimParticipatingNumStation) stationMap.get(OccupationalDisabilityClaimParticipatingNumStation.class.getSimpleName());
        PolicyDataIteratorStation policyDataIteratorStation = (PolicyDataIteratorStation) stationMap.get(PolicyDataIteratorStation.class.getSimpleName());
        ClaimTypeStation claimTypeStation = (ClaimTypeStation) stationMap.get(ClaimTypeStation.class.getSimpleName());
        CoverageStation coverageStation = (CoverageStation) stationMap.get(CoverageStation.class.getSimpleName());
        RemarkStation remarkStation = (RemarkStation) stationMap.get(RemarkStation.class.getSimpleName());
        FundStation fundStation = (FundStation) stationMap.get(FundStation.class.getSimpleName());
        PolicyStatusStation policyStatusStation = (PolicyStatusStation) stationMap.get(PolicyStatusStation.class.getSimpleName());
        PolicyVersionStation policyVersionStation = (PolicyVersionStation) stationMap.get(PolicyVersionStation.class.getSimpleName());
        PolicyParagraphUpdaterStation policyParagraphUpdaterStation = (PolicyParagraphUpdaterStation) stationMap.get(PolicyParagraphUpdaterStation.class.getSimpleName());
        OccupationalDisabilityHistoryDataStation odHistoryDataStation = (OccupationalDisabilityHistoryDataStation) stationMap.get(OccupationalDisabilityHistoryDataStation.class.getSimpleName());
        HistoricalPhysicianDecisionLoaderStation historicalPhysicianDecisionLoaderStation = (HistoricalPhysicianDecisionLoaderStation) stationMap.get(HistoricalPhysicianDecisionLoaderStation.class.getSimpleName());
        IrregularMarkStation irregularMarkStation = (IrregularMarkStation) stationMap.get(IrregularMarkStation.class.getSimpleName());
        Tc0000n3Station tc0000n3Station = (Tc0000n3Station) stationMap.get(Tc0000n3Station.class.getSimpleName());
        OccupationalDisabilityLastPaymentStation odLastPaymentStation = (OccupationalDisabilityLastPaymentStation) stationMap.get(OccupationalDisabilityLastPaymentStation.class.getSimpleName());
        OccupationalDisabilityPreviousCompensationPeriodsStation odPreviousCompensationPeriodsStation = (OccupationalDisabilityPreviousCompensationPeriodsStation) stationMap.get(OccupationalDisabilityPreviousCompensationPeriodsStation.class.getSimpleName());
        OccupationalDisabilityExpectedPeriodsMsgStation odExpectedPeriodsMsgStation = (OccupationalDisabilityExpectedPeriodsMsgStation) stationMap.get(OccupationalDisabilityExpectedPeriodsMsgStation.class.getSimpleName());
        Gvi089n0Station gvi089n0Station = (Gvi089n0Station) stationMap.get(Gvi089n0Station.class.getSimpleName());
        InfoMessageStation infoMessageStation = (InfoMessageStation) stationMap.get(InfoMessageStation.class.getSimpleName());
        NextStepSelectorStation nextStepSelectorStation = (NextStepSelectorStation) stationMap.get(NextStepSelectorStation.class.getSimpleName());
        EnterPolicyEndStation enterPolicyEndStation = (EnterPolicyEndStation) stationMap.get(EnterPolicyEndStation.class.getSimpleName());

        validationEnterStation.setNextStation(validationUpdatePolicyStation);
        validationUpdatePolicyStation.setNextStation(iteratorStation);
        iteratorStation.setNextStation(odClaimParticipatingStation);
        odClaimParticipatingStation.setNextStation(policyDataIteratorStation);
        policyDataIteratorStation.setNextStation(claimTypeStation);
        claimTypeStation.setNextStation(coverageStation);
        coverageStation.setNextStation(remarkStation);
        remarkStation.setNextStation(fundStation);
        fundStation.setNextStation(policyStatusStation);
        policyStatusStation.setNextStation(policyVersionStation);
        policyVersionStation.setNextStation(policyParagraphUpdaterStation);
        policyParagraphUpdaterStation.setNextStation(odHistoryDataStation);
        odHistoryDataStation.setNextStation(historicalPhysicianDecisionLoaderStation);
        historicalPhysicianDecisionLoaderStation.setNextStation(irregularMarkStation);
        irregularMarkStation.setNextStation(tc0000n3Station);
        tc0000n3Station.setNextStation(odLastPaymentStation);
        odLastPaymentStation.setNextStation(odPreviousCompensationPeriodsStation);
        odPreviousCompensationPeriodsStation.setNextStation(odExpectedPeriodsMsgStation);
        odExpectedPeriodsMsgStation.setNextStation(gvi089n0Station);
        gvi089n0Station.setNextStation(infoMessageStation);
        infoMessageStation.setNextStation(nextStepSelectorStation);
        nextStepSelectorStation.setNextStation(enterPolicyEndStation);

    }

    public BaseOutput enterPolicyStep() {
        System.out.println("");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("-- Started enterPolicyStep");
        BaseOutput output = new BaseOutput();
        // PolicyDataIteratorStation operativeClaimIterator = (PolicyDataIteratorStation) stationMap.get("OperativeClaimBusinessIterator");
        // operativeClaimIterator.setup(output);

        List<Message> messages = new ArrayList<>();
        output.setMessages(messages);
        ClaimProcess process = new ClaimProcess();
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

}


