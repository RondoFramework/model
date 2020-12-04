/*------------------------------------------------------------------------------
 * Nom de la classe : TypeObjetAffaire
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Description d'un objet d'affaire (affaire, prestation ou CR). Definit le nom
 * du type, ainsi que les objets de complement associes
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("TypeObjetAffaire")
@Data
public class TypeObjetAffaire extends ServiceObject {
    private static final long serialVersionUID = -8407845133102583189L;
    //@JsonTypeId
    private String typeObjet = ObjectType.TYPE_OBJET_AFFAIRE.name;

    public static final String TYPE_AFFAIRE = "AFFAIRE";
    public static final String TYPE_PRESTATION = "PRESTATION";
    public static final String TYPE_CR = "COMPTE-RENDU";
    
    private String type; // Type d'objet auquel on se refere : affaire, prestation ou CR
    private String nom; // Libelle du type
    private String reference; // Reference unique du type, pour permettre des traitements particuliers
    
    public String toString() {
        return nom;
    }
    
}
