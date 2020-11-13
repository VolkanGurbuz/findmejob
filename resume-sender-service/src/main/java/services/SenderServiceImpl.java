package services;

import model.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.UtilMail;

import javax.mail.Session;
import java.util.List;

public class SenderServiceImpl implements SenderService {

  private Logger logger = LoggerFactory.getLogger(SenderServiceImpl.class);

  @Override
  public void sendResume(List<Email> jobList, Session session) {
    try {

      jobList.forEach(
          email -> {
            UtilMail.sendmail(session, email.getEmail());
          });

    } catch (Exception e) {
      logger.error(String.format("Exception on sendResume %s", e.toString()));
    }
  }
}
