/*------------------------------------------------------------------------------
 * Nom de la classe : ServiceConcept
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 * 2e version : 24 decembre 2019, pour coller au nouveau modele Rondo
 *------------------------------------------------------------------------------
 * Description :
 * Interface pour un objet du modele de donnees RONDO Service
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import java.io.Serializable;
public interface ServiceConcept extends Serializable {

    String getId();
    void setId(String id);
    String getTypeObjet();
    
}
