package il.co.migdal.ins.personalaccidents.policy.station;

import il.co.migdal.ins.AbstractModelFlyweight;
import il.co.migdal.ins.service.BusinessServiceException;
import il.co.migdal.ins.personalaccidents.AbstractServiceStation;

public class OccupationalDisabilityExpectedPeriodsMsgStation extends AbstractServiceStation {

    @Override
    public int index() {
        return 20;
    }

    @Override
    public AbstractServiceStation doService(AbstractModelFlyweight flyweight) throws BusinessServiceException {
        super.doService(flyweight);
        return this;
    }

}

