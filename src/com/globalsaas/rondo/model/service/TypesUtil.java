/*------------------------------------------------------------------------------
 * Nom de la classe : TypesUtil
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Description des objets du modele de donnees RONDO
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

public class TypesUtil {

    private TypesUtil() {
    }

    public static ObjectType getObjectType(int type) {
        for (ObjectType item : ObjectType.values()) {
            if (item.typeId == type) {
                return item;
            }
        }
        return null;
    }

    public static ObjectType getObjectType(String typeName) {
        for (ObjectType item : ObjectType.values()) {
            if (item.name.equalsIgnoreCase(typeName)) {
                return item;
            }
        }
        return null;
    }

    public static ObjectType getObjectType(Class typeClass) {
        for (ObjectType item : ObjectType.values()) {
            if (item.typeClass.equals(typeClass)) {
                return item;
            }
        }
        return null;
    }

    public static String getTypeLabel(int type) {
        ObjectType item = getObjectType(type);
        if (item != null) {
            return item.name;
        }
        return null;
    }

    public static String getTypeDbName(int type) {
        ObjectType item = getObjectType(type);
        if (item != null) {
            return item.storage;
        }
        return null;
    }

}
