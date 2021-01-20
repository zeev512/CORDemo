package il.co.migdal.ins.iterator.operative;

import il.co.migdal.ins.AbstractModelFlyweight;
import il.co.migdal.ins.model.BaseOutput;
import il.co.migdal.ins.model.Claim;
import il.co.migdal.ins.personalaccidents.AbstractServiceStation;
import il.co.migdal.ins.util.ProcessLog;

public class OperativeClaimFlyweight extends AbstractModelFlyweight {
    public OperativeClaimFlyweight(Claim process, ProcessLog processLog, BaseOutput output, AbstractServiceStation toStation) {
        super(process, processLog, output, toStation);
    }

}
