/*------------------------------------------------------------------------------
 * Nom de la classe : Article
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
 * 2e version : 24 decembre 2019, pour coller au nouveau modele Rondo
 *------------------------------------------------------------------------------
 * Description :
 * Article d'un devis ou d'une facture 
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

@JsonTypeName("Article")
@Data
public class Article extends ServiceObject implements ServiceChild, MetadataContainer {
    private static final long serialVersionUID = 58432125878952L;
    //@JsonTypeId
    private String typeObjet = ObjectType.ARTICLE.name;

    private String ref; // Reference de l'article
    private double prixUnitaire; // prix unitaire HT d'un article
    private double tva; // Taux de TVA (valeurs comprises entre 0 et 1)
    private String designation; // Libelle de l'article sur les documents comptables
    private String type; // Type d'article pour ventilation en compta (service, materiel, deplacement...)
    private double quantite; // Quantite d'articles sur le document
    private String typeParent; // Type de document source (devis, facture)
    private String idParent; // Identifiant du devis ou de la facture
    private boolean rattrape; // Definit si c'est un article de rattrapage sur une facturation deja efectuee
    private String titre; // Valeur texte pour affichage sur un devis ou une facture
    private String remarques; // Texte libre pour des remarques sur un article
    private int typeReduction; // Type de reduction a appliquer (Voir variables REDUCTION_XXX)
    private Double valeurReduction; // Valeur de la reduction
    private String localisation; // Pour un devis, premier titre pour classement et affichage
    private String sousLocalisation; // Pour un devis, sous-titre pour classement et affichage
    private String unite; // Unite representant la quantite
    private Integer ordre; // Ordre d'affichage dans le document
    private List<Metadata> metadatas;
    
    public static final int REDUCTION_AUCUNE = 0;
    public static final int REDUCTION_FIXE = 1;
    public static final int REDUCTION_POURCENT = 2;
    public static final int REDUCTION_QUANTITE = 3;
    
    public int compareTo(Object o) {
        if (o == null || !o.getClass().equals(Article.class)) return 0;
        long idCompare = getIdParent().compareTo(((Article)o).getIdParent());
        if (idCompare != 0) return (int)idCompare;
        idCompare = ordre - ((Article)o).getOrdre();
        return (int)idCompare;
    }
    @Override
    public String toString() {
        return quantite + " X " + designation;
    }
}
