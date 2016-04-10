package com.mustream.app.client.auth;

import com.mustream.app.client.Pair;

//import com.migcomponents.migbase64.Base64;

import java.util.Map;
import java.util.List;

import java.io.UnsupportedEncodingException;

@javax.annotation.Generated(value = "class com.mustream.app.codegen.languages.JavaClientCodegen", date = "2016-04-09T16:24:49.323Z")
public class HttpBasicAuth implements Authentication {
  private String username;
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams) {
    if (username == null && password == null) {
      return;
    }
    String str = (username == null ? "" : username) + ":" + (password == null ? "" : password);
    headerParams.put("Authorization", "Basic " + str); //TODO encode
//	try {
//      headerParams.put("Authorization", "Basic " + Base64.encodeToString(str.getBytes("UTF-8"), false)); //TODO encode      
// 	} catch (UnsupportedEncodingException e) {
//	throw new RuntimeException(e);
//	}
  }
}
