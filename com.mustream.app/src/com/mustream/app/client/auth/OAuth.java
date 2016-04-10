package com.mustream.app.client.auth;

import com.mustream.app.client.Pair;

import java.util.Map;
import java.util.List;

@javax.annotation.Generated(value = "class com.mustream.app.codegen.languages.JavaClientCodegen", date = "2016-04-09T16:24:49.323Z")
public class OAuth implements Authentication {
  private String accessToken;

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  @Override
  public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams) {
    if (accessToken != null) {
      headerParams.put("Authorization", "Bearer " + accessToken);
    }
  }
}
