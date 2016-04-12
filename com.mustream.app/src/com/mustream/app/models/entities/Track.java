package com.mustream.app.models.entities;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.mustream.app.models.entities.StreamingService;
import java.util.ArrayList;
import java.util.List;



/**
 * Mustream track object.
 **/

@ApiModel(description = "Mustream track object.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-04-10T19:06:00.048Z")
public class Track extends Item  {
  
  private String id = null;
  private String name = null;
  private Long duration = null;
  private String streamUrl = null;
  private String uri = null;
  private List<String> artists = new ArrayList<String>();
  private String album = null;
  private StreamingService source = null;

  
  /**
   * The (MuStream) ID for the track.
   **/
  public Track id(String id) {
    this.id = id;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The (MuStream) ID for the track.")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }


  /**
   * The name of the track.
   **/
  public Track name(String name) {
    this.name = name;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The name of the track.")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }


  /**
   * The track length (duration) in milliseconds.
   **/
  public Track duration(Long duration) {
    this.duration = duration;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The track length (duration) in milliseconds.")
  @JsonProperty("duration")
  public Long getDuration() {
    return duration;
  }
  public void setDuration(Long duration) {
    this.duration = duration;
  }


  /**
   * A URL to stream the track.
   **/
  public Track streamUrl(String streamUrl) {
    this.streamUrl = streamUrl;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "A URL to stream the track.")
  @JsonProperty("stream_url")
  public String getStreamUrl() {
    return streamUrl;
  }
  public void setStreamUrl(String streamUrl) {
    this.streamUrl = streamUrl;
  }


  /**
   * The Mustream Resource Identifier or URI for the track.
   **/
  public Track uri(String uri) {
    this.uri = uri;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The Mustream Resource Identifier or URI for the track.")
  @JsonProperty("uri")
  public String getUri() {
    return uri;
  }
  public void setUri(String uri) {
    this.uri = uri;
  }


  /**
   * The artists who performed the track.
   **/
  public Track artists(List<String> artists) {
    this.artists = artists;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The artists who performed the track.")
  @JsonProperty("artists")
  public List<String> getArtists() {
    return artists;
  }
  public void setArtists(List<String> artists) {
    this.artists = artists;
  }


  /**
   * The album of the track.
   **/
  public Track album(String album) {
    this.album = album;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The album of the track.")
  @JsonProperty("album")
  public String getAlbum() {
    return album;
  }
  public void setAlbum(String album) {
    this.album = album;
  }


  /**
   **/
  public Track source(StreamingService source) {
    this.source = source;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("source")
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
        Objects.equals(this.duration, track.duration) &&
        Objects.equals(this.streamUrl, track.streamUrl) &&
        Objects.equals(this.uri, track.uri) &&
        Objects.equals(this.artists, track.artists) &&
        Objects.equals(this.album, track.album) &&
        Objects.equals(this.source, track.source);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, duration, streamUrl, uri, artists, album, source);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Track {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    streamUrl: ").append(toIndentedString(streamUrl)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    artists: ").append(toIndentedString(artists)).append("\n");
    sb.append("    album: ").append(toIndentedString(album)).append("\n");
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
}

