/*------------------------------------------------------------------------------
 * Nom de la classe : CRUDEvent
 * Produit : Rondo
 * Module : Model
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 07 juillet 2017
 *------------------------------------------------------------------------------
 * Description :
 * Information transmise au framework lors de l'enregistrement d'un objet. Les
 * differentes webapps peuvent etre amenees a traiter cet evenement en fonction
 * de regles definies au niveau du director
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.framework;

import com.globalsaas.rondo.model.service.ServiceObject;

import lombok.Data;

@Data
public class CRUDEvent {
    public final static int TYPE_CREATION = 0;
    public final static int TYPE_MODIFICATION = 1;
    public final static int TYPE_SUPPRESSION = 2;
    
    private String typeObjet; // Type de donnees (voir TypesUtils)
    private String idObjet; // Identifiant de l'objet modifie
    private String domain; // Domaine de l'objet
    private int typeOperation; // Type d'operation, voir variables TYPE_XXX
    private ServiceObject oldData; // Pour une modification ou suppression, objet avant la modif
    private ServiceObject data; // Objet apres operation effectuee
    private Profil profil; // Pour identifier quelle est la connexion qui a initie l'evenement

}
