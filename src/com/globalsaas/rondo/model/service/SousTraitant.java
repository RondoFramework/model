/*------------------------------------------------------------------------------
 * Nom de la classe : SousTraitant
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Represente une structure juridique au travers de laquelle on envoie des 
 * mandats pour traiter des prestations
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

@JsonTypeName("SousTraitant")
@Data
public class SousTraitant extends ServiceObject implements DelegationContainer, MetadataContainer {
    private static final long serialVersionUID = 6830966536163248785L;
    //@JsonTypeId
    private String typeObjet = ObjectType.SOUS_TRAITANT.name;
    private String ownerEmail; // Identifiant du user permettant de se connecter aux outils au nom du
                           // sous-traitant
    private String idAgence; // Identifiant de l'agence qui represente le prestataire dans le reseau
    // Sur l'agence du sous-traitant, on a les contacts
    private String refPortail; // Reference du sous-traitant sur l'application metier
    private String groupe; // Groupe auquel appartient le sous-traitant
    private String nom; // Nom du sous-traitant

    private String siret; // Numero de siret
    private String rcs; // Numero de SIREN
    private String lieuRcs; // Lieu d'enregistrement du RCS
    private String TVAIntra; // Numero de TVA intracommunautaire
    private String codeAPE; // Code APE de l'entreprise
    private String capital; // Capital de l'entreprise en toutes lettres
    private String typeISO; // Type ISO de l'entreprise

    private int nbSalaries; // Nb total de salaries
    private int nbTechExterieur; // Nb de techniciens itinerants
    private int nbTechAtelier; // Nb de techniciens atelier
    private boolean actif; // Profil actif
    private String commentaires; // Commentaires 

    private String nomSI; // Nom du systeme d'information

    private List<Metadata> metadatas;
    private List<Delegation> delegations;

    @Override
    public String toString(){
        if (groupe != null && groupe.trim().length() > 0) return groupe+" - "+nom;
        return nom;
    }

}
