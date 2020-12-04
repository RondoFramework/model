/*------------------------------------------------------------------------------
 * Nom de la classe : Profil
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 16 juin 2017
 *------------------------------------------------------------------------------
 * Description :
 * Le profil portail est calcule a partir de l'identifiant. Il permet de savoir
 * comment exploiter les informations de presentation
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.framework;

import java.util.ArrayList;

import com.globalsaas.rondo.model.service.Agence;
import com.globalsaas.rondo.model.service.Client;
import com.globalsaas.rondo.model.service.Employe;
import com.globalsaas.rondo.model.service.Entite;
import com.globalsaas.rondo.model.service.Fournisseur;
import com.globalsaas.rondo.model.service.SousTraitant;
import com.globalsaas.rondo.model.service.Transporteur;

import lombok.Data;

@Data
public class Profil implements java.io.Serializable {
    public static final int TYPE_TECH = 0; // Technicien, responsable des dossiers qui lui sont assignes
    public static final int TYPE_MAGASIN = 1; // Responsable des dossiers que mon magasin met en ligne
    public static final int TYPE_PLATEFORME = 2; // Responsable de plateforme de gestion
    public static final int TYPE_STATION = 3; // Responsable de station technique.
    public static final int TYPE_CLIENT = 4; // Client final
    public static final int TYPE_DOMAIN = 5; // Responsable des dossiers du domaine 
    public static final int TYPE_MARQUE = 6; // Responsable de la configuration de la marque et des dossiers sous garantie de la marque
    public static final int TYPE_LOGISTIQUE = 7; // Responsable de la logistique d'une station technique
    public static final int TYPE_TRANSPORTEUR = 7; // Responsable du suivi logistique de dossiers
    public static final int TYPE_ADMIN = 8; // Administrateur du systeme
    public static final int TYPE_GESTIONNAIRE = 9; // Gestionnaire de dossiers
    public static final int TYPE_SERVICE = 10; // Compte de service, pour une machine
    
    private int type;
    private String domain;
    private String email;
    private Client client;
    private Employe employe;
    private Agence agence;
    private Entite entite;
    private ArrayList<Fournisseur> marques;
    private SousTraitant sousTraitant;
    private Transporteur transporteur;
    

    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("Type de profil : ");
        if (type == TYPE_ADMIN) builder.append("Administrateur");
        else if (type == TYPE_LOGISTIQUE) builder.append("Logistique");
        else if (type == TYPE_CLIENT) builder.append("Client");
        else if (type == TYPE_DOMAIN) builder.append("Domaine");
        else if (type == TYPE_MAGASIN) builder.append("Magasin");
        else if (type == TYPE_MARQUE) builder.append("Marque");
        else if (type == TYPE_PLATEFORME) builder.append("Plateforme");
        else if (type == TYPE_STATION) builder.append("Station");
        else if (type == TYPE_TECH) builder.append("Technicien");
        else if (type == TYPE_TRANSPORTEUR) builder.append("Transporteur");
        else if (type == TYPE_GESTIONNAIRE) builder.append("Gestionnaire");
        else if (type == TYPE_SERVICE) builder.append("Service");
        if (domain != null) builder.append("\nDomaine : ").append(domain);
        else if (client != null) builder.append("\nClient : ").append(client);
        else if (employe != null) builder.append("\nEmploy\u00E9 : ").append(employe);
        else if (agence != null) builder.append("\nAgence : ").append(agence);
        else if (entite != null) builder.append("\nEntit\u00e9 : ").append(entite);
        else if (marques != null) builder.append("\nMarques : ").append(marques);
        else if (sousTraitant != null) builder.append("\nSous-traitant : ").append(sousTraitant);
        else if (transporteur != null) builder.append("\nTransporteur : ").append(transporteur);
        
        return builder.toString();
    }
}
