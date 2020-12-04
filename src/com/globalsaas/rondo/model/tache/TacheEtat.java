/*------------------------------------------------------------------------------
 * Nom de la classe : TacheEtat
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Configuration des etats que peut prendre une tache
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.tache;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.globalsaas.rondo.model.service.ObjectType;
import com.globalsaas.rondo.model.service.ServiceObject;

import lombok.Data;

@JsonTypeName("TacheEtat")
@Data
public class TacheEtat extends ServiceObject {
    private static final long serialVersionUID = -7698703262607645911L;
    //@JsonTypeId
    private String typeObjet = ObjectType.TACHE_ETAT.name;
    
    private String libelle; // Libelle de l'etat
}
