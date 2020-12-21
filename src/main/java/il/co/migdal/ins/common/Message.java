package il.co.migdal.ins.common;

public class Message {
    public static int ERROR_LEVEL = 1;
    public static int WORNING_LEVEL = 2;

    private int resultCode;
    private String resultDesc;
    private int level;
    private int messageId;
    private int refId;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getRefId() {
        return refId;
    }

    public void setRefId(int refId) {
        this.refId = refId;
    }

    public void setMessage(String message) {
        this.resultDesc = message;
    }


}
