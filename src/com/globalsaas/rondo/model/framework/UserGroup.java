package com.globalsaas.rondo.model.framework;

import java.util.ArrayList;

import lombok.Data;

@Data
public class UserGroup {
    private String domain;
    private String name;
    private String description;
    private ArrayList<String> permissions; // Reference d'une permission au format refWebApp##refPermission

}
