package com.volkangurbuz.findmejob.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Util {
  private static HttpClient client = HttpClient.newHttpClient();

  private static Logger logger = LoggerFactory.getLogger(Util.class);

  public static String sendGetRequest(String url) {
    try {
      HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      if (response.statusCode() == 200) {
        return response.body();
      }
    } catch (Exception e) {
      logger.error("Failure , " + e.toString());
    }
    return null;
  }
}
