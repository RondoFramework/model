/*------------------------------------------------------------------------------
 * Nom de la classe : WebAppAction
 * Produit : Rondo
 * Module : Model
 * Auteurs : Myfowo
 * CCopyright (c) 2019 Globalsaas
 * 1e version : 31 decembre 2019
 *------------------------------------------------------------------------------
 * Description :
 * Action qu'une webapp peut executer. Le lancement peut etre efectue par la 
 * webapp, par une requete d'une autre webapp ou par un evenement du workflow
 * ou une programmation
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.framework;

import lombok.Data;

@Data
public class ActionDef {
    public final static String TYPE_RESULT_NONE = "NONE";
    public final static String TYPE_RESULT_OBJECT = "SERVICE_OBJECT";
    public final static String TYPE_RESULT_LIST_OBJECT = "LIST_SERVICE_OBJECTS";
    public final static String TYPE_RESULT_URL_VIEW = "URL_VIEW";
    public final static String TYPE_RESULT_URL_DOWNLOAD = "URL_DOWNLOAD";
    public final static String TYPE_RESULT_BYTE_ARRAY = "BYTE_ARRAY";

    private String reference; // Reference unique de l'action
    private String designation; // Designation, texte libre pour designer l'action
    private String description; // Texte libre pour decrire l'action
    private String webAppRef; // Reference de la webapp
    private String role; // Pour une gestion des droits, si elle existe cette valeur doit faire partie des roles de l'utilisateur
    private String url; // URL d'envoi d'un message POST avec l'action
    private String typeDataIn; // Pour requetes autre que get, format de l'objet en entree (voir ObjectType pour les valeurs)
    private String typeDataOut; // Valeur de l'objet retourne (voir ObjectType pour les valeurs). Pour un formatRetour : JSON
    private String typeRetour; // Type de format retour : HTML, JSON, BINARY
    
    private String defParam1; // Nom du parametre complementaire
    private String defParam2;
    private String defParam3;
    private String defParam4;
    private String defParam5;
    private String classeParam1; // Classe du parametre complementaire
    private String classeParam2;
    private String classeParam3;
    private String classeParam4;
    private String classeParam5;

}