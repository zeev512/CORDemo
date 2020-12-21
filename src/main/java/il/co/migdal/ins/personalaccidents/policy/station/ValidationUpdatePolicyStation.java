package il.co.migdal.ins.personalaccidents.policy.station;


import il.co.migdal.ins.common.BusinessServiceException;
import il.co.migdal.ins.common.BaseOutput;
import il.co.migdal.ins.personalaccidents.AbstractServiceStation;
import il.co.migdal.ins.services.ClaimProcess;
import il.co.migdal.ins.common.ProcessLog;

public class ValidationUpdatePolicyStation extends AbstractServiceStation {

    @Override
    public boolean doService(ClaimProcess process, ProcessLog log, BaseOutput output) throws BusinessServiceException {
        super.doService(process, log, output);
        return true;
    }

}

