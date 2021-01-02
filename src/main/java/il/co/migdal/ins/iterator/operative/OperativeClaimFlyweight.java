package il.co.migdal.ins.iterator.operative;

import il.co.migdal.ins.AbstractModelFlyweight;
import il.co.migdal.ins.jtopen.BaseOutput;
import il.co.migdal.ins.services.businessProcess.claims.ClaimProcess;
import il.co.migdal.ins.personalaccidents.AbstractServiceStation;
import il.co.migdal.ins.util.log.ProcessLog;

public class OperativeClaimFlyweight extends AbstractModelFlyweight {
    public OperativeClaimFlyweight(ClaimProcess process, ProcessLog processLog, BaseOutput output, AbstractServiceStation toStation) {
        super(process, processLog, output, toStation);
    }

}
