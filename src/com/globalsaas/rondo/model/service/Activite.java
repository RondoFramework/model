/*------------------------------------------------------------------------------
 * Nom de la classe : Activite
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Une activite represente un type de prestation. Il permet de deninir des 
 * permissions, et de preciser le type de service pour une prestation.
 * Les modeles d'intervention pour les actes sont lies a l'activite
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;
@JsonTypeName("Activite")
@Data
public class Activite extends ServiceObject {
    private static final long serialVersionUID = 878745542212L;
    //@JsonTypeId
    private String typeObjet = ObjectType.ACTIVITE.name;

    private String nom; // Nom de l'activite
    private String shortName; // Nom cout de l'activite
    private String logo; // Logo qui permet de presenter l'activite
    private String logoPetit; // Logo qui permet de representer l'activite sur le planning
    
    @Override
    public String toString() {
        return getNom();
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || !o.getClass().equals(Activite.class)) throw new ClassCastException();
        return nom.compareTo(((Activite)o).getNom());
    }

}
