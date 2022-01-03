package com.enuri.brndmkr.sync.mail;

import java.util.ArrayList;
import java.util.List;

public class SendMail_Data {
	String receiverMailAddr = "";	//받는 사람 메일주소
	String receiverMailNm = "";		//받는 사람 이름
	String mailTitle = "";			//타이틀
	String mailContents = "";		//내용 
	String sendMailAddr = "";		//보내는 사람 메일주소
	String sendMailNm = "";			//보내는 사람 이름
	
	List<RecevierInfo_Data> recevierList = new ArrayList<RecevierInfo_Data>();	//추가 수신자 데이터를 ArrayList로 담아온다. 
	
	public String getReceiverMailAddr() {
		return receiverMailAddr;
	}
	public void setReceiverMailAddr(String receiverMailAddr) {
		this.receiverMailAddr = receiverMailAddr;
	}
	public String getReceiverMailNm() {
		return receiverMailNm;
	}
	public void setReceiverMailNm(String receiverMailNm) {
		this.receiverMailNm = receiverMailNm;
	}
	public String getMailTitle() {
		return mailTitle;
	}
	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}
	public String getMailContents() {
		return mailContents;
	}
	public void setMailContents(String mailContents) {
		this.mailContents = mailContents;
	}
	public List<RecevierInfo_Data> getRecevierList() {
		return recevierList;
	}
	public void setRecevierList(List<RecevierInfo_Data> recevierList) {
		this.recevierList = recevierList;
	}
	
	@Override
	public String toString() {
		return "SendMail_Data [receiverMailAddr=" + receiverMailAddr
				+ ", receiverMailNm=" + receiverMailNm + ", mailTitle="
				+ mailTitle + ", mailContents=" + mailContents
				+ ", sendMailAddr=" + sendMailAddr + ", sendMailNm="
				+ sendMailNm + ", recevierList=" + recevierList + "]";
	}
	public String getSendMailAddr() {
		return sendMailAddr;
	}
	public void setSendMailAddr(String sendMailAddr) {
		this.sendMailAddr = sendMailAddr;
	}
	public String getSendMailNm() {
		return sendMailNm;
	}
	public void setSendMailNm(String sendMailNm) {
		this.sendMailNm = sendMailNm;
	}

}
