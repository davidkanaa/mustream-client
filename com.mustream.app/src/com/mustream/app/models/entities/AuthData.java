package com.mustream.app.models.entities;

import java.util.Objects;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.mustream.app.annotations.ApiModel;
//import com.mustream.app.annotations.ApiModelProperty;

@javax.annotation.Generated(value = "class com.mustream.app.codegen.languages.JavaClientCodegen", date = "2016-04-09T16:24:49.323Z")
public class AuthData   {
  
  private String username = null;
  private String password = null;

  
  /**
   * the username for logging in
   **/
  public AuthData username(String username) {
    this.username = username;
    return this;
  }
  
  //@ApiModelProperty(example = "null", value = "the username for logging in")
  //@JsonProperty("username")
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }


  /**
   * the password for logging in
   **/
  public AuthData password(String password) {
    this.password = password;
    return this;
  }
  
  //@ApiModelProperty(example = "null", value = "the password for logging in")
  //@JsonProperty("password")
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthData authData = (AuthData) o;
    return Objects.equals(this.username, authData.username) &&
        Objects.equals(this.password, authData.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthData {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

