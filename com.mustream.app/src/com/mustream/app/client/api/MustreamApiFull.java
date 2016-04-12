package com.mustream.app.client.api;

import com.sun.jersey.api.client.GenericType;

import com.mustream.app.client.ApiException;
import com.mustream.app.client.ApiClient;
import com.mustream.app.client.Configuration;
import com.mustream.app.client.Pair;

import com.mustream.app.models.entities.Credentials;
//import com.mustream.app.models.entities.Error;
import com.mustream.app.models.entities.Playlist;
import com.mustream.app.models.entities.User;
import com.mustream.app.models.modules.PlaylistManager.PlaylistManager;
//import com.mustream.app.models.entities.Item;
import com.mustream.app.models.entities.Track;

import com.mustream.app.services.*; //TODO modification akcw

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-04-10T19:06:00.048Z")
public class MustreamApiFull implements ServiceConsumer {
  //TODO Made Api a singleton
	private static MustreamApiFull instance_ = null;
	private ApiClient apiClient;

  public MustreamApiFull() {
    this(Configuration.getDefaultApiClient());
  }
  
  public static MustreamApiFull getInstance() {
	  if (instance_ == null){
          instance_ = new MustreamApiFull();
      }
      return instance_;
  }

  public MustreamApiFull(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Authenticate a user against the data base of user accounts.
   * Authenticates and returns a token.
   * @param clientId Client Identifier. (required)
   * @param credentials Authentication information. (required)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String accountsAuthenticatePost(String clientId, Credentials credentials) throws ApiException {
    Object localVarPostBody = credentials;
    
    // verify the required parameter 'clientId' is set
    if (clientId == null) {
      throw new ApiException(400, "Missing the required parameter 'clientId' when calling accountsAuthenticatePost");
    }
    
    // verify the required parameter 'credentials' is set
    if (credentials == null) {
      throw new ApiException(400, "Missing the required parameter 'credentials' when calling accountsAuthenticatePost");
    }
    
    // create path and map variables
    String localVarPath = "/accounts/authenticate".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "client_id", clientId));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Add one or more tracks a user\u2019s playlist
   * 
   * @param accessToken Authentication token. (required)
   * @param userId Identifier of the user. (required)
   * @param playlistId Identifier of the user&#39;s playlist. (required)
   * @param uris The Mustream Resource Identifier or URI for the tracks to add to the playlist. (optional)
   * @param uris2 The Mustream Resource Identifier or URI for the tracks to add to the playlist. (optional)
   * @throws ApiException if fails to make API call
   *
   */
  //TODO remove uris2
  public void addTrackstoPlaylist(String accessToken, String userId, String playlistId, List<String> uris, List<String> uris2) throws ApiException {
    Object localVarPostBody = uris;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling addTrackstoPlaylist");
    }
    
