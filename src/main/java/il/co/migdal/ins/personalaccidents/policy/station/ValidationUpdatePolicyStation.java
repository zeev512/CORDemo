package il.co.migdal.ins.personalaccidents.policy.station;

import il.co.migdal.ins.AbstractModelFlyweight;
import il.co.migdal.ins.service.BusinessServiceException;
import il.co.migdal.ins.model.BaseOutput;
import il.co.migdal.ins.personalaccidents.AbstractServiceStation;
import il.co.migdal.ins.model.Claim;
import il.co.migdal.ins.util.ProcessLog;

public class ValidationUpdatePolicyStation extends AbstractServiceStation {

    @Override
    public int index() {
        return 1;
    }

    @Override
    public AbstractServiceStation doService(AbstractModelFlyweight flyweight) throws BusinessServiceException {
        super.doService(flyweight);
        return this;
    }

}

