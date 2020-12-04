/*------------------------------------------------------------------------------
 * Nom de la classe : Delegation
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * Copyright (c) 2020 Myfowo
 * 1e version : 29/06/2020
 *------------------------------------------------------------------------------
 * Description :
 * Une delegation permet de charger une 
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Delegation implements Cloneable {
    public final static String TYPE_ACTEUR_USER = "EMAIL";
    public final static String TYPE_ACTEUR_DOMAIN = "DOMAIN";

    public final static String PERM_NONE = "NONE";
    public final static String PERM_ALL = "ALL";
    public final static String PERM_VIEW = "VIEW";
    public final static String PERM_ADMIN = "ADMIN";
    public final static String PERM_EDIT = "EDIT";
    public final static String PERM_ASSIGN = "ASSIGN";
    public final static String PERM_PLANNING = "PLANNING";
    public final static String PERM_TECH = "TECH";
    public final static String PERM_INVOICE = "INVOICE";

    private String typeActeur; // Type d'acteur qui reçoit la délégation
    private String acteur; // Identifiant de l'acteur (email ou nom de domaine) qui reçoit la délégation
    private String permission; 

    @Override
    public Object clone() {
        Object result = null;
        try {
            result = super.clone();
        } catch (CloneNotSupportedException e) {

        }
        return result;
    }
}