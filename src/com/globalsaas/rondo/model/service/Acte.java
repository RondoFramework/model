/*------------------------------------------------------------------------------
 * Nom de la classe : Acte
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 * 2e version : 24 decembre 2019, pour coller au nouveau modele Rondo
 *------------------------------------------------------------------------------
 * Description :
 * Un acte est un objet representant l'utilisation d'une ressource sur une
 * periode donnee. Il est type, en fonction d'une activite et d'un modele 
 * d'intervention. Il a un etat et un etat de planification, qui permettent de
 * l'inscrire dans un workflow
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
@JsonTypeName("Acte")
@Data
public class Acte extends ServiceTimeObject implements ServiceAffaireObject, MetadataContainer, DelegationContainer {
    private static final long serialVersionUID = 845741221479L;
    //@JsonTypeId
    private String typeObjet = ObjectType.ACTE.name;

    public static final int A_PLANIFIER = 0;
    public static final int PLANIFIEE = 1;
    public static final int EN_COURS = 2;
    public static final int TERMINEE_OK = 3;
    public static final int TERMINEE_NOK = 4;
    public static final int MANQUEE = 5;
    public static final int DOUBLON = 6;
    public static final int ANNULEE = 7;

    public static final int CONTACT_AUCUN = 0;
    public static final int CONTACT_ECHEC = 1;
    public static final int CONTACT_OK = 2;
    
    private String title; // Titre de l'acte a afficher
    private String idModele; // Modele d'intervention
    private String idAgenceInter; // Agence sur laquelle l'acte est assigne
    private String domaineInter; // Domaine du salarie qui intervient
    private String idAffaire; // Affaire a laquelle l'acte est lie
    private String description; // Description des travaux a realiser
    private String commentaires; // Commentaires de l'employe aui a realise l'acte
    private String idAdresse;
    private boolean surSite; // Definit s'il y a un deplacemen a gerer
    private int etat; // Etat de l'acte
    private int etatContact;
    private long datePlanif; // Date de l'action de planification de l'acte
    private boolean annulee; // Determine si l'acte est annule ou pas
    private long dateAnnule; // Si l'acte est annule, date a laquelle on a fait l'action
    private String motifAnnule; // Motif d'annulation
    private long codeNok; // Si cloture, code NOK

    private List<Metadata> metadatas;
    private List<Delegation> delegations;

    @Override
    public String toString() {
        if (!isAnnulee()) {
            return "n\u00B0 " + " - " + getTitle();
        } else {
            return "n\u00B0 " + getId() + " Annul\u00E9e" + " - " + getTitle();
        }
    }

}
