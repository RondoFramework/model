/*------------------------------------------------------------------------------
 * Nom de la classe : DomainChange
 * Produit : Rondo
 * Module : Model
 * Auteurs : Globalsaas
 * CCopyright (c) 2020 Myfowo
 * 1e version : 30 juillet 2020
 *------------------------------------------------------------------------------
 * Description :
 * Compteur de changement enregistre en BDD.
 * Les instances d'application ecoutent les modifications en BDD. Ensuite, s'il
 * y a une modification sur l'objet de son domaine, le serveur recharge la 
 * configuration du domaine.
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : Gilles
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.framework;

import com.globalsaas.rondo.model.dao.GenericFirestoreDAO;

import lombok.Data;

@Data
public class DomainChange extends GenericFirestoreDAO {
    private Long compteur;
}