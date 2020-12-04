/*------------------------------------------------------------------------------
 * Nom de la classe : Transporteur
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Description d'un transporteur sur l'outil
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

@JsonTypeName("Transporteur")
@Data
public class Transporteur extends ServiceObject implements MetadataContainer, DelegationContainer {
    private static final long serialVersionUID = 7144376729180566947L;
    //@JsonTypeId
    private String typeObjet = ObjectType.TRANSPORTEUR.name;

    private String groupe; // Nom du groupe auquel est rattache le transporteur
    private String nom; // Nom du transporteur
    private String ownerEmail; // Identifiant de l'utilisateur qui se connecte pour la gestion du fournisseur

    private String commentaires;
    private String urlTracking; 
    private boolean pointsRelais; // Le transporteur gere des points relais

    private List<Metadata> metadatas;
    private List<Delegation> delegations;

    @Override
    public String toString(){
        return nom;
    }
}
