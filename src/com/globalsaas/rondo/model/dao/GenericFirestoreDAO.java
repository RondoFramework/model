package com.globalsaas.rondo.model.dao;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * GenericFirestoreDAO
 */
@Data
public class GenericFirestoreDAO implements Serializable {

	private static final long serialVersionUID = 7610385184101840967L;

    String id;

    //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date dateCreated;

    // @ServerTimestamp
    //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date dateUpdated;

}