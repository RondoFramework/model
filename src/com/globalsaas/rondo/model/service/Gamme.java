/*------------------------------------------------------------------------------
 * Nom de la classe : Gamme
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
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

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("Gamme")
@Data
public class Gamme extends ServiceObject {
    private static final long serialVersionUID = -1438504478361245331L;
    //@JsonTypeId
    private String typeObjet = ObjectType.GAMME.name;
    
    private String code; // Code de la gamme
    private String libelle; // Libelle de la gamme
    private String idClasse; // Classe a laquelle est rattachee la gamme
    
    @Override
    public String toString(){
        return libelle;
    }
}
