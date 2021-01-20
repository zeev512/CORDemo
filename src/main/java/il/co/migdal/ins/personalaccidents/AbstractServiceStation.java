package il.co.migdal.ins.personalaccidents;

import il.co.migdal.ins.AbstractModelFlyweight;
import il.co.migdal.ins.service.BusinessServiceException;
import il.co.migdal.ins.model.BaseOutput;
import il.co.migdal.ins.model.Message;

import java.util.List;

public abstract class AbstractServiceStation {

    protected AbstractServiceStation nextStation;
    boolean failed = false;
    int ind;

    public abstract int index();

    /*AbstractServiceStation(AbstractServiceStation nextStation) {
        this.nextStation = nextStation;
    }*/

    public AbstractServiceStation getNextStation() {
        return nextStation;
    }

    public void setNextStation(AbstractServiceStation nextStation) {
        this.nextStation = nextStation;
    }


    // public int handleService(ClaimProcess process, ProcessLog log, BaseOutput output) throws BusinessServiceException {
    public BaseOutput handleService(AbstractModelFlyweight flyweight) throws BusinessServiceException {
        if ( !flyweight.toStation.equals(this) && !doService(flyweight).failed && nextStation != null ) {
            return nextStation.handleService(flyweight);
        }
        return flyweight.output;
    }

    public AbstractServiceStation doService(AbstractModelFlyweight flyweight) throws BusinessServiceException {
        Message msg = new Message();
        msg.setResultCode(0);
        msg.setResultDesc(this.getClass().getSimpleName() + " finished successfully");
        List<Message> messages = flyweight.output.getMessages();
        messages.add(msg);
        flyweight.output.setMessages(messages);
        flyweight.output.station = this.getClass().getSimpleName();
        return this;
    }

}

