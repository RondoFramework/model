/*------------------------------------------------------------------------------
 * Nom de la classe : Absence
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * Copyright (c) 2019 Myfowo
 * 1e version : 23 mai 2017
 * 2e version : 24 decembre 2019, pour coller au nouveau modele Rondo
 *------------------------------------------------------------------------------
 * Description :
 * Une absence est un temps d'indisponibilite d'un employe, avec un type
 * qui permet de gerer les regles
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("Absence")
@Data
public class Absence extends ServiceObject implements MetadataContainer {
    private static final long serialVersionUID = 25477545447L;
    //@JsonTypeId
    private String typeObjet = ObjectType.ABSENCE.name;

    private Long debut; // Debut de l'absence
    private Long fin; // Fin de l'absence
    private int type; // Type d'absence, lien avec TypeAbsence de l'utilisateur
    private String idEmploye; // Employe lie a cette absence
    private String commentaires; // Commentaires libres
    private boolean demandeValidee; // Pour gerer une demande, et prendre en compte dans la gestion du temps
    private List<Metadata> metadatas; // Informations specifiques pour un logiciel tiers

    @Override
    public int compareTo(Object o) {
        if (o == null || !(o instanceof Absence)) {
            throw new ClassCastException();
        }
        Absence a = (Absence) o;
        int comparaison;
        comparaison = getIdEmploye().compareTo(a.getIdEmploye());
        if (comparaison != 0) {
            return comparaison;
        }
        comparaison = getDebut().compareTo(a.getDebut());
        if (comparaison != 0) {
            return comparaison;
        }
        comparaison = getFin().compareTo(a.getFin());
        if (comparaison != 0) {
            return comparaison;
        }
        String sId = getId();
        if (sId == null) {
            sId = "";
        }
        return sId.compareTo(a.getId());
    }

}
