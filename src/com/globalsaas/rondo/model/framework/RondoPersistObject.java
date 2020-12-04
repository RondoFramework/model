package com.globalsaas.rondo.model.framework;

import java.util.Date;

import lombok.Data;

@Data
public class RondoPersistObject {
    private String reference;
    private String domain;

    //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date dateCreated;

    // @ServerTimestamp
    //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date dateUpdated;

}