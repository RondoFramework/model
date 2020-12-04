/*------------------------------------------------------------------------------
 * Nom de la classe : Agence
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * Copyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 * 2e version : 24 decembre 2019, pour coller au nouveau modele Rondo
 *------------------------------------------------------------------------------
 * Description :
 * Une agence est l'objet metier qui permet de decrire une structure metier 
 * (agence de reparation, magasin, sous-traitant, etc.).
 * Associe a une agence, on a des contacts qui permettront de localiser l'agence
 * et de gerer la communication
 * Les types d'agences sont definis avec l'objet TypeAgence
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;
@JsonTypeName("Agence")
@Data
public class Agence extends ServiceObject implements MetadataContainer {
    private static final long serialVersionUID = 6587459213584L;
    //@JsonTypeId
    private String typeObjet = ObjectType.AGENCE.name;

    private String nom; // Nom de l'agence
    private String idSociete; // Socite a laquelle l'agence appartient
    private String ownerEmail; // Identifiant de l'employe responsable de l'agence
    private String type; // Une agence est un objet metier. Son type permet de savoir quel est le complement
    private List<Metadata> metadatas;

    @Override
    public boolean equals (Object other){
        if (other == null || !(other instanceof Agence)) {
            return false;
        }
        Agence o = (Agence)other;
        if (getId() == null) {
            return false;
        }
        if (Objects.equals(getId(), o.getId())) {
            return true;
        }
        else if (Objects.equals(nom, o.getNom()) && Objects.equals(getIdSociete(), o.getIdSociete())) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return nom;
    }
    
    @Override
    public int compareTo(Object o){
        if(o == null || !(o instanceof Agence)) {
            return 0;
        }
        Agence a = (Agence)o;
        int comparaison;
        comparaison = getDomain().compareTo(a.getDomain());
        if (comparaison != 0) return comparaison;
        comparaison = getIdSociete().compareTo(a.getIdSociete());
        if (comparaison != 0) return comparaison;
        return this.getNom().toUpperCase().compareTo(a.getNom().toUpperCase());
    }
}
