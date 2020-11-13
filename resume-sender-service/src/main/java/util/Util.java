package util;

import model.Email;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

  public static Email getMailList(String body) {
    Pattern p =
        Pattern.compile("\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b", Pattern.CASE_INSENSITIVE);
    Matcher matcher = p.matcher(body);
    Email email = new Email();
    if (matcher.matches()) {
      email.setEmail(matcher.group());
    }
    return email;
  }
}
