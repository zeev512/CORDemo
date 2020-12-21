package il.co.migdal.ins.personalaccidents.doctor.station;

import il.co.migdal.ins.common.BusinessServiceException;
import il.co.migdal.ins.common.BaseOutput;
import il.co.migdal.ins.personalaccidents.AbstractServiceStation;
import il.co.migdal.ins.personalaccidents.doctor.service.ServiceExtention;
import il.co.migdal.ins.personalaccidents.model.ClaimPolicy;
import il.co.migdal.ins.personalaccidents.model.Period;
import il.co.migdal.ins.services.ClaimProcess;
import il.co.migdal.ins.common.ProcessLog;

import javax.inject.Inject;
import java.util.List;

public class HistoryCreator extends AbstractServiceStation {

    /*HistoryCreator(AbstractServiceStation nextStation) {
        super(nextStation);
    }*/

    @Inject
    ServiceExtention serviceExtention;

    @Override
    public boolean doService(ClaimProcess process, ProcessLog log, BaseOutput output) throws BusinessServiceException {
        super.doService(process, log, output);
        List<ClaimPolicy> policies = serviceExtention.getClaimPolicies();
        if ( policies.size() == 0 ) {
            return false;
        }
        List<Period> periods = serviceExtention.calculatePeriods();
        return true;
    }

}

