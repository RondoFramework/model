/*------------------------------------------------------------------------------
 * Nom de la classe : Communication
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Communication de la part d'un client. Peut etre de differents types, et 
 * rattachee a une affaire. 
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.cloud.firestore.annotation.Exclude;

import lombok.Data;

@JsonTypeName("Communication")
@Data
public class Communication extends ServiceObject implements ServiceAffaireObject, DelegationContainer, MetadataContainer {
    private static final long serialVersionUID = -3634009109506398496L;
    //@JsonTypeId
    private String typeObjet = ObjectType.COMMUNICATION.name;

    public static final int TYPE_TELEPHONE = 0;
    public static final int TYPE_COURRIER = 1;
    public static final int TYPE_MAIL = 2;
    public static final int TYPE_FAX = 3;
    public static final int TYPE_SMS = 4;
    public static final int TYPE_MESSAGERIE = 5;
    public static final int TYPE_FACEBOOK = 6;
    public static final int TYPE_TWITTER = 7;
    public static final int TYPE_AUTRE = 8;
    
    private String idEmploye; // Identifiant de l'employe qui a enregistre cette communication
    private Long date; // Date et heure de la communication
    private String idClient; // Identifiant du client final avec qui la communication a eu lieu
    private String contenu; // Details de la communication
    private int motif; // Id du MotifCommunication, permet de definir le motif de communication
    
    private String nomContact; // Nom de la personne qui a contacte / ete contactee
    private String prenomContact; // Prenom de la personne qui a contacte / ete contactee
    private String coordContact; // Contact (num de tel, adresse mail...) de la personne qui a contacte / ete contactee
    
    private String coordEmploye; // Contact (num de tel, adresse mail...) de la personne qui a ete en communication avec le client
    private String nomEmploye; // User ou nom de la personne qui a ete en communication avec le client
    
    private boolean entrant; // flag precisant si la communication a ete initiee par un employe et non par le client
    private String idAffaire; // Identifiant de l'affaire a laquelle la communication est rattachee
    private int duree; // Duree de la communication (pour un appel)
    private int resultat; // Id du resultat obtenu a l'issue de cette communication

    private int typeCom; // Type de communication : appel, sms, e-mail...
    private String modeleCom; // Reference du modele de communication
    private String smsTicketId; // Pour un calcul de consommation SMS, ID du ticket

    private List<Metadata> metadatas;
    private List<Delegation> delegations;
    
    @Exclude
    public static final ArrayList<String> getStringModes() {
        ArrayList<String> result = new ArrayList<String>();
        result.add("Appel t\u00e9l\u00e9phonique");
        result.add("Courrier");
        result.add("e-mail");
        result.add("Fax");
        result.add("SMS");
        result.add("Messagerie instantan\u00e9e");
        result.add("Facebook");
        result.add("Twitter");
        result.add("Autre");
        return result;
    }
    
    @Exclude
    public static final ArrayList<String> getStringMotifs() {
        ArrayList<String> result = new ArrayList<String>();
        result.add("Demande d'information");
        result.add("Nouvelle intervention");
        result.add("Dossier en cours");
        result.add("Planification d'intervention");
        result.add("Annulation d'intervention");
        result.add("Nouvelle mission");
        result.add("Appel pr\u00e9alable");
        return result;
    }
    
    @Exclude
    public static final ArrayList<String> getStringResultats() {
        ArrayList<String> result = new ArrayList<String>();
        result.add("Prise de message");
        result.add("Transfert vers un collaborateur");
        result.add("Envoi d'un SMS");
        result.add("Envoi d'un mail");
        result.add("Cr\u00e9ation d'un dossier");
        result.add("RDV confirm\u00e9");
        result.add("Refus client - client absent");
        result.add("Refus client - r\u00e9siliation");
        result.add("Refus client - syndic");
        result.add("Refus client - autorisation propri\u00e9taire");
        result.add("Refus client - trou fa\u00e7ade");
        result.add("Refus client - c\u00e2ble apparent");
        result.add("Refus client - l'installation refonctionne");
        result.add("Refus client - raison commerciale");
        result.add("Faux num\u00e9ro");
        result.add("Pas de r\u00e9ponse");
        result.add("R\u00e9pondeur");
        return result;
    }
    
    @Exclude
    public static final ArrayList<String> getStringOrigines() {
        ArrayList<String> result = new ArrayList<String>();
        result.add("Entrant");
        result.add("Sortant");
        return result;
    }
/*
    public static final ArrayList getStringResultats() {
        ArrayList result = new ArrayList();
        result.add("Message");
        result.add("Transfert");
        result.add("Sms");
        result.add("Mail");
        return result;
    }*/
    
    @Override
    public String toString() {
        String sType = "Autre";
        if (getTypeCom() >= 0 && getTypeCom() < getStringModes().size()) {
            sType = getStringModes().get(getTypeCom());
        }
        if (getDate() <= 0) return sType;
        return sType+" - "+new java.sql.Date(getDate()).toString();
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || !o.getClass().equals(Communication.class)) throw new ClassCastException();
        
        int comparaison;
        comparaison = getTypeCom() - ((Communication)o).getTypeCom();
        if (comparaison != 0) return comparaison;
        
        if (date != null && ((Communication)o).getDate() != null){
            comparaison = date.compareTo(((Communication)o).getDate());
            if (comparaison != 0) return comparaison;
        }
        
        return motif - ((Communication)o).getMotif();
    }
}
