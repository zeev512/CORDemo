package il.co.migdal.ins.model;

import java.util.List;

public class BaseOutput {
	public static int FAILED = -99;
	public static int SUCCESS = 0;

	private int resultCode;
	private String resultDesc;
	public int ind = -1;
	public String station;

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	List<Message> messages;

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

}
