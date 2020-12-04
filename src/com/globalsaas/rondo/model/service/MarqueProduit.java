/*------------------------------------------------------------------------------
 * Nom de la classe : MarqueProduit
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Marque pour des pieces ou produits. Permet de relier une marque a un
 * fournisseur (Ex : Bosch et Siemens lies a BSH)
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("MarqueProduit")
@Data
public class MarqueProduit extends ServiceObject {
    private static final long serialVersionUID = -6062949946544262094L;
    //@JsonTypeId
    private String typeObjet = ObjectType.MARQUE_PRODUIT.name;
    
    private String idFournisseur; // Identifiant du fournisseur
    private String marque; // Nom de la marque


    @Override
    public int compareTo(Object o) {
        if (o == null || !o.getClass().equals(MarqueProduit.class)) {
            return 0;
        }
        MarqueProduit m = (MarqueProduit)o;
        if (marque == null || m.getMarque() == null) {
            return 0;
        }
        return marque.compareTo(m.getMarque());
    }

    @Override
    public String toString(){
        return marque;
    }
}
