/*------------------------------------------------------------------------------
 * Nom de la classe : EtatInter
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 16 juin 2017
 *------------------------------------------------------------------------------
 * Description :
 * Description d'un etat ou statut pour un evenement.
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

@JsonTypeName("EtatInter")
@Data
public class EtatInter extends ServiceObject {
    private static final long serialVersionUID = -6723528611483946080L;
    //@JsonTypeId
    private String typeObjet = ObjectType.ETAT_INTER.name;
    
    private String domainUser;
    private int numero;
    private String libelle;
    private boolean facturable;
    private boolean codeRetourActive;
    private boolean apparencePlanning;
    private boolean apparencePlanif;
    private boolean crEdite;
}
