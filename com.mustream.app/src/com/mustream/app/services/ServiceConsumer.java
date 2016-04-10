package com.mustream.app.services;

import java.util.List;

import com.mustream.app.client.ApiException;
import com.mustream.app.models.entities.Track;

/**
 * Created by davidkanaa on 16-01-29.
 */

public interface ServiceConsumer {
	
	List<Track> search(String terms) throws ApiException;
	
	// TODO added Api Exception

}
