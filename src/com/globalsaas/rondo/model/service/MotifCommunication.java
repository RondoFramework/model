/*------------------------------------------------------------------------------
 * Nom de la classe : MotifCommunication
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Definition d'un motif de communication. Depend d'un domaine, ce qui permet
 * a un client de definir sa propre terminologie
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("MotifCommunication")
@Data
public class MotifCommunication extends ServiceObject {
    private static final long serialVersionUID = -8891666612480866598L;
    //@JsonTypeId
    private String typeObjet = ObjectType.MOTIF_COMMUNICATION.name;

    private String nom; // Libelle du motif
       
    @Override
    public int compareTo(Object o) {
        if (o == null || !o.getClass().equals(MotifCommunication.class)) throw new ClassCastException();
        
        return nom.compareTo(((MotifCommunication)o).getNom());
    }

    @Override
    public String toString() {
        return getNom();
    }
}
