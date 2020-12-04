/*------------------------------------------------------------------------------
 * Nom de la classe : Produit
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Description d'un article au catalogue pour faire de la gestion commerciale 
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("Produit")
@Data
public class Produit extends ServiceObject implements MetadataContainer {
    private static final long serialVersionUID = 1580281107827501720L;
    //@JsonTypeId
    private String typeObjet = ObjectType.PRODUIT.name;

    public static int TYPE_FORFAIT_FIXE = 0;
    public static int TYPE_FORFAIT_VOLUME_AVEC_MIN = 1;
    public static int TYPE_FORFAIT_VOLUME_SANS_MIN = 2;
    public static int TYPE_FORFAIT_GLOBAL = 3;
    
    private String reference; // Reference du produit
    private String designation; // Designation du produit
    private String marque; // Marque de l'article
    private String idFournisseur; // Fournisseur pour le produit
    private String codeEan; // Code EAN du produit
    private String description; // Texte libre pour la description du produit
    private String photo; // URL de la photo du produit
    private Double prixHt; // Prix unitaire HT
    private Double prixHa; // Prix unitaire d'achat
    private Double tauxTVA; // Taux de TVA
    private String idGamme; // Id de la gamme de produit
    private String refComptable; // Reference pour un export en compta
    // JCollab SAV
    private boolean swap; // Le produit sera traite par un swap
    private boolean faibleValeur; // Le produit est de faible valeur, pas de prestation de reparation
    private boolean echange; // Echange du produit en cas de panne
    private boolean ferraillage; // En cas d'echec de reparation, l'appareil sera ferraille
    private boolean IAD; // Une intervention a domicile doit etre programmee pour la reparation du produit
    private boolean ssTraitance; // On fait appel a un sous-traitant pour reparer ce produit
    private String idSousTraitant; // Identifiant du sous-traitant a contacter pour un SAV sur ce produit
    private String dateDebutCommercialisation; // Date de debut de commercialisation, format ISO
    private String dateFinCommercialisation; // Date de fin de commercialisation, format ISO
    
    // forfait
    private boolean tarifForfaitaire; // Definit si on a un tarif forfaitaire sur le produit
    private int typeForfait; // Type de forfait. Voir variables TYPE_FORFAIT_XXX
    
    // details sur la gestion des stocks
    private double poidsNet; 
    private int coefPoids; // 1 pour 1g et 1000 pour 1kg
    private Double longueur;
    private Double largeur;
    private Double hauteur;
    private int coefLongueur; // 1 pour 1 cm, 10 pour 1dm, 100 pour 1m
    private Double volume;
    private Double stockMini;
    private Double stockAlerte;
    private Double quantiteRef;
    private String uniteRef;

    private List<Metadata> metadatas;
    
    @Override
    public String toString() {
        return this.getReference()+" - "+this.getDesignation();
    }
}
