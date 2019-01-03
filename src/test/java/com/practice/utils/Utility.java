package com.practice.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Utility {

	public static String getProperty(String key) {
		try {
			String fileName = "src/test/resources/config.properties";
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			Properties properties = new Properties();
			properties.load(bufferedReader);
			return properties.getProperty(key);
		} catch (Exception e) {
			return null;
		}
	}

	public static void sendEmail() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		try {
			Session session = Session.getDefaultInstance(props, null);
			session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(Utility.getProperty("EMAIL_USERNAME")));
			msg.setSubject("Test Results");
			msg.setText("Please find test results", "ISO-8859-1");
			msg.setSentDate(new Date());
			msg.setHeader("content-Type", "text/html;charset=\"ISO-8859-1\"");
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Narasimhamurthy.NL@happiestminds.com"));
			msg.saveChanges();

/*			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Please find attachment of the same");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();
			String filename = "C:\\Users\\Narasimhamurthy.nl\\Documents\\Test.txt";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			msg.setContent(multipart);
*/
			Transport transport = session.getTransport("smtp");
			System.out.println(Utility.getProperty("EMAIL_USERNAME"));
			transport.connect(Utility.getProperty("EMAIL_USERNAME"), Utility.getProperty("EMAIL_PASSWORD"));
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}
