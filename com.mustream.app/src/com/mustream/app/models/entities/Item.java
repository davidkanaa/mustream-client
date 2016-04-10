package com.mustream.app.models.entities;

/**
 * Created by davidkanaa on 16-01-29.
 */

/**
 * An entity model representing an item from a streaming service provider.
 *
 * An Item is defined by its provider, represented by the interface that consumes it,
 * by its identifier in the provider database,
 * by the URI,
 * by its title.
 *
 */
public abstract class Item {

    protected String name;
    protected String uri;
    protected String id; // The id of the item in the db of its service provider.


    /**
     *
     * @return The title of the current item.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param title
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return The uri of the current item.
     */
    public String getUri() {
        return uri;
    }

    /**
     *
     * @param uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     *
     * @return the identifier of the current item in its provider database.
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
}
