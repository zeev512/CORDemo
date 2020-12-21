package il.co.migdal.ins.personalaccidents.doctor.service;

import il.co.migdal.ins.personalaccidents.model.ClaimPolicy;
import il.co.migdal.ins.personalaccidents.model.Period;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceExtention {

    Date startPeriod = new Date();
    Date endPeriod = new Date();

    @Inject
    OperativeClaimService operativeClaimService;

    public List<ClaimPolicy> getClaimPolicies() {
        return operativeClaimService.getClaimParticipatingPolicies();
    }

    public List<Period> calculatePeriods() {
        return operativeClaimService.calculatePeriods(startPeriod, endPeriod);
    }

}
