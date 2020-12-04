/*------------------------------------------------------------------------------
 * Nom de la classe : Client
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Represente un client sur lequel on fait de la gestion commerciale et de la 
 * gestion d'affaires. Toute affaire est liee a un client. Toute operation de
 * gestion commerciale est liee a un client (devis, facture, reglement)
 * Un client a des contacts, dont on se sert pour la communication et la 
 * facturation.
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

@JsonTypeName("Client")
@Data
public class Client extends ServiceObject implements DelegationContainer, MetadataContainer {
    private static final long serialVersionUID = 4797274863211355222L;
    //@JsonTypeId
    private String typeObjet = ObjectType.CLIENT.name;
    
    private String reference; // Reference unique du client par rapport au domaine
    private String refDo; // Reference unique du client par rapport au donneur d'ordre
    // 
    private boolean profesionnel; // Le client est une entreprise
    private String remarques; // Texte libre
    private String commercial; // Nom du commercial en charge du dossier
    private String nom; // Nom du client
    private String email; // Identifiant du client, pour se connecter sur un portail
    private String connuComment; // Commentaires pour identifier la source
    
    // Champs pour une entreprise
    private String siret; // Numero de SIRET
    private String rcs; // Numero RCS
    private String villeRcs; // Adresse d'enregistrement RCS
    private String tvaIntra; // Numero de TVA communautaire
    private String internet; // Adresse du site web
    private String capital;// Capital en toutes lettres
    private String codeApe; // Code APE de l'entreprise
    private List<Metadata> metadatas;
    private List<Delegation> delegations;
    
    private String idBanque; // Identifiant du compte bancaire
}
