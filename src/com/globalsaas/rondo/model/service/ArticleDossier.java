/*------------------------------------------------------------------------------
 * Nom de la classe : ArticleDossier
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Article de valorisation sur une affaire. Lie a une affaire, une prestation ou
 * un acte.
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

@JsonTypeName("ArticleDossier")
@Data
public class ArticleDossier extends ServiceObject implements ServiceAffaireObject, ServiceChild, MetadataContainer {
    private static final long serialVersionUID = -3181900168202172157L;
    //@JsonTypeId
    private String typeObjet = ObjectType.ARTICLE_DOSSIER.name;

    public static TypePayeurEnum TYPE_PAYEUR;
    
    public final static int FACT_AUCUN = 0;
    public final static int FACT_FACTURE_AFFAIRE = 1;
    public final static int FACT_FACTURATION_DO = 2;
    public final static int FACT_AVOIR = 3;
    public final static int FACT_GARANTIE_REP = 4;
    
    public final static int VALID_AUCUN = 0;
    public final static int VALID_OK = 1;
    public final static int VALID_NOK = 2;

    private String reference; // Reference de l'article
    private String idAffaire; // Identifiant de l'affaire sur laquelle on a la facturation
    private String designation; // Designation de l'article
    private String type; // Type d'article, pour ventilation de la facturation (service, materiel, deplacement)
    private double quantite; // Quantite
    private String typeParent; // Type de document source (affaire, acte, prestation)
    private String idParent; // Identifiant de l'affaire, l'acte ou la prestation
    private int typePayeur; // Type de facturation : DO, client final, avoir marque (voir TYPE_PAYEUR_ENUM)

    private String domainAffaire; // Domaine de l'affaire
    
    private double prixAchat;
    private double prixVente;
    private String idFactureVente; // identifiant de la facturation vente du DO
    private int typeFacturationVente; // Type de facturation au DO (voir variables FACT_XXX)
    private String nomFactureVente; // Nom de la facturation (numero de facture ou de projet de facturation)
    private int validFacturationVente; // Indique l'etat de validation de la facturation DO (Voir variables VALID_XXX)
    private String commentaireNokValidationVente; // Commentaire receptionne par le DO pour la facturation
    
    private String idFactureAchat; // Identifiant de la facturation achat du DO
    private int typeFacturationAchat; // Type de facturation au gestionnaire (voir variables FACT_XXX)
    private String nomFacturationAchat; // Nom de la facturation achat (numero de facture ou de projet de facturation presta)
    private int validFacturationAchat; // Indique l'etat de validation de la facturation du prestataire (Voir variables VALID_XXX)
    private String commentaireNokAchat; // Commentaire du prestataire pour non validation de l'article

    private List<Metadata> metadatas;

    @Override
    public String toString() {
        return getDomain()+ " - " + getQuantite() + " X " + getDesignation();
    }
}
