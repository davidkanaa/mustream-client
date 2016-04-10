package com.mustream.app.models.entities;

import java.util.Objects;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-04-09T16:24:49.323Z")
public class Tracks   {
  
  private Long trackId = null;
  private Long streamerId = null;

  
  /**
   **/
  public Tracks trackId(Long trackId) {
    this.trackId = trackId;
    return this;
  }
  
//  @ApiModelProperty(example = "null", value = "")
//  @JsonProperty("track_id")
  public Long getTrackId() {
    return trackId;
  }
  public void setTrackId(Long trackId) {
    this.trackId = trackId;
  }


  /**
   **/
  public Tracks streamerId(Long streamerId) {
    this.streamerId = streamerId;
    return this;
  }
  
//  @ApiModelProperty(example = "null", value = "")
//  @JsonProperty("streamer_id")
  public Long getStreamerId() {
    return streamerId;
  }
  public void setStreamerId(Long streamerId) {
    this.streamerId = streamerId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tracks tracks = (Tracks) o;
    return Objects.equals(this.trackId, tracks.trackId) &&
        Objects.equals(this.streamerId, tracks.streamerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(trackId, streamerId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tracks {\n");
    
    sb.append("    trackId: ").append(toIndentedString(trackId)).append("\n");
    sb.append("    streamerId: ").append(toIndentedString(streamerId)).append("\n");
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

