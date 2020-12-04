/*------------------------------------------------------------------------------
 * Nom de la classe : ReductionDf
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Reduction sur devis ou facture
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("ReductionDf")
@Data
public class ReductionDf extends ServiceObject implements ServiceChild {
    private static final long serialVersionUID = -2292745286780417851L;
    //@JsonTypeId
    private String typeObjet = ObjectType.REDUCTION_DF.name;
    
    public static final int CALCUL_POURCENT = 0;
    public static final int CALCUL_MONTANT = 1;
    
    private String idParent; // Identifiant de la source (devis ou facture)
    private String typeParent; // Type de la source
    private int typeCalcul; // ype de calcul (voir variables CALCUL_XXX)
    private String libelle; // Libelle de la reduction
    private double valeur; // Valeur en % ou en montant en fonction du type

    @Override
    public String toString() {
        return libelle;
    }
}
