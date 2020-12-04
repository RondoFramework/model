/*------------------------------------------------------------------------------
 * Nom de la classe : ActionResultat
 * Produit : Rondo
 * Module : Framework
 * Auteurs : GlobalSaaS
 * CCopyright (c) 2020 Globalsaas
 * 1e version : 31 décembre 2019
 *------------------------------------------------------------------------------
 * Description :
 * Resultat d'une action effectuee par une webapp lorsqu'un retour est attendu.
 * 
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */

 package com.globalsaas.rondo.model.framework;

import java.util.List;

import com.globalsaas.rondo.model.service.ServiceObject;

import lombok.Data;

@Data
public class ActionResultat {
    public static final int NA = -1;
    public static final int OK = 0;
    public static final int ERREUR_LOGIN = 1;
    public static final int ERREUR_COMPTE = 2;
    public static final int ERREUR_FORMAT = 3;
    public static final int ERREUR_OBJET_SOURCE = 4;
    public static final int ERREUR_SERVEUR = 20;

    private String refWebApp;
    private String refAction;
    private String refCallback;
    private int codeResultWs;
    private String msgResultWs;
    private ServiceObject objResultWs; // Pour un retour d'un objet simple
    private List<ServiceObject> listResultWs; // Pour un retour d'une liste d'objets
    private String urlViewResultWs; // URL à afficher dans le navigateur par l'utilisateur
    private String blobResultWsBase64; // Données binaires a telecharger
    private String urlDownloadResultWs; // Lien de telechargement

}
