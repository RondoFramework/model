/*------------------------------------------------------------------------------
 * Nom de la classe : SimpleDAOConcept
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * JavaBean simple permettant de transmettre une chaine de caractere et un id
 * qui lui est associe. Utile pour passer des valeurs de parametres
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeName("SimpleDAO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleDAOConcept implements ServiceConcept, Comparable {
    private static final long serialVersionUID = -4742746273165049338L;
    //@JsonTypeId
    private String typeObjet = ObjectType.SIMPLE_DAO.name;
    
    private String id;
    private String libelle;

    @Override
    public String toString() {
        return libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof SimpleDAOConcept)) {
            return false;
        }
        return id == ((SimpleDAOConcept)o).getId();
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || !(o instanceof SimpleDAOConcept)) {
            return 0;
        }
        SimpleDAOConcept sc = (SimpleDAOConcept)o;
        if (libelle != null && sc.getLibelle() != null) {
            return libelle.compareTo(sc.getLibelle());
        }
        String sId = getId();
        if (sId == null) {
            sId = "";
        }
        return sId.compareTo(sc.getId());
    }
}
