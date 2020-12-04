/*------------------------------------------------------------------------------
 * Nom de la classe : ClientNotification
 * Produit : Rondo
 * Module : Model
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 07 juillet 2017
 *------------------------------------------------------------------------------
 * Description :
 * Objet envoye par une webapp a un client, pour notification sur l'interface
 * utilisateur. Les notifications sont enregistrees par nimporte quelle
 * webapp. Par contre, le service de connexion au client transmet la
 * notification au client.
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.framework;

import com.globalsaas.rondo.model.service.ServiceConcept;

import lombok.Data;

@Data
public class ClientNotification {
    private String token;
    private String typeObjet;
    private String idObjet;
    private ServiceConcept objet;

}
