/*------------------------------------------------------------------------------
 * Nom de la classe : Stock
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 01 juin 2017
 *------------------------------------------------------------------------------
 * Description :
 * Representation d'un stock sur une reference. Permet de suivre la 
 * disponibilite d'un produit, et de gerer les entrees et sorties
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

@JsonTypeName("Stock")
@Data
public class Stock extends ServiceObject implements MetadataContainer {
    private static final long serialVersionUID = -2110332619417996270L;
    //@JsonTypeId
    private String typeObjet = ObjectType.STOCK.name;

    public static final int TYPE_PIECE_DETACHEE = 0;
    public static final int TYPE_ACCESSOIRE = 1;
    public static final int TYPE_PRODUIT_FINI = 2;
    
    public static final int STATUT_COURANT = 0;
    public static final int STATUT_RESERVE = 1;
    public static final int STATUT_HS = 2;
    public static final int STATUT_TAMPON = 3;
    
    private String idProduit; // Pour un produit identifie dans le catalogue
    private String refProduit; // Reference du produit en stock
    private int typeProduit; // Type de materiel en stock. Voir variables TYPE_XXX
    private String designationProduit; // Designation du produit en stock
    private String idFournisseur; // Identification du fournisseur du produit
    private String idStock; // Identification de la zone de stockage
    private String typeStock; // Type de zone de stockage (entrepot, client, employe, transfert)
    private Double stockMin; // Valeur min de stock, permet de gerer une alerte
    private Double stockMax; // Valeur max de stock, permet de gerer une alerte
    private Double stockCourant; // Valeur courante de stock sur cet emplacement
    private boolean suivi; // Flag pour gerer les alertes de stock
    
    private String emplacement; // Sur la zone de stockage, gestion de la localisation
    private Double prixAchatHT; // Prix d'achat pour ce produit
    private Double prixVenteHT; // Prix de vente pour ce produit
    private String codeTaille; // Pour une gestion des emplacements par taille
    private int statut; // Type d'utilisation du stock. Voir variables STATUT_XXX
    private String instructions; // Texte libre, pour donner des ordres de mouvement

    private List<Metadata> metadatas;
    
    @Exclude
    public String getNomType() {
        String result = "Pi\u00e8ce d\u00e9tach\u00e9e";
        if (getTypeProduit() == TYPE_ACCESSOIRE) {
            result = "Accessoire";
        }
        else if (getTypeProduit() == TYPE_PRODUIT_FINI) {
            result = "Produit fini";
        }
        return result;
    }
    
    @Override
    public String toString() {
        return getTypeObjet()+" - "+getNomType()+" - "+getRefProduit();
    }
}
