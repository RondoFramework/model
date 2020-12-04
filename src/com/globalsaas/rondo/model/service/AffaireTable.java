/*------------------------------------------------------------------------------
 * Nom de la classe : AffaireTable
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * Copyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 * 2e version : 31 decembre 2019
 *------------------------------------------------------------------------------
 * Description :
 * Table agregee pour affichage des affaires. Les valeurs sont generees lors des
 * modifications sur les differents objets presentes dans cette table.
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeName("AffaireTable")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AffaireTable extends ServiceObject {
    private static final long serialVersionUID = 43598215748L;

    @Builder.Default
    private String typeObjet = ObjectType.AFFAIRE_TABLE.name;

    private String idAffaire;
    private String idClient;
    private String nomAffaire;
    private long dateOuverture;
    private String typeAffaire;
    private String nomTypeAffaire;
    private String statutAffaire;
    private String departementConso;
    private String codePostalConso;
    private int nbPieces;
    private String statutPieces;
    private String reference;
    private String refDo;
    private int nbPrestations;
    private String statutPrestations;
    private int nbInter;
    private int nbInterTermine;
    private int nbInterAPlanifier;
    private int nbInterPlanifie;
    private String statutWorkflowInter;
    private String statutInter;
    private long codeNokInter;
    private String conso;
    private String contactConso;
    private String villeConso;
    private String telConso;
    private String mobileConso;
    private String emailConso;
    private double easting;
    private double northing;
    private String refClient;
    private String idAgenceGestion;
    private String domaineGestion;
    private int nbAgencesReparation;
    private String nomAgenceReparation;
    private String domainesReparation;
    private String idGestionnaire;
    private String nomGestionnaire;
    private long dateDerniereInter;
    private Double montantServiceAchat;
    private Double montantMaterielAchat;
    private Double montantServiceVente;
    private Double montantMaterielVente;
    private Double montantFacture;
    private Double montantPaye;
    private String statutDevis;
    private String statutFacture;
    private int nbDevis;
    private boolean clientPro;
    private long dateMaj;
    private String idEmpMaj;
    private String permView; // Au format email1|domain2|user3|domain4...
    private String permAdmin;
    private String permEdit;
    private String permAssign;
    private String permPlanning;
    private String permTech;
    private String permInvoice;

    @Override
    public String toString() {
        return "Affaire "+reference; 
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || !(o instanceof AffaireTable)) {
            return 0;
        }
        AffaireTable at = (AffaireTable)o;
        int value = (int)(dateOuverture - at.getDateOuverture());
        if (value != 0) {
            return value;
        }
        String sId = getId();
        if (sId == null) {
            sId = "";
        }
        return sId.compareTo(at.getId());
    }
}
