/*------------------------------------------------------------------------------
 * Nom de la classe : TypePayeurEnum
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Enumeration avec les types de payeur possibles pour les pieces et la MO
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

public enum TypePayeurEnum {

    PAYEUR_CLIENT(0, "Client final"),
    PAYEUR_DO(1, "Donneur d'ordre"),
    PAYEUR_MARQUE(2, "Marque"),
    PAYEUR_GARANTIE_STATION(3, "Garantie station");
    private int type;
    private String libelle;

    private TypePayeurEnum(int type, String libelle) {
        this.type = type;
        this.libelle = libelle;
    }

    public int getType() {
        return this.type;
    }

    public boolean isType(int type) {
        return this.type == type;
    }

    public static int getType(String libelle) {
        for(TypePayeurEnum typePayeur : values()) {
            if(typePayeur.libelle == libelle) {
                return typePayeur.type;
            }
        }
        return -1;
    }

    public static String getLibelle(int type) {
        for (TypePayeurEnum typePayeur : values()) {
            if (typePayeur.type == type) {
                return typePayeur.libelle;
            }
        }
        return "Inconnu";
    }
}
