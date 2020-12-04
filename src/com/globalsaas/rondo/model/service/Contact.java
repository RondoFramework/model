/*------------------------------------------------------------------------------
 * Nom de la classe : Contact
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Informations pour identifier un contact, qu'on attache a un client, une 
 * domaine, une agence, etc.
 * Un contact a un type, ce qui permet de l'utiliser dans certaines fonctions
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.cloud.firestore.annotation.Exclude;

import lombok.Data;

@JsonTypeName("Contact")
@Data
public class Contact extends ServiceObject implements ServiceChild, MetadataContainer {
    private static final long serialVersionUID = 8126069696290083435L;
    //@JsonTypeId
    private String typeObjet = ObjectType.CONTACT.name;
    
    public static final int TYPE_CONTACT = 0;
    public static final int TYPE_FACTURATION = 1;
    public static final int TYPE_LIVRAISON = 2;
    public static final int TYPE_INTERVENTION = 3;
    public static final int TYPE_EXPEDITEUR = 4;
    public static final int TYPE_DESTINATION = 5;
    public static final int TYPE_MANDAT = 6;
    public static final int TYPE_COMPTABILITE = 7;

    public static final int TYPE_AUTRE = 8;    
    
    private int type; // Type d'adresse. Voir variables TYPE_XXX
    
    private String remarques; // Texte libre pour commentaires
    private String idParent; // Identifiant de la source (agence, client, domaine, etc.)
    private String typeParent; // Type de la source
    
    // Champs adresse
    private String adresse; // Adresse du contact
    private String complement; // Complement d'adresse
    private String etage;
    private String codeResidence;
    private String codePorte;
    private String batiment;
    private String porte;
    
    private String adresseLocalisee; // Adresse retournee par le geocodage
    private double qualiteGeoloc; // Indice de qualite du geocodage
    private double easting; // Coordonnees de l'adresse apres geocodage
    private double northing; // Coordonnees de l'adresse apres geocodage
    private String cedex; // Pour une adresse avec CEDEX
    private String codePays; // Code ISO du pays (FR, DE, ...)
    private String codePostal; // Code postal
    private String codeProvince; // Pour certains pays, le code province
    private String ville; // Ville du contact
    
    // Coordonnees
    private String dateNaissance; // Date de naissance du contact (format ISO)
    private String civilite; // M. ou Mme, ou SA, SARL, etc. pour des societes
    private String nom; // Nom de la personne
    private String prenom; // Prenom du contact
    private String urlPhoto; // Pour une photo, adresse
    private String pseudonyme; // Pseudo pour le reseaux sociaux

    private String tel1; // Telephone principal
    private String tel2; // Telephone secondaire
    private String telPro; // Numero pro
    private String telMobile; // Numero de telephone mobile
    private String email; // Adresse email
    private String fax; // Numero de fax

    private List<Metadata> metadatas;

    @Override
    public String toString(){
        String sCivilite = getCivilite();
        return ((sCivilite != null && sCivilite.trim().length() > 0)?sCivilite+" ":"")+((prenom != null && prenom.trim().length() > 0)?prenom+" ":"")+nom;
    }
    
    @Exclude
    public String getLibelleType() {
        if (type == TYPE_AUTRE) {
            return "Autre";
        }
        else if (type == TYPE_CONTACT) {
            return "Contact";
        }
        else if (type == TYPE_DESTINATION) {
            return "Destination";
        }
        else if (type == TYPE_EXPEDITEUR) {
            return "Exp\u00e9diteur";
        }
        else if (type == TYPE_FACTURATION) {
            return "Facturation";
        }
        else if (type == TYPE_INTERVENTION) {
            return "Intervention";
        }
        else if (type == TYPE_LIVRAISON) {
            return "Livraison";
        }
        else {
            return "";
        }
    }
    
    @Exclude
    public String getCodesAdresse() {
        StringBuilder builder = new StringBuilder();
        boolean previous = false;
        if (batiment != null && batiment.length() > 0) {
            builder.append("BAT : ").append(batiment);
            previous = true;
        }
        if (etage != null && etage.length() > 0) {
            if (previous) {
                builder.append(" ");
            }
            builder.append("ET. : ").append(etage);
            previous = true;
        }
        if (porte != null && porte.length() > 0) {
            if (previous) {
                builder.append(" ");
            }
            builder.append("PO. : ").append(porte);
            previous = true;
        }
        if (codePorte != null && codePorte.length() > 0) {
            if (previous) {
                builder.append(" ");
            }
            builder.append("CODE PO. : ").append(codePorte);
            previous = true;
        }
        if (codeResidence != null && codeResidence.length() > 0) {
            if (previous) {
                builder.append(" ");
            }
            builder.append("CODE RES. : ").append(codeResidence);
        }
        return builder.toString();
    }
    
    @Exclude
    public String getAdresse(boolean isVille, boolean isComplement, boolean isMultiligne) {
        StringBuilder builder = new StringBuilder();
        String sep = " ";
        if (isMultiligne) {
            sep = System.getProperty("line.separator");
        }
        if (adresse != null) {
            builder.append(adresse);
        }
        if (isVille) {
            builder.append(sep);
            builder.append(codePostal).append(" ").append(ville);
            if (cedex != null && cedex.length() > 0) {
                builder.append(" CEDEX ").append(cedex);
            }
        }
        if (isComplement) {
            if (complement != null && complement.length() > 0) {
                builder.append(sep).append(complement);
            }
            if ((batiment != null && batiment.length() > 0) ||
                    (etage != null && etage.length() > 0) ||
                    (porte != null && porte.length() > 0) ||
                    (codePorte != null && codePorte.length() > 0) ||
                    (codeResidence != null && codeResidence.length() > 0)) {
                builder.append(sep);
                builder.append(getCodesAdresse());
            }
        }
        return builder.toString();
    }

    @Exclude
    public String toStringPersonneAdresse() {
        return toString() + ", " + getAdresse(true, false, false);
    }


    public static class Functions {

        private Functions() {
        }

        public static String getDefaultTel(Contact contact) {

            if(!isNullOrEmpty(contact.getTelMobile())) {
                return contact.getTelMobile();
            }
            if(!isNullOrEmpty(contact.getTelPro())) {
                return contact.getTelPro();
            }
            if(!isNullOrEmpty(contact.getTel1())) {
                return contact.getTel1();
            }
            if(!isNullOrEmpty(contact.getTel2())) {
                return contact.getTel2();
            }
            return "0";
        }
        
        private static boolean isNullOrEmpty(String value) {
            if (value == null) {
                return true;
            }
            if (value.trim().isEmpty()) {
                return true;
            }
            return false;
        }


    }
    
    @Exclude
    public String getStringTel() {
        StringBuilder builder = new StringBuilder();
        // Ligne 1 : tel1/tel2
        if ((tel1 != null && !tel1.isEmpty()) || (tel2 != null && !tel2.isEmpty())) {
            builder.append("Tel : ");
            boolean first = true;
            if (tel1 != null && !tel1.isEmpty()) {
                builder.append(tel1);
                first = false;
            }
            if (tel2 != null && !tel2.isEmpty()) {
                if (!first) {
                    builder.append(" / ");
                }
                builder.append(tel2);
            }
        }
        // Ligne 2 : Pro/Mobile
        if ((telMobile != null && !telMobile.isEmpty()) || (telPro != null && !telPro.isEmpty())) {
            builder.append("Mobile / Pro : ");
            boolean first = true;
            if (telMobile != null && !telMobile.isEmpty()) {
                builder.append(telMobile);
                first = false;
            }
            if (telPro != null && !telPro.isEmpty()) {
                if (!first) {
                    builder.append(" / ");
                }
                builder.append(telPro);
            }
        }
        if (fax != null && !fax.isEmpty()) {
            builder.append("Fax : ");
            builder.append(fax);
        }
        if (email != null && !email.isEmpty()) {
            builder.append("E-mail : ");
            builder.append(email);
        }
        
        return builder.toString();
    }

}
