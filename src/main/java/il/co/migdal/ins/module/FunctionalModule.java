package il.co.migdal.ins.module;


import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;
import il.co.migdal.ins.personalaccidents.AbstractServiceStation;
import il.co.migdal.ins.personalaccidents.doctor.PersonalAccidentsDoctorDecisionController;
// import il.co.migdal.ins.iterator.life.Stations;
// import il.co.migdal.ins.iterator.life.AbstractStationsIterator;
import il.co.migdal.ins.iterator.operative.OperativeClaimBusinessIterator;
import il.co.migdal.ins.personalaccidents.doctor.station.*;
import il.co.migdal.ins.personalaccidents.policy.PersonalAccidentsPolicyController;
import il.co.migdal.ins.personalaccidents.policy.station.*;

public class FunctionalModule extends AbstractModule {
    @Override
    protected void configure() {

        bind(PersonalAccidentsDoctorDecisionController.class).in(Singleton.class);
        bind(PersonalAccidentsPolicyController.class).in(Singleton.class);
        // bind(Stations.class).in(Singleton.class);
        // bind(AbstractStationsIterator.class).in(Singleton.class);

        Multibinder<AbstractServiceStation> multibinder = Multibinder.newSetBinder(binder(), AbstractServiceStation.class);
        multibinder.addBinding().to(HistoryCreator.class).in(Singleton.class);
        multibinder.addBinding().to(OperativeClaimBusinessIterator.class).in(Singleton.class);
        multibinder.addBinding().to(InjuryHistoryCreator.class).in(Singleton.class);
        multibinder.addBinding().to(OperativeClaimUpdater.class).in(Singleton.class);
        multibinder.addBinding().to(PhysicalDecisionCopier.class).in(Singleton.class);
        multibinder.addBinding().to(TransactionCaller.class).in(Singleton.class);
        multibinder.addBinding().to(TransactionPreparator.class).in(Singleton.class);
        multibinder.addBinding().to(TransactionStatus.class).in(Singleton.class);

        multibinder.addBinding().to(ValidationEnterStation.class).in(Singleton.class);
        multibinder.addBinding().to(ValidationUpdatePolicyStation.class).in(Singleton.class);
        multibinder.addBinding().to(PolicyBusinessIteratorStation.class).in(Singleton.class);
        multibinder.addBinding().to(OccupationalDisabilityClaimParticipatingNumStation.class).in(Singleton.class);
        multibinder.addBinding().to(PolicyDataIteratorStation.class).in(Singleton.class);
        multibinder.addBinding().to(ClaimTypeStation.class).in(Singleton.class);
        multibinder.addBinding().to(CoverageStation.class).in(Singleton.class);
        multibinder.addBinding().to(RemarkStation.class).in(Singleton.class);
        multibinder.addBinding().to(FundStation.class).in(Singleton.class);
        multibinder.addBinding().to(PolicyStatusStation.class).in(Singleton.class);
        multibinder.addBinding().to(PolicyVersionStation.class).in(Singleton.class);
        multibinder.addBinding().to(PolicyParagraphUpdaterStation.class).in(Singleton.class);
        multibinder.addBinding().to(OccupationalDisabilityHistoryDataStation.class).in(Singleton.class);
        multibinder.addBinding().to(HistoricalPhysicianDecisionLoaderStation.class).in(Singleton.class);
        multibinder.addBinding().to(IrregularMarkStation.class).in(Singleton.class);
        multibinder.addBinding().to(Tc0000n3Station.class).in(Singleton.class);
        multibinder.addBinding().to(OccupationalDisabilityLastPaymentStation.class).in(Singleton.class);
        multibinder.addBinding().to(OccupationalDisabilityPreviousCompensationPeriodsStation.class).in(Singleton.class);
        multibinder.addBinding().to(OccupationalDisabilityExpectedPeriodsMsgStation.class).in(Singleton.class);
        multibinder.addBinding().to(Gvi089n0Station.class).in(Singleton.class);
        multibinder.addBinding().to(InfoMessageStation.class).in(Singleton.class);
        multibinder.addBinding().to(NextStepSelectorStation.class).in(Singleton.class);
        multibinder.addBinding().to(EnterPolicyEndStation.class).in(Singleton.class);




    }

}


