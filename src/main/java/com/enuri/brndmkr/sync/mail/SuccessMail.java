package com.enuri.brndmkr.sync.mail;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SuccessMail {


	/***************************************************************
	 * 성공 메일
	 ***************************************************************/
	public void sendMail(String msg) {
		String receiverMailAddr = "";					//받는 사람 메일주소
		String receiverMailNm = "개발자";										//받는 사람 이름
		String mailTitle = "[그룹매칭_브랜드/제조사 싱크] SUCCESS";	//타이틀
		String mailContents = "";											//내용

		mailContents = msg;

		String sendMailAddr = "";						//보내는 사람 메일주소
		String sendMailNm = "개발자";											//보내는 사람 이름

		SendMail_Data sendMailData = new SendMail_Data();
		SendMail sendMail = new SendMail();

		sendMailData.setReceiverMailAddr(receiverMailAddr);
		sendMailData.setReceiverMailNm(receiverMailNm);
		sendMailData.setMailTitle(mailTitle);
		sendMailData.setMailContents(mailContents);
		sendMailData.setSendMailAddr(sendMailAddr);
		sendMailData.setSendMailNm(sendMailNm);

		try {
			sendMail.setHtmlMailSendProc(sendMailData);

			//참고 두번째 수신인 강제 적용 : 많이 안 넣게 설계함
			sendMailData.setReceiverMailAddr("");
			sendMailData.setReceiverMailNm("담당자1");
			sendMail.setHtmlMailSendProc(sendMailData);

			//참고 세번째 수신인 강제 적용 : 많이 안 넣게 설계함
			sendMailData.setReceiverMailAddr("");
			sendMailData.setReceiverMailNm("담당자2");
			sendMail.setHtmlMailSendProc(sendMailData);

		} catch (Exception e) {
			log.error("", e);
		}
	}
}
