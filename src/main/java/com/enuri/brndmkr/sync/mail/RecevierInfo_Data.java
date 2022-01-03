package com.enuri.brndmkr.sync.mail;

public class RecevierInfo_Data {
	private String receiverAddr = "";
	private String receiverNm = "";
	
	public String getReceiverAddr() {
		return receiverAddr;
	}
	public void setReceiverAddr(String receiverAddr) {
		this.receiverAddr = receiverAddr;
	}
	public String getReciverNm() {
		return receiverNm;
	}
	public void setReciverNm(String reciverNm) {
		this.receiverNm = reciverNm;
	}
	
	@Override
	public String toString() {
		return "RecevierInfo_Data [receiverAddr=" + receiverAddr
				+ ", reciverNm=" + receiverNm + "]";
	}
	
	
}
