/*------------------------------------------------------------------------------
 * Nom de la classe : FollowdObject
 * Produit : Rondo
 * Module : Model
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 07 juillet 2017
 *------------------------------------------------------------------------------
 * Description :
 * Description d'un objet suivi par un client. Ex : lorsqu'une affaire est 
 * ouverte par un utilisateur, il enregistre un FollowObject sur le Director
 * qui pourra prevenir des webapps d'envoyer une notification en cas de 
 * modification de cette affaire.
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */

package com.globalsaas.rondo.model.framework;

import lombok.Data;

@Data
public class FollowedObject {
    private String token;
    private String domain;
    private String refWebApp;
    private String typeObject;
    private String idObject;
}
