/*------------------------------------------------------------------------------
 * Nom de la classe : Competence
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Competence liee a une activite (activite ou modele) ou a un type de produit
 * (groupe, classe, gamme). Elle est dependante d'une zone Insee
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

@JsonTypeName("Competence")
@Data
public class Competence extends ServiceObject implements ServiceChild {
    private static final long serialVersionUID = -2632307492758265027L;
    //@JsonTypeId
    private String typeObjet = ObjectType.COMPETENCE.name;

    public final static int TYPE_ALL = 0;
    public final static int TYPE_INSTALL = 1;
    public final static int TYPE_LOGISTIQUE = 2;
    public final static int TYPE_REPARATION_ATELIER = 3;
    public final static int TYPE_REPARATION_IAD = 4;
    public final static int TYPE_FORMATION = 5;    
    
    private int typeCompetence; // Voir valeurs TYPE_XXX
    private String domainUser;
    private String idParent; // Proprietaire de la competence (agence, tech)
    private String typeParent; // Type de proprietaire
    private String typeValue; // Type d'objet de la competence (activite, modele, groupe, classe...)
    private String refValue; // Id de l'objet de la competence
    private String refZone; // Id de la zone a laquelle est liee la competence
    private int nbInterAn; // Nb de prestations possibles annuelles
    private boolean formation; // Competence pour une formation
    
    // Tarification
    private double tarifForfait; // Valeur pour un forfait simple
    private double tarifForfaitLourd; // Valeur pour un forfait lours
    private double complementDepl; // Facturation par defaut d'un deplacement
    private int kmForfait; // KM inclus dans le forfait par defaut
    private double kmHorsForfait; // Valeur par km au dela de kmForfait
}
