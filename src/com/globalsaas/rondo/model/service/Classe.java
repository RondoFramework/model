/*------------------------------------------------------------------------------
 * Nom de la classe : Classe
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Element de la nomenclature produit. Une classe appartient a un groupe de
 * produit. La classe permet de definir des competences et de regrouper les
 * appareils.
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("Classe")
@Data
public class Classe extends ServiceObject {
    private static final long serialVersionUID = 7165687250202759667L;
    //@JsonTypeId
    private String typeObjet = ObjectType.CLASSE.name;
    
    private String idGroupe; // Identifiant du groupe auquel est rattachee la classe
     private String code; // Reference de la classe
     private String libelle; // Libelle de la classe

     public static String[] TYPES_REPARATION = {"Atelier", "Intervention &agrave; domicile"};

    public Classe() {
    }

    public Classe(String idGroupe, String code, String libelle) {
       this.idGroupe = idGroupe;
       this.code = code;
       this.libelle = libelle;
    }

    @Override
    public String toString() {
        return getLibelle();
    }
}


