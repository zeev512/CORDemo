package il.co.migdal.ins;

import com.google.inject.Inject;
import il.co.migdal.ins.module.ApplicationInjector;
import il.co.migdal.ins.personalaccidents.doctor.PersonalAccidentsDoctorDecisionController;
import il.co.migdal.ins.personalaccidents.policy.PersonalAccidentsPolicyController;

public class ChainApplication {

    @Inject
    PersonalAccidentsDoctorDecisionController doctorController;

    @Inject
    PersonalAccidentsPolicyController policyController;

    public void start() {
        doctorController.enterDoctorDecisionStep();
        policyController.enterPolicyStep();

    }
    public void end() {
        doctorController.endDoctorDecisionStep();
    }

    public static void main(String[] args) {
        ChainApplication app = ApplicationInjector.instance().getInstance(ChainApplication.class);
        app.start();
        app.end();
    }

}
