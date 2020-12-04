/*------------------------------------------------------------------------------
 * Nom de la classe : StationCompetence
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 01 juin 2017
 *------------------------------------------------------------------------------
 * Description :
 * Objet retourne par une recherche de station competente 
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.rest.model;

import java.util.ArrayList;

import com.globalsaas.rondo.model.service.Agence;
import com.globalsaas.rondo.model.service.Competence;
import com.globalsaas.rondo.model.service.Memo;
import com.globalsaas.rondo.model.service.QualiteStation;
import com.globalsaas.rondo.model.service.SousTraitant;
import com.globalsaas.rondo.model.service.ValidCompetence;

import lombok.Data;

@Data
public class StationCompetente implements java.io.Serializable{
    private static final long serialVersionUID = 2255356604045728550L;

    public final static int TYPE_CHOIX_NONE = 0;
    public final static int TYPE_CHOIX_PRIO = 1;
    public final static int TYPE_CHOIX_NON_PRIO = 2;    
    
    private Competence competence; // Competence qui repond au besoin
    private Agence agence; // Agence qui represente le sous-traitant
    private ValidCompetence agrement; // Agrement fournisseur
    private ValidCompetence contrat; // Contrat d'agrement de service domaine
    private QualiteStation qualite; // Valeurs calculees pour representer la qualite de la station
    private SousTraitant sousTraitant; // Representation du sous-traitant
    private ArrayList<Memo> memos; // Liste des memos a prendre en compte par le gestionnaire
    private double distance; // Distance en km pour que la station aille sur la prestation
    private int tempsTrajet; // Temps en minutes pour que la station atteigne la prestation
    private int typeChoix; // Type de choix a effectuer. Voir TYPE_CHOIX_XXX
}
