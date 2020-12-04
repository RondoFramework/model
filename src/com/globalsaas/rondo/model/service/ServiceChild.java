package com.globalsaas.rondo.model.service;

/**
 * ServiceChild
 */
public interface ServiceChild {

    public String getIdParent();
    public String getTypeParent();
    public void setIdParent(String ref);
    public void setTypeParent(String type);
}