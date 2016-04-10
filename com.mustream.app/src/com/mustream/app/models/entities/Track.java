package com.mustream.app.models.entities;

import java.util.Objects;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import com.mustream.app.models.entities.StreamingService;
import java.util.ArrayList;
import java.util.List;



/**
 * Mustream track object.
 **/

//@ApiModel(description = "Mustream track object.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-04-09T16:24:49.323Z")
public class Track extends Item  {
  
  private String id = null;
  private String name = null;
  private List<String> artists = new ArrayList<String>();
  private String album = null;
  private String url = null;
  private StreamingService source = null;
  private Long duration = null;

  
  /**
   **/
  public Track id(String id) {
    this.id = id;
    return this;
  }
  
//  @ApiModelProperty(example = "null", value = "")
//  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }


  /**
   **/
  public Track name(String name) {
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


  /**
   **/
  public Track artists(List<String> artists) {
    this.artists = artists;
    return this;
  }
  
//  @ApiModelProperty(example = "null", value = "")
//  @JsonProperty("artists")
  public List<String> getArtists() {
    return artists;
  }
  public void setArtists(List<String> artists) {
    this.artists = artists;
  }


  /**
   **/
  public Track album(String album) {
    this.album = album;
    return this;
  }
  
//  @ApiModelProperty(example = "null", value = "")
//  @JsonProperty("album")
  public String getAlbum() {
    return album;
  }
  public void setAlbum(String album) {
    this.album = album;
  }


  /**
   **/
  public Track url(String url) {
    this.url = url;
    return this;
  }
  
//  @ApiModelProperty(example = "null", value = "")
//  @JsonProperty("url")
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }


  /**
   **/
  public Track source(StreamingService source) {
    this.source = source;
    return this;
  }
  
//  @ApiModelProperty(example = "null", value = "")
//  @JsonProperty("source")
  public StreamingService getSource() {
    return source;
  }
  public void setSource(StreamingService source) {
    this.source = source;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Track track = (Track) o;
    return Objects.equals(this.id, track.id) &&
        Objects.equals(this.name, track.name) &&
        Objects.equals(this.artists, track.artists) &&
        Objects.equals(this.album, track.album) &&
        Objects.equals(this.url, track.url) &&
        Objects.equals(this.source, track.source);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, artists, album, url, source);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Track {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    artists: ").append(toIndentedString(artists)).append("\n");
    sb.append("    album: ").append(toIndentedString(album)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
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

public void setDuration(long parseLong) {
	this.duration = parseLong;	
}

public Object getDuration() {
	return duration;
}

}

