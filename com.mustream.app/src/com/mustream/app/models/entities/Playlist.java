package com.mustream.app.models.entities;

import java.util.Objects;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import com.mustream.app.models.entities.Track;
import com.mustream.app.models.entities.User;
import java.util.ArrayList;
import java.util.List;



/**
 * Mustream playlist object.
 **/

//@ApiModel(description = "Mustream playlist object.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-04-09T16:24:49.323Z")
public class Playlist extends Item  {
  
  private String id = null;
  private String name = null;
  private User owner = null;
  public List<Track> tracks = new ArrayList<Track>(); //TODO use get and set tracks, change back to private akcw

  
  public Playlist(String name2) {
	  name = name2;
}

/**
   **/
  public Playlist id(String id) {
    this.id = id;
    return this;
  }
  
  //@ApiModelProperty(example = "null", value = "")
////  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }


  /**
   **/
  public Playlist name(String name) {
    this.name = name;
    return this;
  }
  
  //@ApiModelProperty(example = "null", value = "")
//  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }


  /**
   **/
  public Playlist owner(User owner) {
    this.owner = owner;
    return this;
  }
  
  //@ApiModelProperty(example = "null", value = "")
//  @JsonProperty("owner")
  public User getOwner() {
    return owner;
  }
  public void setOwner(User owner) {
    this.owner = owner;
  }


  /**
   **/
  public Playlist tracks(List<Track> tracks) {
    this.tracks = tracks;
    return this;
  }
  
  //@ApiModelProperty(example = "null", value = "")
//  @JsonProperty("tracks")
  public List<Track> getTracks() {
    return tracks;
  }
  public void setTracks(List<Track> tracks) {
    this.tracks = tracks;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Playlist playlist = (Playlist) o;
    return Objects.equals(this.id, playlist.id) &&
        Objects.equals(this.name, playlist.name) &&
        Objects.equals(this.owner, playlist.owner) &&
        Objects.equals(this.tracks, playlist.tracks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, owner, tracks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Playlist {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    tracks: ").append(toIndentedString(tracks)).append("\n");
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

