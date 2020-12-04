/*------------------------------------------------------------------------------
 * Nom de la classe : TacheType
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Configuration d'un type de tache 
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

@JsonTypeName("TacheType")
@Data
public class TacheType extends ServiceObject {
    private static final long serialVersionUID = 7598121288134764068L;
    //@JsonTypeId
    private String typeObjet = ObjectType.TACHE_TYPE.name;

    public final static int GROUPE_AUCUN = 0;
    public final static int GROUPE_PLANIF = 1;
    public final static int GROUPE_SUPPORT = 2;
    public final static int GROUPE_FINANCE = 3;
    public final static int GROUPE_ADMIN = 4;
    public final static int GROUPE_LOGISTIQUE = 5;
    
    private String groupe; // Groupe du type (voir variables GROUPE_XXX)
    private String  libelle; // Libelle du groupe

    @Override
    public String toString() {
        return libelle;
    }
}
