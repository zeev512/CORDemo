package il.co.migdal.ins;

import com.google.inject.Inject;
import il.co.migdal.ins.module.ApplicationInjector;
import il.co.migdal.ins.personalaccidents.doctor.PersonalAccidentsDoctorDecisionController;

public class ChainApplication {

    @Inject
    PersonalAccidentsDoctorDecisionController controller;


    public void start() {
        controller.enterDoctorDecisionStep();

    }
    public void end() {
        controller.endDoctorDecisionStep();
    }

    public static void main(String[] args) {
        ChainApplication app = ApplicationInjector.instance().getInstance(ChainApplication.class);
        app.start();
        app.end();
    }

}
