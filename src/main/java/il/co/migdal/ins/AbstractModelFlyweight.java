package il.co.migdal.ins;

import il.co.migdal.ins.model.BaseOutput;
import il.co.migdal.ins.model.BaseProcess;
import il.co.migdal.ins.personalaccidents.AbstractServiceStation;
import il.co.migdal.ins.util.ProcessLog;

public abstract class AbstractModelFlyweight {
    public BaseProcess process;
    public ProcessLog processLog;
    public BaseOutput output;
    public AbstractServiceStation toStation;

    public AbstractModelFlyweight(BaseProcess process, ProcessLog processLog, BaseOutput output, AbstractServiceStation toStation) {
        this.process = process;
        this.processLog = processLog;
        this.output = output;
        this.toStation = toStation;
    }

}
