package com.mustream.app.models.modules.searcher;

import java.util.ArrayList;
import java.util.List;
import com.mustream.app.client.ApiException;
import com.mustream.app.models.entities.Track;
import com.mustream.app.register.ServiceRegister;
import com.mustream.app.services.ServiceConsumer;

/**
 * Created by davidkanaa on 16-02-02.
 */

/**
 *
 * A Searcher is responsible for handling search-related operations.
 * It holds the list of results obtained in the last search query.
 *
 */
public class Searcher {

    private List<Track> results;

    public Searcher() {
        results = new ArrayList<Track>();
    }

    /**
     * Runs a search over available services' databases.
     * @param terms Terms of the search.
     */
    public void search(String terms) {

        List<Track> results = new ArrayList<Track>();

        for (ServiceConsumer consumer:
                ServiceRegister.getInstance_().getServiceConsumers()) {
            try {
            	results.addAll(consumer.search(terms));    	
            } catch (ApiException e) {
            	//TODO
            }
            
        }
        this.results = results;
    }

    /**
     *
     * @return The list of results for the latest search operation run.
     */
    public List<Track> getResults() {
        return results;
    }
}
