/*------------------------------------------------------------------------------
 * Nom de la classe : Groupe
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Represente un niveau de la nomenclature du catalogue :
 * Groupe
 *   |_Classe
 *       |_Gamme
 *           |_Produit
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("Groupe")
@Data
public class Groupe extends ServiceObject {
    private static final long serialVersionUID = -4085875982770672731L;
    //@JsonTypeId
    private String typeObjet = ObjectType.GROUPE.name;
        
    private String libelle;

     @Override
    public String toString() {
        return getLibelle();
    }
}


