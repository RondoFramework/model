/*------------------------------------------------------------------------------
 * Nom de la classe : ArrayListId
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Liste avec identifiant 
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import java.util.List;

public class ListId implements java.io.Serializable{
    private static final long serialVersionUID = 54788745512L;

    private final List list;
    private final long id;
    
    /** Creates a new instance of ArrayListId */
    public ListId(final long id, final List list) {
        this.list = list;
        this.id = id;
    }
    
    public List getList(){
        return list;
    }
    
    public long getId(){
        return id;
    }
    
}
