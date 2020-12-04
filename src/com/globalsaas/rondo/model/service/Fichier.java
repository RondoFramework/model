/*------------------------------------------------------------------------------
 * Nom de la classe : AttachedFile
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Descripteur d'un fichier attache. 
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.cloud.firestore.annotation.Exclude;

import lombok.Data;

@JsonTypeName("Fichier")
@Data
public class Fichier extends ServiceObject implements ServiceAffaireObject, ServiceChild, DelegationContainer, MetadataContainer {
    private static final long serialVersionUID = 7072772563488544096L;
    //@JsonTypeId
    private String typeObjet = ObjectType.FICHIER.name;
    
    private String idAffaire;
    private String name; // Nom du fichier, court
    private String suffix; // Suffixe du fichier
    private String idCreateur; // Nom de l'employe ayant enregistre ce fichier sur le serveur
    private long taille; // en octets
    private String idParent;
    private String typeParent;
    private byte[] content;
    private String url;
    private List<Metadata> metadatas;
    private List<Delegation> delegations;
    
    @Override
    public String toString() {
        return getName();
    }

    @Exclude
    public String getLibelleTaille() {
        int giga = (int) ((double) getTaille() / (double) (1024 * 1024 * 1024));
        int mega = (int) ((double) getTaille() / (double) (1024 * 1024));
        int kilo = (int) ((double) getTaille() / (double) (1024));
        if (giga >= 10) {
            return giga + " Gb";
        } else if (mega >= 10) {
            return mega + " Mb";
        } else if (kilo >= 10) {
            return kilo + " Kb";
        } else {
            return getTaille() + " bytes";
        }
    }
}
