/*package supportlibraries;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.commons.io.FileUtils;

import supportlibraries.api.ImageSplitter;
import supportlibraries.api.JunitFailureResultHelper;
import supportlibraries.api.WikiUpdater;

public class MailHelper {

	private static Properties gMailConfig = new Properties();

	public MailHelper() {
	}

	static {
		// sets SMTP server properties
//		try {
			gMailConfig = Utility_Functions.setCraftProperty();
//			gMailConfig.load(new FileInputStream("Global Settings.properties"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	
	public void sendMail(String mTo, String msg) {
		final String mFrom = gMailConfig.getProperty("mail.smtp.user");
		final String Password = gMailConfig.getProperty("mail.smtp.password");

		// System.out.println("PRINGINT G : "+ mFrom + Password);
		Session session = Session.getInstance(gMailConfig, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mFrom.substring(0, mFrom.indexOf("@")), Password);
			}
		});

		session.setDebug(false);
		try {
			Message message = new MimeMessage(session);
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(mFrom));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mTo));

			// Set Subject: header field
			message.setSubject("!!!Password Reset Alert!!!");

			msg = "<html><body>"+ msg + "</body></html>";
			message.setContent(msg, "text/html");
			// Now set the actual message
//			message.setText(msg);
			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	

	public void sendTestNGResult(String mTo, String mTitle, String directory, String fileName, String portalUrl,
			String updateWiki) throws Exception {

		final String mFrom = gMailConfig.getProperty("mail.smtp.user");
		final String Password = gMailConfig.getProperty("mail.smtp.password");

		// System.out.println("PRINGINT G : "+ mFrom + Password);
		Session session = Session.getInstance(gMailConfig, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mFrom.substring(0, mFrom.indexOf("@")), Password);
			}
		});

		session.setDebug(false);

		MimeMessage messageTLS = new MimeMessage(session);
		String FileName = (directory + File.separator + fileName)
				.substring((directory + File.separator + fileName).lastIndexOf(File.separator));
		// System.out.println("FileName : " + FileName);
		String imageFile = directory + File.separator + FileName + File.separator + FileName
				+ gMailConfig.getProperty("mailimagetype");
		try {
			messageTLS.setFrom(new InternetAddress(mFrom));
			MimeMultipart multipart = new MimeMultipart();
			messageTLS.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mTo));
			MimeBodyPart tmpBp1 = new MimeBodyPart();
			// MimeBodyPart tmpBp2 = new MimeBodyPart();

			int imgCount = 0;
			try {
				imgCount = new ImageSplitter().imageSplitter(new File(imageFile));
			} catch (Exception e) {
				e.printStackTrace();
			}

			
			 * Task to Calculate pass percentage value
			 
			JunitFailureResultHelper junit = new JunitFailureResultHelper(directory + File.separator + FileName);
			String passPercent = junit.getPassPercentage();
			// Set the title with pass percentages
			mTitle = "(" + passPercent.split(";")[0] + ") " + mTitle + " - " + passPercent.split(";")[1];

			try {
				// //Update Wiki Page in Dashboard
				if (updateWiki.equalsIgnoreCase("true")) {
					WikiUpdater wiki = new WikiUpdater();
					wiki.updateWikiPage(mTitle);
				}
			} catch (Exception e) {
				System.out.println("Failed to update Wiki Page");
			}

			messageTLS.setSubject(mTitle);

			String mText = "<html><body style='background-color:#282a2a'><a href=" + portalUrl + ">";
			for (int i = 0; i < imgCount; i++) {
				mText = mText + "<img src=\"cid:image" + i + "\">";
			}

			mText = mText + "</a></body></html>";
			tmpBp1.setContent(mText, "text/html");
			multipart.addBodyPart(tmpBp1);
			// String image =
			for (int i = 0; i < imgCount; i++) {
				DataSource image = new FileDataSource(
						directory + File.separator + FileName + File.separator + "img" + i + ".jpg");
				tmpBp1 = new MimeBodyPart();
				tmpBp1.setDataHandler(new DataHandler(image));
				tmpBp1.setHeader("Content-ID", "<image" + i + ">");
				multipart.addBodyPart(tmpBp1);
				FileUtils.forceDeleteOnExit(
						new File(directory + File.separator + FileName + File.separator + "img" + i + ".jpg"));
			}
			// Creating Attachment part of the message
			MimeBodyPart tmpBp3 = new MimeBodyPart();
			// attaching the file to the message
			FileDataSource fds = new FileDataSource(directory + File.separator + FileName + ".zip");
			tmpBp3.setDataHandler(new DataHandler(fds));
			tmpBp3.setFileName(fds.getName());
			multipart.addBodyPart(tmpBp3);
			messageTLS.setContent(multipart);

		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
			FileUtils.forceDeleteOnExit(new File(imageFile));
		}

		// Transport transportTLS;
		try {
			Transport.send(messageTLS);
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException ex) {
			System.err.println("Cannot send email. " + ex);
		}

	}

	*//**
	 * send html e-mail method
	 * 
	 * @arg in sequences To, Subject, Directory, Filename
	 *
	 *//*
	public static void main(String[] args) {

		String mailTo = args[0];
		String subject = args[1];
		String directoryName = args[2];
		String fileName = args[3];
		String portalUrl = args[4];
		String updateWiki = args[5];
		// System.out.println("Printing Into test: ");
		if (updateWiki == null) {
			updateWiki = "false";
		}
		MailHelper mailer = new MailHelper();

		try {
			mailer.sendTestNGResult(mailTo, subject, directoryName, fileName, portalUrl, updateWiki);
			System.out.println("Email sent.");
		} catch (Exception ex) {
			System.out.println("Failed to sent email.");
			ex.printStackTrace();
		}
	}
}
*/