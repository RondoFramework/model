/*------------------------------------------------------------------------------
 * Nom de la classe : Reglement
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Enregistrement d'un reglement par un client 
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

@JsonTypeName("Reglement")
@Data
public class Reglement extends ServiceObject implements ServiceAffaireObject, ServiceChild, MetadataContainer{
    private static final long serialVersionUID = 15298027534036008L;
    //@JsonTypeId
    private String typeObjet = ObjectType.REGLEMENT.name;

    private Long date; // Date d'enregistrement du reglement
    private double valeur; // Valeur du reglement
    private long type; // Type de reglement. Voir TypeReglement
    private String idParent; // Identifiant de la source du reglement (facture, devis, affaire)
    private String commentaire; // Commentaires libres
    private String typeParent; // Type de la source du reglement
    private String idEtablissement; // Etablissement sur lequel on a enregistre le reglement
    private String idClient; // Identifiant du client qui a effectue le reglement
    private boolean cofinancement; // On a un cofinancement, pour une prestation de type service a la personne
    private String idCofinancement; // identifiant du coficancement si on en a un
    private String idBanque; // Identifiant du compte bancaire sur lequel on a enregistre le reglement
    private long typeAccompte; // Type d'accompte
    private boolean accompte; // Le reglemebnt est un accompte
    private boolean export; // On a exporte le reglement en compta
    private boolean valide; // Le reglement est valide
    private String idAffaire; // Affaire a laquelle est liee le reglement
    private List<Metadata> metadatas;

}
