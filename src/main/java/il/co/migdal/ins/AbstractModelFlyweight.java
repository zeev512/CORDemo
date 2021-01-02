package il.co.migdal.ins;

import il.co.migdal.ins.jtopen.BaseOutput;
import il.co.migdal.ins.services.businessProcess.claims.ClaimProcess;
import il.co.migdal.ins.personalaccidents.AbstractServiceStation;
import il.co.migdal.ins.util.log.ProcessLog;

public abstract class AbstractModelFlyweight {
    public ClaimProcess process;
    public ProcessLog processLog;
    public BaseOutput output;
    public AbstractServiceStation toStation;

    public AbstractModelFlyweight(ClaimProcess process, ProcessLog processLog, BaseOutput output, AbstractServiceStation toStation) {
        this.process = process;
        this.processLog = processLog;
        this.output = output;
        this.toStation = toStation;
    }

}
