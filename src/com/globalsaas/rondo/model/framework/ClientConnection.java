/*------------------------------------------------------------------------------
 * Nom de la classe : ClientConnection
 * Produit : Rondo
 * Module : Model
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 07 juillet 2017
 *------------------------------------------------------------------------------
 * Description :
 * Lorsqu'un client est connecte au serveur, il genere un objet ClientConnection
 * qui permet de l'identifier par l'ensemble des webapps.
 * On peut se servir de cette information pour envoyer des informations
 * montantes vers le client en cas d'identification d'une information importante
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.framework;

import lombok.Data;

@Data
public class ClientConnection {
    private String token; // Information retournee par le serveur lors de la premiere connexion d'identification
    private long firtsConnection; // Timestamp de la premiere connexion
    private long lastConnection; // Timestamp de la derniere connexion
    private long expiration; // Expiration de la session
    private long idUser; // Identifiant du user qui s'est connecte

}
