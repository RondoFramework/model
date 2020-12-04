/*------------------------------------------------------------------------------
 * Nom de la classe : IDevisFacturation
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Interface pour un devis ou une facture
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import java.util.ArrayList;
import java.util.List;

import com.google.cloud.firestore.annotation.Exclude;

import lombok.Data;

@Data
public abstract class ServiceFinanceObject extends ServiceObject {
    private static final long serialVersionUID = -8146356668933083652L;
    
    private String commercial;
    private long compteur;
    private long dateEmission;
    private String numero;
    private String idAffaire;
    private String idParent;
    private String typeParent;    
    private String idClient;
    private String idEmetteur;
    private String idEtablissement;
    private String domainClient;
    private String idEtablissementClient;
    private String idContact;// Identifiant du contact de facturation
    private boolean export; // Indique si le document a ete exporte
    private int nbRelance; // Nb de relances effectuees
    private long dateRelance; // Date a laquelle faire la premiere relance
    private Long dateDerniereRelance; // Date a laquelle la derniere relance a ete effectuee

    private List<Article> elements;
    private List<ReductionDf> reductions;
    private List<Reglement> acomptes;
    private Double montant;
    private Double montantHt;
    private Double montantHtNet; // Montant HT apres remise
    private Double montantRemise; // Montant totale de la remise sur la facture
    private Double montantTva; // Montant de la TVA
    private int delaiReglement; // Delai de reglement
    private int typeDelai; // 0 : jours; 1 : semaines; 2 : Mois; 3 : ans
    private String modeReglement; // Indication du mode de reglement a afficher sur la facture

    @Exclude
    void addAcompte(Reglement reglement) {
        if (acomptes == null) {
            acomptes = new ArrayList<Reglement>();
        }
        acomptes.add(reglement);
    }

    @Exclude
    void addElement(Article element) {
        if (elements == null) {
            elements = new ArrayList<Article>();
        }
        elements.add(element);
    }

    @Exclude
    void addReduction(ReductionDf reduction) {
        if (reductions == null) {
            reductions = new ArrayList<ReductionDf>();
        }
        reductions.add(reduction);
    }
}
