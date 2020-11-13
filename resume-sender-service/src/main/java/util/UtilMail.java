package util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class UtilMail {

  private UtilMail() {
    throw new IllegalStateException("Utility class");
  }

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

  public static void sendmail(Session session) throws MessagingException {

    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress("julyenl16@gmail.com"));
    message.setRecipients(
        Message.RecipientType.TO, InternetAddress.parse("volkangurbuz16@gmail.com"));
    message.setSubject("Mail Subject");

    String msg = "This is my first email using JavaMailer";

    MimeBodyPart mimeBodyPart = new MimeBodyPart();
    mimeBodyPart.setContent(msg, "text/html");

    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(mimeBodyPart);

    message.setContent(multipart);

    Transport.send(message);
  }
}
