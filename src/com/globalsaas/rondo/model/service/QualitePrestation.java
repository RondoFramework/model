/*------------------------------------------------------------------------------
 * Nom de la classe : QualitePrestation
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * Copyright (c) 2020 Myfowo
 * 1e version : 29 juin 2020
 *------------------------------------------------------------------------------
 * Description :
 * Evaluation d'une prestation
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("QualitePrestation")
@Data
public class QualitePrestation extends ServiceObject implements ServiceChild {
    private static final long serialVersionUID = 54574551123365985L;
    //@JsonTypeId
    private String typeObjet = ObjectType.QUALITE_PRESTATION.name;
    
    // Elements de requete
    private String idAgence; // Agence qui represente la station

    private String typeParent;
    private String idParent;

    // Qualite subjective
    private double note; // Valeurs moyennes sur etoilage par les particuliers
}
