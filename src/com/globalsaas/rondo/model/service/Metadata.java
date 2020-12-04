package com.globalsaas.rondo.model.service;

import java.util.List;

import lombok.Data;

@Data
public class Metadata implements Cloneable {
    private String domain;
    private String name;
    private String value;
    private List<String> delegationNeeded; // Si on a des éléments dans la liste, alors un utilisateur doit en avoir au moins une pour visualiser la valeur

    public Object clone() {
        Object result = null;
        try {
            result = super.clone();
        }
        catch (CloneNotSupportedException e) {

        }
        return result;
    }
}