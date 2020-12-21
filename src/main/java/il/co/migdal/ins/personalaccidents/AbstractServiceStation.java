package il.co.migdal.ins.personalaccidents;

import il.co.migdal.ins.common.BusinessServiceException;
import il.co.migdal.ins.common.BaseOutput;
import il.co.migdal.ins.common.Message;
import il.co.migdal.ins.services.ClaimProcess;
import il.co.migdal.ins.common.ProcessLog;

import java.util.List;

public abstract class AbstractServiceStation {

    AbstractServiceStation nextStation;

    /*AbstractServiceStation(AbstractServiceStation nextStation) {
        this.nextStation = nextStation;
    }*/

    public void setNextStation(AbstractServiceStation nextStation) {
        this.nextStation = nextStation;
    }

    public void handleService(ClaimProcess process, ProcessLog log, BaseOutput output) throws BusinessServiceException {
        if ( doService(process, log, output) && nextStation != null ) {
            nextStation.handleService(process, log, output);
        }
    }

    public boolean doService(ClaimProcess process, ProcessLog log, BaseOutput output) throws BusinessServiceException {
        Message msg = new Message();
        msg.setResultCode(0);
        msg.setResultDesc(this.getClass().getSimpleName() + " finished successfully");
        List<Message> messages = output.getMessages();
        messages.add(msg);
        output.setMessages(messages);
        return true;
    }

}

