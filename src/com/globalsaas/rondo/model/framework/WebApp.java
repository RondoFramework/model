package com.globalsaas.rondo.model.framework;

import java.util.List;

import lombok.Data;

@Data
public class WebApp extends RondoPersistObject {
    private String url;// Base de l'URL, pour contact
    private String webhookUrl; // URL d'envoi du retour de l'application
    private String name; // Nom de la webapp, designation en texte libre
    private String version;
    private String dateVersion;
    private String author;
    private String website;
    private String details;
    private String urlIcon;
    private String publicKey; // Cle publique de l'application, pour chiffrer un envoi sur une URL de webhook
    private List<ActionDef> actions;
    private List<AppMenu> menus;
    private List<RequeteDef> requests;
    private List<Permission> permissions;

    public final static String APP_DIRECTOR = "director"; // RONDO Director, application d'administration des flux
    public final static String APP_CATALOG = "catalog"; // Gestion du catalogue de produits et articles a traiter et facturer
    public final static String APP_CUSTOMER = "customer"; // Gestion de la bdd clients
    public final static String APP_NETWORK = "network"; // Gestion des domaines, du reseau et des employes
    public final static String APP_PLANNING = "planning"; // Gestion de la planification
    public final static String APP_CALENDAR = "calendar"; // Application de calendrier
    public final static String APP_REPORTING = "reporting"; // Application de gestion des reporting, et compilation de documents Jasper
    public final static String APP_STOCK = "stock"; // Gestion des stocks
    public final static String APP_MOBILE = "mobile"; // Gestion des acces mobiles
    public final static String APP_FILES = "files"; // Gestionnaire des fichiers
    public final static String APP_COMMUNICATION = "communication"; // Gestion de la communication mail / SMS
    public final static String APP_FINANCE = "finance"; // Application de gestion financiere
    public final static String APP_INVOICE = "invoice"; // Application de gestion et suivi de la facturation
}
