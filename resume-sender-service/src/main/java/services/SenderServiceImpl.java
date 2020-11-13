package services;

import model.Email;

import javax.mail.Session;
import java.util.List;

public class SenderServiceImpl implements SenderService {

  @Override
  public void sendResume(List<Email> jobList, Session session) {}

  @Override
  public void getSession() {}
}
