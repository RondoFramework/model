/*------------------------------------------------------------------------------
 * Nom de la classe : BlocageStation
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Periode de blocage d'une station, qui interdit le mandat 
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */

package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("BlocageStation")
@Data
public class BlocageStation extends ServiceObject {
    private static final long serialVersionUID = 5406338735682369247L;
    //@JsonTypeId
    private String typeObjet = ObjectType.BLOCAGE_STATION.name;
    
    private String idAgence; // Identifiant de l'agence qui represente la station
    private Long debut; // Debut de la periode de blocage du mandat
    private Long fin; // Fin de la periode de blocage du mandat
    private String remarques; // Commentaires libres pour decrire le blocage

}
