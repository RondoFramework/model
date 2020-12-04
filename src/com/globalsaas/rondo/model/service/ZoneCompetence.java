/*------------------------------------------------------------------------------
 * Nom de la classe : ZoneCompetence
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 01 juin 2017
 *------------------------------------------------------------------------------
 * Description :
 * Zone d'application d'une competence, pour un acteur (agence, technicien)
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("ZoneCompetence")
@Data
public class ZoneCompetence extends ServiceObject implements ServiceChild {
    private static final long serialVersionUID = 3936760625609244484L;
    //@JsonTypeId
    private String typeObjet = ObjectType.ZONE_COMPETENCE.name;

    private String nom; // Nom de la zone
    private String idParent; // Identifiant de l'objet pour qui la zone est configuree
    private String typeParent; // Type de l'objet sur lequel la zone est configuree (employe, agence)

    @Override
    public String toString(){
        return nom;
    }
}
