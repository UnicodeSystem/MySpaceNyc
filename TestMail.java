package dd_rough;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import dd_util.TestConfig;
import dd_util.monitoringMail;

public class TestMail {

	public static void main(String[] args) throws AddressException, MessagingException {

		monitoringMail mail = new monitoringMail();
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody,
				TestConfig.attachmentPath, TestConfig.attachmentName);

	}

}
