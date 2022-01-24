package com.enuri.brndmkr.sync.mail;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ErrorMail {


	/***************************************************************
	 * Exception 발생 시 관리자에게 Mail 보냄.
	 ***************************************************************/
	public ErrorMail(Exception e) {
		String receiverMailAddr = "";				//받는 사람 메일주소
		String receiverMailNm = "개발자";								//받는 사람 이름
		String mailTitle = "[그룹매칭_브랜드싱크] " + e.getMessage();		//타이틀
		String mailContents = "";									//내용

		mailContents = mailContents + "re : <br/> " + e.toString();
		mailContents = mailContents + "<br/><br/> re.getLocalizedMessage() : <br/> " + e.getLocalizedMessage();

		String sendMailAddr = "";			//보내는 사람 메일주소
		String sendMailNm = "개발자";							//보내는 사람 이름

		SendMail_Data sendMailData = new SendMail_Data();
		SendMail sendMail = new SendMail();

		sendMailData.setReceiverMailAddr(receiverMailAddr);
		sendMailData.setReceiverMailNm(receiverMailNm);

		sendMailData.setMailTitle(mailTitle);
		sendMailData.setMailContents(mailContents);
		sendMailData.setSendMailAddr(sendMailAddr);
		sendMailData.setSendMailNm(sendMailNm);

		try {
			// 첫번째 수신자 메일 발송
			sendMail.setHtmlMailSendProc(sendMailData);
		} catch (Exception e1) {
			log.error("", e1);
		}
	}

}
