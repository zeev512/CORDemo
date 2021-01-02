package il.co.migdal.ins.personalaccidents.doctor.station;

import il.co.migdal.ins.AbstractModelFlyweight;
import il.co.migdal.ins.common.services.BusinessServiceException;
import il.co.migdal.ins.personalaccidents.AbstractServiceStation;

public class TransactionPreparator extends AbstractServiceStation {

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



