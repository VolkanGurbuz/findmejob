package services;

import model.Email;
import model.Job;

import javax.mail.Session;
import java.util.List;

public interface SenderService {

  void sendResume(List<Email> jobList, Session session);

  void getSession();
}
g