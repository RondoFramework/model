/*------------------------------------------------------------------------------
 * Nom de la classe : TachePriorite
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Identifiant de priorite pour une tache
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
import com.globalsaas.rondo.model.service.ServiceConcept;
import com.globalsaas.rondo.model.service.ServiceObject;

import lombok.Data;

@JsonTypeName("TachePriorite")
@Data
public class TachePriorite extends ServiceObject implements ServiceConcept {
   private static final long serialVersionUID = 8276444496153957190L;
   //@JsonTypeId
   private String typeObjet = ObjectType.TACHE_PRIORITE.name;

    private String libelle; // Lobelle de la priorite
}
