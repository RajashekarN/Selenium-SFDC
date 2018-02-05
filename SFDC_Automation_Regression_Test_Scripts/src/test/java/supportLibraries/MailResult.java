package supportLibraries;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.cognizant.framework.Settings;

import pageObjects.LoginPage;


public class MailResult {     
	static Session session;
	private static Properties properties;

	public static String environment = System.getProperty("RunEnvironment");
	public static String initializeEnvironment() {
		try {
			if (environment.equals(null)) {

			}
		} catch (Exception e) {
			environment = properties.getProperty("RunEnvironment");
			System.out.println(
					"Environment is set as per the RunEnvironment value in Global Settings file:::" + environment);
		}
		return environment;
	}
	public static void emailSend(String msg) {
		properties = Settings.getInstance();
		String to = properties.getProperty("ToMail");
		String from = properties.getProperty("fromMailId");
		String host = properties.getProperty("mail.smtp.host");
		String port = properties.getProperty("mail.smtp.port");	  
		Properties systemProperties = System.getProperties();

		systemProperties.setProperty("mail.smtp.host", host);           
		systemProperties.setProperty("mail.smtp.port", port);
		try {
			session = Session.getInstance(properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}  
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		String sEnvironment = LoginPage.environment;
		if(sEnvironment==null) {
			sEnvironment = environment;
		}
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Global Salesforce Enterprise Salesforce Result Summary_" + sEnvironment + "_" + dateFormat.format(date));
			message.setContent(msg, "text/html");
			Transport.send(message);
			System.out.println("Mail triggered successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}	  
}

