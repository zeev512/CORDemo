package il.co.migdal.ins.personalaccidents.doctor.service;

import il.co.migdal.ins.personalaccidents.model.ClaimPolicy;
import il.co.migdal.ins.personalaccidents.model.Period;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperativeClaimService {

    private List<ClaimPolicy> policies = new ArrayList<ClaimPolicy>();

    public List<ClaimPolicy> getClaimParticipatingPolicies() {
        if ( policies.size() == 0 ) {
            ClaimPolicy policy = new ClaimPolicy();
            policies.add(policy);
        }
        return policies;
    }


    public List<Period> calculatePeriods(Date start, Date end) {
        Period period = new Period(start, end);
        List<Period> periods = new ArrayList<Period>();
        periods.add(period);
        return periods;
    }

}

