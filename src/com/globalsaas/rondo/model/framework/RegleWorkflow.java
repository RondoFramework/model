/*------------------------------------------------------------------------------
 * Nom de la classe : RegleWorkflow
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 01 juin 2017
 *------------------------------------------------------------------------------
 * Description :
 * Regle de workflow, permettant de generer une ou plusieurs actions sur 
 * l'enregistrement d'une operation sur une affaire, une prestation ou un acte
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.framework;

import java.util.ArrayList;

import lombok.Data;

@Data
public class RegleWorkflow extends RondoPersistObject {
    private String libelle; // Texte libre, nom de la regle
    private String typeSource; // Type de source sur laquellle s'applique la regle (prestation, affaire, acte)
    private String refFiltreAffaire; // Filtre des affaires pour appliquer la regle
    private int typeOperation; // Type d'operation sur laquelle on reagit. Voir variables Operation.TYPE_XXX
    private boolean envoiReporte; // Flag pour reporter l'application de la regle
    private int nbJours; // Nb de jours du report
    private boolean joursOuvres; // Prise en compte des jours ouvres pour le calcul du report
    private boolean heureFixe; // On applique la regle sur une heure fixe
    private String heureAction; // Pour une heure fixe, quelle est l'heure de l'application
    private ArrayList<ActionWorkflow> actions; // Liste des actions a effectuer sur application de la regle
    private boolean inactive; // Flag pour desactiver l'application de la regle
}
