package com.mustream.app.models.entities;

import java.util.Objects;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;



/**
 * Mustream streaming service object : contains information about an Streaming Service integrated in the Mustream Platform.
 **/

//@ApiModel(description = "Mustream streaming service object : contains information about an Streaming Service integrated in the Mustream Platform.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-04-09T16:24:49.323Z")
public class StreamingService   {
  
  private Long id = null;
  private String name = null;

  
  /**
   **/
  public StreamingService id(Long id) {
    this.id = id;
    return this;
  }
  
 // @ApiModelProperty(example = "null", value = "")
//  @JsonProperty("id")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }


  /**
   **/
  public StreamingService name(String name) {
    this.name = name;
    return this;
  }
  
//  @ApiModelProperty(example = "null", value = "")
//  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StreamingService streamingService = (StreamingService) o;
    return Objects.equals(this.id, streamingService.id) &&
        Objects.equals(this.name, streamingService.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StreamingService {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

