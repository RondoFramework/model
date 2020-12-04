/*------------------------------------------------------------------------------
 * Nom de la classe : Memo
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Element textuel simple avec horodatage, pour garder une trace simple sur
 * un objet de l'application
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */

package com.globalsaas.rondo.model.service;

import java.text.DateFormat;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("Memo")
@Data
public class Memo extends ServiceObject implements ServiceAffaireObject, ServiceChild, DelegationContainer, MetadataContainer{
    private static final long serialVersionUID = -4747536448760513229L;
    //@JsonTypeId
    private String typeObjet = ObjectType.MEMO.name;
    
    private String idAffaire;
    private Long date; // Date de creation du memo
    private String auteur; // Auteur du memo
    private String memo; // Texte du memo
    private String idParent; // Identifiant de l'objet auquel est rattache le memo
    private String typeParent; // Type d'objet auquel est rattache le memo (affaire, client, sous-traitant...)
    private List<Metadata> metadatas;
    private List<Delegation> delegations;

    @Override
    public String toString(){
        StringBuilder buffer = new StringBuilder();
        buffer.append(DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new java.util.Date(date)));
        buffer.append(" ").append(auteur).append(" - ").append(memo);

        return buffer.toString();
    }
}
