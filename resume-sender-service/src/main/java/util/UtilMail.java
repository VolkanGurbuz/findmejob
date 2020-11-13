package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

public class UtilMail {

  private UtilMail() {
    throw new IllegalStateException("Utility class");
  }

  private static Logger logger = LoggerFactory.getLogger(UtilMail.class);

  public static Session getSession(Properties prop, String mail, String mailPass) {

    return Session.getInstance(
        prop,
        new Authenticator() {
          @Override
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(mail, mailPass);
          }
        });
  }

  public static void sendmail(Session session, String to) {
    try {
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(Constants.PERSONAL_EMAIL));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
      message.setSubject(Constants.EMAIL_TITLE);

      BodyPart mimeBodyPart = new MimeBodyPart();
      mimeBodyPart.setContent(Constants.EMAIL_BODY, "text/html");

      String filename = "resume-sender-service/src/main/resources/resume.pdf";
      DataSource source = new FileDataSource(filename);
      mimeBodyPart.setDataHandler(new DataHandler(source));
      mimeBodyPart.setFileName(filename);

      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(mimeBodyPart);
      message.setContent(multipart);

      Transport.send(message);
    } catch (Exception e) {
      logger.error("sendmail", e);
    }
  }

  public static Properties getProperties() {
    try {
      Properties prop = new Properties();
      prop.put("mail.smtp.auth", true);
      prop.put("mail.smtp.starttls.enable", true);
      prop.put("mail.smtp.host", "smtp.gmail.com");
      prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
      prop.put("mail.smtp.port", "25");
      return prop;
    } catch (Exception e) {
      logger.error("getProperties", e);
      return null;
    }
  }
}
