package il.co.migdal.ins.module;


import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;
import il.co.migdal.ins.personalaccidents.AbstractServiceStation;
import il.co.migdal.ins.personalaccidents.doctor.PersonalAccidentsDoctorDecisionController;
import il.co.migdal.ins.personalaccidents.doctor.service.OperativeClaimService;
import il.co.migdal.ins.personalaccidents.doctor.service.ServiceExtention;
import il.co.migdal.ins.personalaccidents.doctor.station.*;

public class FunctionalModule extends AbstractModule {
    @Override
    protected void configure() {
        /*bind(HistoryCreator.class).annotatedWith(Implementation.class).to(HistoryCreator.class);
        bind(InjuryHistoryCreator.class).annotatedWith(Implementation.class).to(InjuryHistoryCreator.class);
        bind(OperativeClaimUpdater.class).annotatedWith(Implementation.class).to(OperativeClaimUpdater.class);
        bind(PhysicalDecisionCopier.class).annotatedWith(Implementation.class).to(PhysicalDecisionCopier.class);
        bind(TransactionCaller.class).annotatedWith(Implementation.class).to(TransactionCaller.class);
        bind(TransactionPreparator.class).annotatedWith(Implementation.class).to(TransactionPreparator.class);
        bind(TransactionStatus.class).annotatedWith(Implementation.class).to(TransactionStatus.class);*/

        bind(PersonalAccidentsDoctorDecisionController.class).in(Singleton.class);
        bind(ServiceExtention.class);
        bind(OperativeClaimService.class);

        Multibinder<AbstractServiceStation> multibinder = Multibinder.newSetBinder(binder(), AbstractServiceStation.class);
        multibinder.addBinding().toInstance(new HistoryCreator());
        multibinder.addBinding().toInstance(new InjuryHistoryCreator());
        multibinder.addBinding().to(OperativeClaimUpdater.class).in(Singleton.class);
        multibinder.addBinding().to(PhysicalDecisionCopier.class).in(Singleton.class);
        multibinder.addBinding().to(TransactionCaller.class).in(Singleton.class);
        multibinder.addBinding().to(TransactionPreparator.class).in(Singleton.class);
        multibinder.addBinding().to(TransactionStatus.class).in(Singleton.class);
    }

}


