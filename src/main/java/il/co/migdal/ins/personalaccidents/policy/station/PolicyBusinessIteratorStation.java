package il.co.migdal.ins.personalaccidents.policy.station;

import il.co.migdal.ins.AbstractModelFlyweight;
import il.co.migdal.ins.common.services.BusinessServiceException;
import il.co.migdal.ins.jtopen.BaseOutput;
import il.co.migdal.ins.personalaccidents.AbstractServiceStation;
import il.co.migdal.ins.services.businessProcess.claims.ClaimProcess;
import il.co.migdal.ins.util.log.ProcessLog;

public class PolicyBusinessIteratorStation extends AbstractServiceStation {

    @Override
    public int index() {
        return 2;
    }

    @Override
    public AbstractServiceStation doService(AbstractModelFlyweight flyweight) throws BusinessServiceException {
        super.doService(flyweight);
        return this;
    }

}

