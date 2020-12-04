/*------------------------------------------------------------------------------
 * Nom de la classe : Employe
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * Copyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 * 2e version : 24 decembre 2019, pour coller au nouveau modele Rondo
 *------------------------------------------------------------------------------
 * Description :
 * Description d'une fiche employe
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("Employe")
@Data
public class Employe extends ServiceObject implements MetadataContainer {
    private static final long serialVersionUID = 58745123521598L;
    //@JsonTypeId
    private String typeObjet = ObjectType.EMPLOYE.name;

    private String email; // User auquel est rattache l'employe
    private String nom; // Nom su salarie
    private String idSociete; // Societe a laquelle est rattache l'employe
    private String type; // Voir la config TypeEmploye
    private String urlPhoto;
    
    private int statut;
    
    private boolean affichePlanning; // On peut visualiser le planning de cet employe
    private boolean accepteInter; // L'employe fait des interventions
    private boolean droitsSociete; // L'employe herite des droits de visu de sa societe

    private List<Metadata> metadatas; // Informations complementaires, en fonction du type
    
    // RH
    private String typePoste; // Voir table TypeContrat
    
    private String idExterne; // Identifiant externe, pour une relation avec un SI RH
    private String typeExterne; // Variable externe, pour une relation avec un SI RH
    private String refExterne; // Identifiant texte externe, pour une relation avec un SI RH
    
    private String commentaires; // Texte libre

    @Override
    public String toString() {
        return getNom();
    }
    
    @Override
    public int compareTo(Object o){
        if( o == null || !(o instanceof Employe)) {
            return 0;
        }
        Employe v = (Employe)o;
        int comparaison;
        comparaison = getIdSociete().compareTo(v.getIdSociete());
        if (comparaison != 0) return comparaison;
        comparaison = this.getNom().compareTo(v.getNom());
        if (comparaison != 0) return comparaison;
        String sId = getId();
        if (sId == null) {
            sId = "";
        }
        return sId.compareTo(v.getId());
    }
}
