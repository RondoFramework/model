/*------------------------------------------------------------------------------
 * Nom de la classe : Operation
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Objet permettant d'historiser une operation effectuee, et de declencher une
 * regle de workflow
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

@JsonTypeName("Operation")
@Data
public class Operation extends ServiceObject implements ServiceAffaireObject, ServiceChild, DelegationContainer, MetadataContainer {
    private static final long serialVersionUID = 6400286453870978429L;
    //@JsonTypeId
    private String typeObjet = ObjectType.OPERATION.name;

    public final static int TYPE_AUTRE = 0;
    public final static int TYPE_PLANIF = 1;
    public final static int TYPE_PLANIF_SLOT = 2;
    public final static int TYPE_PLANIF_SLOT_CONSO = 3;
    public final static int TYPE_CREATION = 4;
    public final static int TYPE_ANNULATION = 5;
    public final static int TYPE_EDITION_DEVIS = 6;
    public final static int TYPE_REFERENCEMENT_PIECE = 7;
    public final static int TYPE_VALID_ADMIN = 8;
    public final static int TYPE_VALID_TECH = 9;
    public final static int TYPE_ACCEPT_DEVIS = 10;
    public final static int TYPE_REFUS_DEVIS = 11;
    public final static int TYPE_EDITION_CR = 12;
    public final static int TYPE_AJOUT_PIECE = 13;
    public final static int TYPE_BLOCAGE_DOSSIER_TECH = 14;
    public final static int TYPE_BLOCAGE_DOSSIER_DO = 15;
    public final static int TYPE_BLOCAGE_DOSSIER_CONSO = 16;
    public final static int TYPE_DEBLOCAGE_DOSSIER = 17;
    public final static int TYPE_REGLEMENT_CB = 18;
    public final static int TYPE_ACCEPT_MANDAT = 19;
    public final static int TYPE_REFUS_MANDAT = 20;
    public final static int TYPE_MANDAT_STATION = 21;
    public final static int TYPE_FACTURATION_DOSSIER = 22;
    public final static int TYPE_ENVOI_CLIENT = 23;
    public final static int TYPE_RECEPTION_ATELIER = 24;
    public final static int TYPE_ENVOI_ATELIER = 25;
    public final static int TYPE_RECEPTION_CLIENT = 26;
    public final static int TYPE_ACTE_TERMINE = 27;
    public final static int NB_TYPES = 28;
    
    private int type; // Type d'operation (voir variables TYPE_XXX)
    private String idParent; // Identifiant de la source (affaire, acte ou prestation)
    private String typeParent; // Type de la source
    private String texte; // Texte de l'operation, en titre
    private Long date; // Date de l'operation
    private String commentaires; // Commentaires, texte libre sur l'operation
    private String employe; // Nom de l'employe qui a effectue l'operation
    private String idAffaire; // Identifiant de l'affaire a laquelle est liee l'operation
    
    private List<Metadata> metadatas;
    private List<Delegation> delegations;

    @Override
    public String toString(){
        return new java.util.Date(getDate())+" - "+texte;
    }

    @Exclude
    public static String getLibelleType(int type) {
        switch (type) {
            case TYPE_ACCEPT_DEVIS:
                return "Acceptation devis";
            case TYPE_AJOUT_PIECE:
                return "Ajout pi\u00e8ce";
            case TYPE_ANNULATION:
                return "Annulation dossier";
            case TYPE_CREATION:
                return "Cr\u00e9ation dossier";
            case TYPE_EDITION_CR:
                return "Edition compte-rendu";
            case TYPE_EDITION_DEVIS:
                return "Edition devis";
            case TYPE_PLANIF:
                return "Planification simple";
            case TYPE_PLANIF_SLOT:
                return "Planification par slot";
            case TYPE_PLANIF_SLOT_CONSO:
                return "Planification par slot (conso)";
            case TYPE_REFERENCEMENT_PIECE:
                return "R\u00e9f\u00e9rencement pi\u00e8ce";
            case TYPE_REFUS_DEVIS:
                return "Refus devis";
            case TYPE_VALID_ADMIN:
                return "Validation administrative";
            case TYPE_VALID_TECH:
                return "Validation technique";
            case TYPE_BLOCAGE_DOSSIER_TECH:
                return "Blocage dossier Tech";
            case TYPE_BLOCAGE_DOSSIER_DO:
                return "Blocage dossier DO";
            case TYPE_BLOCAGE_DOSSIER_CONSO:
                return "Blocage dossier Conso";
            case TYPE_DEBLOCAGE_DOSSIER:
                return "D\u00e9blocage dossier";
            case TYPE_REGLEMENT_CB:
                return "R\u00e9glement client CB";
            case TYPE_ACCEPT_MANDAT:
                return "Mandat accept\u00e9";
            case TYPE_REFUS_MANDAT:
                return "Mandat refus\u00e9";
            case TYPE_MANDAT_STATION:
                return "Envoi mandat station";
            case TYPE_FACTURATION_DOSSIER:
                return "Facturation dossier";
            case TYPE_ENVOI_CLIENT:
                return "Envoi appareil par le client";
            case TYPE_RECEPTION_ATELIER:
                return "R\u00e9ception d'appareil en atelier";
            case TYPE_ENVOI_ATELIER:
                return "Envoi appareil par l'atelier";
            case TYPE_RECEPTION_CLIENT:
                return "R\u00e9ception d'appareil par client";
            case TYPE_ACTE_TERMINE:
                return "Acte Termin\u00e9";
            default:
                return "Autre op\u00e9ration";
        }
    }
    
    @Exclude
    public String getLibelleType() {
        return getLibelleType(type);
    }
}
