package com.globalsaas.rondo.rest.model;

import java.util.List;

import com.globalsaas.rondo.model.framework.Profil;

import lombok.Data;

@Data
public class ListDossiers {
    private Profil profil;
    private List<RestAffaire> dossiers;
    private int nbResult;
    private int maxNbResult;
    private int page;
}