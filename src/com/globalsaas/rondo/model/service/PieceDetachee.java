/*------------------------------------------------------------------------------
 * Nom de la classe : PieceDetachee
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Piece detachee, avec informations techniques, d'achat, de statut et de stock 
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

@JsonTypeName("PieceDetachee")
@Data
public class PieceDetachee extends ServiceObject implements ServiceAffaireObject, MetadataContainer {
    private static final long serialVersionUID = 1L;
    //@JsonTypeId
    private String typeObjet = ObjectType.PIECE_DETACHEE.name;

    public static TypePayeurEnum TYPE_PAYEUR;

    public static final int ETAT_OK = 0;
    public static final int ETAT_HS = 1;
    public static final int ETAT_EN_COMMANDE = 3;
    public static final int ETAT_EN_TRANSPORT = 4;
    public static final int ETAT_MAUVAISE_REF = 5;
    public static final int ETAT_MAUVAISE_PIECE = 6; // Bonne ref, mais la piece recue ne corespond pas
    public static final int ETAT_MANQUANTE = 7;

    public static final int STATUT_MODELE = 0;
    public static final int STATUT_A_REFERENCER = 12;
    public static final int STATUT_A_POSER = 11;
    public static final int STATUT_POSEE = 8;
    public static final int STATUT_SUPPRIMEE = 10;
    public static final int STATUT_DEVIS = 1;
    public static final int STATUT_RETOUR = 13;
    
    public static final String getStatut(int statut) {
        switch(statut) {
            case STATUT_MODELE :
                return "Mod\u00e9le";
            case STATUT_A_POSER :
                return "A poser";
            case STATUT_A_REFERENCER :
                return "A r\u00e9f\u00e9rencer";
            case STATUT_POSEE :
                return "Pos\u00e9e";
            case STATUT_SUPPRIMEE :
                return "Supprim\u00e9e / non pos\u00e9e";
            case STATUT_DEVIS :
                return "Pour devis";
            case STATUT_RETOUR :
                return "Retour fournisseur";
            default :
                return "";
        }
    }

    private String idAffaire;
    private String idSta; // Id fourni par le sous-traitant pour synchro
    private String idPrestation; // Id de la prestation a laquelle est attachee la piece
    private String idStock; // Identifiant du stock sur lequel est positionnee la piece 
    private String typeStock; // Type de stock ou est la piece (entrepot, employe, client, transfert)
    private String idStockPreValid; // Identifiant du stock attendu, en attente d'une validation (ex : envoi d'un colis) 
    private String typeStockPreValid; // Type de stock ou la piece doit etre positionnee apres validation (entrepot, employe, client, transfert)
    private String emplacement; // Dans un espace de stockage, on identifie l'emplacement pour stocker la piece
    private String idProduit; // Si on a un produit avec cette reference, on met son id ici
    private String marqueAppareil; // Marque de l'appareil
    private String reference; // Reference commerciale aupres du fournisseur
    private String version; // Reference de la serie aupres du fournisseur
    private String refConstructeur; // Reference constructeur de la piece
    private String designation; // Designation de la piece
    private String nomStock; // Nom du stock
    private String idFournisseur; // Id du fournisseur de la piece
    private String refAppareil; // Reference de l'appareil 
    private int etat; // 0: OK; 1 : HS; 2 : Reserve
    private int quantite; // Quantite de pieces sur la prestation
    private double prixAchatHt; // Prix d'achat de la piece HT
    private double prixVenteHt; // Prix de revente de la piece
    private String dateCommande; // Date de commande de la piece, format ISO
    private String dateReception; // Date de reception de la piece, format ISO
    private String dateReceptionTech; // Date de reception au niveau du technicien, format ISO
    private String datePose; // Date de pose de la piece, format ISO
    
    private String idCommande; // Identifiant du TransfertStock representant la commande au fournisseur
    private int typePayeur; // Indique le payeur de la piece. Voir TypePayeurEnum

    // Informations de reparation
    private String ancienEtat;
    private String ancienNumSerie;
    private String numSerie;
    private String codeSymptome;
    private String codeConditionEtendue;
    private String codeCondition;
    private String codeDefaut;
    private String codeReparation;
    private String codeSection;
    private String reperePlatine;
    private String repereElement;
    private String repereSection;

    
    private int statutDispo; // 0 : ND; 1 : DISPO; 2 : NOM_DISPO
    private int statut; // Sratut de la piece sur le workflow. Voir les variables STATUT_XXX
    private String commentWorkflow; // Commentaires sur la piece, pour decrire le statut de la piece
    private List<Metadata> metadatas;

    @Override
    public String toString(){
        return getId()+" - "+reference+" - "+designation;
    }

    @Exclude
    public String getLibellePayeur() {
        if (typePayeur == 0) {
            return "Client final";
        }
        else if (typePayeur == 1) {
            return "Donneur d'ordre";
        }
        else if (typePayeur == 2) {
            return "Marque";
        }
        if (typePayeur == 3) {
            return "Garantie station";
        }
        else  {
            return "";
        }
    }
}
