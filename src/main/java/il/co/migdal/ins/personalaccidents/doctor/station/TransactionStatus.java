package il.co.migdal.ins.personalaccidents.doctor.station;

import il.co.migdal.ins.common.BusinessServiceException;
import il.co.migdal.ins.common.BaseOutput;
import il.co.migdal.ins.services.ClaimProcess;
import il.co.migdal.ins.common.ProcessLog;

import il.co.migdal.ins.personalaccidents.AbstractServiceStation;

public class TransactionStatus extends AbstractServiceStation {

    /*TransactionStatus(AbstractServiceStation nextStation) {
        super(nextStation);
    }*/

    @Override
    public boolean doService(ClaimProcess process, ProcessLog log, BaseOutput output) throws BusinessServiceException {
        super.doService(process, log, output);
        return true;
    }

}


