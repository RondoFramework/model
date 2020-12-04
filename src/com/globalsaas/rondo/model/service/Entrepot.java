/*------------------------------------------------------------------------------
 * Nom de la classe : Entrepot
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Un entrepot est un element du reseau permettant de stocker des articles
 * et des equipements. Il a des emplacements, ce qui permet de ranger 
 * eficacement les objets stockes
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

@JsonTypeName("Entrepot")
@Data
public class Entrepot extends ServiceObject implements MetadataContainer, DelegationContainer {
    private static final long serialVersionUID = 4755244939638824009L;
    //@JsonTypeId
    private String typeObjet = ObjectType.ENTREPOT.name;
    
    private String nom; // Nom de l'entrepot
    private String idSociete; // Societe a laquelle est rattache l'entrepot
    private String type; // Type d'entrepot, defini par l'objet TypeEntrepot
    
    private List<Metadata> metadatas;
    private List<Delegation> delegations;
    
    @Override
    public String toString(){
        return nom;
    }
}