    // verify the required parameter 'userId' is set
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling addTrackstoPlaylist");
    }
    
    // verify the required parameter 'playlistId' is set
    if (playlistId == null) {
      throw new ApiException(400, "Missing the required parameter 'playlistId' when calling addTrackstoPlaylist");
    }
    
    // create path and map variables
    String localVarPath = "/users/{user_id}/playlists/{playlist_id}/tracks".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "user_id" + "\\}", apiClient.escapeString(userId.toString()))
      .replaceAll("\\{" + "playlist_id" + "\\}", apiClient.escapeString(playlistId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "uris", uris2));

    if (accessToken != null)
      localVarHeaderParams.put("access_token", apiClient.parameterToString(accessToken));

    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Create a playlist for a Mustream user
   * Returns a reference to the freshly created &#x60;&#x60;Playlist&#x60;&#x60; object.
   * @param accessToken Authentication token (required)
   * @param userId identifier of the user (required)
   * @param name The name of the new playlist. (required)
   * @return Playlist
   * @throws ApiException if fails to make API call
   */
  public Playlist createPlaylist(String accessToken, String userId, String name) throws ApiException {
    Object localVarPostBody = name;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling createPlaylist");
    }
    
    // verify the required parameter 'userId' is set
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling createPlaylist");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling createPlaylist");
    }
    
    // create path and map variables
    String localVarPath = "/users/{user_id}/playlists".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "user_id" + "\\}", apiClient.escapeString(userId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (accessToken != null)
      localVarHeaderParams.put("access_token", apiClient.parameterToString(accessToken));

    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Playlist> localVarReturnType = new GenericType<Playlist>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete a user&#39;s playlist
   * 
   * @param accessToken Authentication token (required)
   * @param userId identifier of the user (required)
   * @param playlistId identifier of the user&#39;s playlist (required)
   * @throws ApiException if fails to make API call
   */
  public void deletePlaylist(String accessToken, String userId, String playlistId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling deletePlaylist");
    }
    
    // verify the required parameter 'userId' is set
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling deletePlaylist");
    }
    
    // verify the required parameter 'playlistId' is set
    if (playlistId == null) {
      throw new ApiException(400, "Missing the required parameter 'playlistId' when calling deletePlaylist");
    }
    
    // create path and map variables
    String localVarPath = "/users/{user_id}/playlists/{playlist_id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "user_id" + "\\}", apiClient.escapeString(userId.toString()))
      .replaceAll("\\{" + "playlist_id" + "\\}", apiClient.escapeString(playlistId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (accessToken != null)
      localVarHeaderParams.put("access_token", apiClient.parameterToString(accessToken));

    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Get the playlists of a Mustream user.
   * Gets &#x60;Playlist&#x60; objects.
   * @param accessToken Authentication token (required)
   * @param userId Identifier of the user (required)
   * @return List<Playlist>
   * @throws ApiException if fails to make API call
   */
  public List<Playlist> getAllPlaylists(String accessToken, String userId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling getAllPlaylists");
    }
    
    // verify the required parameter 'userId' is set
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling getAllPlaylists");
    }
    
    // create path and map variables
    String localVarPath = "/users/{user_id}/playlists".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "user_id" + "\\}", apiClient.escapeString(userId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (accessToken != null)
      localVarHeaderParams.put("access_token", apiClient.parameterToString(accessToken));

    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<Playlist>> localVarReturnType = new GenericType<List<Playlist>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get a playlist owned by a Mustream user
   * Get a &#x60;Playlist&#x60; object.
   * @param accessToken Authentication token (required)
   * @param userId identifier of the user (required)
   * @param playlistId identifier of the user&#39;s playlist (required)
   * @return Playlist
   * @throws ApiException if fails to make API call
   */
  //TODO not needed so far
//  public Playlist getPlaylist(String accessToken, String userId, String playlistId) throws ApiException {
//    Object localVarPostBody = null;
//    
//    // verify the required parameter 'accessToken' is set
//    if (accessToken == null) {
//      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling getPlaylist");
//    }
//    
//    // verify the required parameter 'userId' is set
//    if (userId == null) {
//      throw new ApiException(400, "Missing the required parameter 'userId' when calling getPlaylist");
//    }
//    
//    // verify the required parameter 'playlistId' is set
//    if (playlistId == null) {
//      throw new ApiException(400, "Missing the required parameter 'playlistId' when calling getPlaylist");
//    }
//    
//    // create path and map variables
//    String localVarPath = "/users/{user_id}/playlists/{playlist_id}".replaceAll("\\{format\\}","json")
//      .replaceAll("\\{" + "user_id" + "\\}", apiClient.escapeString(userId.toString()))
//      .replaceAll("\\{" + "playlist_id" + "\\}", apiClient.escapeString(playlistId.toString()));
//
//    // query params
//    List<Pair> localVarQueryParams = new ArrayList<Pair>();
//    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
//    Map<String, Object> localVarFormParams = new HashMap<String, Object>();
//
//
//    if (accessToken != null)
//      localVarHeaderParams.put("access_token", apiClient.parameterToString(accessToken));
//
//    
//    final String[] localVarAccepts = {
//      "application/json"
//    };
//    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
//
//    final String[] localVarContentTypes = {
//      "application/json"
//    };
//    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
//
//    String[] localVarAuthNames = new String[] {  };
//
//    GenericType<Playlist> localVarReturnType = new GenericType<Playlist>() {};
//    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
//      }
  
  /**
   * Get public profile information about a Mustream user.
   * Gets the &#x60;User&#x60; objects with **user_id** as identifier value.
   * @param userId User identifier (required)
   * @return User
   * @throws ApiException if fails to make API call
   */
  public User getUser(String userId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'userId' is set
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling getUser");
    }
    
    // create path and map variables
    String localVarPath = "/users/{user_id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "user_id" + "\\}", apiClient.escapeString(userId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<User> localVarReturnType = new GenericType<User>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get detailed profile information about the current user.
   * Gets the &#x60;User&#x60; object corresponding to the current user profile.
   * @param accessToken Authentication token (required)
   * @return User
   * @throws ApiException if fails to make API call
   */
  public User meGet(String accessToken) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling meGet");
    }
    
    // create path and map variables
    String localVarPath = "/me".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (accessToken != null)
      localVarHeaderParams.put("access_token", apiClient.parameterToString(accessToken));

    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<User> localVarReturnType = new GenericType<User>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Remove one or more tracks from a user\u2019s playlist
   * 
   * @param accessToken Authentication token (required)
   * @param userId Identifier of the user (required)
   * @param playlistId Identifier of the user&#39;s playlist (required)
   * @param uris The Mustream Resource Identifier or URI for the tracks to remove to the playlist. (optional)
   * @param uris2 The Mustream Resource Identifier or URI for the tracks to remove to the playlist. (optional)
   * @throws ApiException if fails to make API call
   */
  public void removeTracksfromPlaylist(String accessToken, String userId, String playlistId, List<String> uris, List<String> uris2) throws ApiException {
    Object localVarPostBody = uris;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling removeTracksfromPlaylist");
    }
    
    // verify the required parameter 'userId' is set
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling removeTracksfromPlaylist");
    }
    
    // verify the required parameter 'playlistId' is set
    if (playlistId == null) {
      throw new ApiException(400, "Missing the required parameter 'playlistId' when calling removeTracksfromPlaylist");
    }
    
    // create path and map variables
    String localVarPath = "/users/{user_id}/playlists/{playlist_id}/tracks".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "user_id" + "\\}", apiClient.escapeString(userId.toString()))
      .replaceAll("\\{" + "playlist_id" + "\\}", apiClient.escapeString(playlistId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "uris", uris2));

    if (accessToken != null)
      localVarHeaderParams.put("access_token", apiClient.parameterToString(accessToken));

    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Get all integrated streaming services catalog information about tracks that match a keyword string.
   * Gets &#x60;&#x60;Track&#x60;&#x60; objects.
   * @param query terms to search (required)
   * @return List<Track>
   * @throws ApiException if fails to make API call
   */
  public List<Track> search(String query) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'query' is set
    if (query == null) {
      throw new ApiException(400, "Missing the required parameter 'query' when calling search");
    }
    
    // create path and map variables
    String localVarPath = "/search".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "query", query));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<Track>> localVarReturnType = new GenericType<List<Track>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Rename user&#39;s playlist
   * 
   * @param accessToken Authentication token (required)
   * @param userId Identifier of the user (required)
   * @param playlistId Identifier of the user&#39;s playlist (required)
   * @param name The new name of the playlist. (required)
   * @throws ApiException if fails to make API call
   */
  public void updatePlaylist(String accessToken, String userId, String playlistId, String name) throws ApiException {
    Object localVarPostBody = name;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling updatePlaylist");
    }
    
    // verify the required parameter 'userId' is set
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling updatePlaylist");
    }
    
    // verify the required parameter 'playlistId' is set
    if (playlistId == null) {
      throw new ApiException(400, "Missing the required parameter 'playlistId' when calling updatePlaylist");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling updatePlaylist");
    }
    
    // create path and map variables
    String localVarPath = "/users/{user_id}/playlists/{playlist_id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "user_id" + "\\}", apiClient.escapeString(userId.toString()))
      .replaceAll("\\{" + "playlist_id" + "\\}", apiClient.escapeString(playlistId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (accessToken != null)
      localVarHeaderParams.put("access_token", apiClient.parameterToString(accessToken));

    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
}
