/*------------------------------------------------------------------------------
 * Nom de la classe : TransfertStock
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Objet representant un envoi (transfert entre entrepots, vers ou depuis un
 * employe ou un client...)
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.cloud.firestore.annotation.Exclude;

import lombok.Data;

@JsonTypeName("TransfertStock")
@Data
public class TransfertStock extends ServiceObject implements ServiceChild {
    private static final long serialVersionUID = 5241137905011108758L;
    //@JsonTypeId
    private String typeObjet = ObjectType.TRANSFERT_STOCK.name;

    private String idParent; // identifiant de l'emetteur. -1 si en dehors du reseau (ex. livraison fournisseur)
    private String typeParent; // Type de stockage d'origine (client, entrepot, employe)
    private String nomSource; // Nom du stockage d'origine
    private long idDest; // Identifiant de l'espace de stockage destination
    private String typeDest; // Type de stockage de destination (client, entrepot, employe)
    private String nomDest; // Libelle de l'emplacement du destinataire
    
    private boolean demandeAnnulee; // Flag pour une demande annulee
    private boolean demandeConfirmee; // Flag pour une demande d'envoi confirmee
    
    private Long dateEnvoi; // Timestamp a laquelle le transfert a ete envoye
    private boolean departConfirme; // Flag pour valider le depart
    private boolean departAnnule; // Flag pour indiquer un depart annule
    
    private Long dateReception; // Timestamp a laquelle le transfert a ete recu
    private boolean receptionConfirmee; // Flag pour indiquer que le transfert a ete recu
    private String commentaires; // Commentaires libres sur le transfert
    
    private String idTransporteur; // Identifiant de l'objet Transporteur
    private String nomTransporteur; // Nom du transporteur
    
    // Informations concernant les coordonnees de destination
    private boolean livraisonPointRelais;
    private String refPointRelaisLivraison; 
    private String refLivraison;
    private String nomLivraison;
    private String adresseLivraison;
    private String detailsLivraison;
    private String cpLivraison;
    private String villeLivraison;
    private String telLivraison;
    private String emailLivraison;
    
    // Informations concernant les coordonnees d'origine
    private boolean collectPointRelais;
    private String refPointRelaisCollecte;
    private String nomOrigine;
    private String adresseOrigine;
    private String detailsOrigine;
    private String cpOrigine;
    private String villeOrigine;
    private String telOrigine;
    private String emailOrigine;
    
    private String libelle; // Texte libre, nom du transfert
    private String contenu; // Libelle representant les stocks presents au moment de l'envoi

    @Exclude
    public String getEtat() {
        String sEtat = "Cr\u00e9\u00e9e";
        if (demandeAnnulee) {
            return "Demande annul\u00e9e";
        }
        if (departAnnule) {
            return "D\u00e9part annul\u00e9";
        }
        if (demandeConfirmee){
            sEtat = "A envoyer";
        }
        if (departConfirme) {
            sEtat = "Envoy\u00e9";
        }
        if (receptionConfirmee) {
            sEtat = "Re\u00e7u";
        }
        
        return sEtat;
    }

    /*@Override
    public String toString() {
        if (typeParent == ObjectType.FOURNISSEUR.typeId) {
            if (typeDest == ObjectType.ENTREPOT.typeId) {
                return "Commande fournisseur";
            }
            else if (typeDest == ObjectType.EMPLOYE.typeId) {
                return "Commande technicien";
            }
            else if (typeDest == ObjectType.CLIENT.typeId) {
                return "Commande client";
            }
        }
        else if (typeParent == ObjectType.ENTREPOT.typeId) {
            if (typeDest == ObjectType.FOURNISSEUR.typeId) {
                return "Retour fournisseur";
            }
            else if (typeDest == ObjectType.EMPLOYE.typeId) {
                return "Envoi pi\u00e8ces technicien";
            }
            else if (typeDest == ObjectType.ENTREPOT.typeId) {
                return "Transfert entre entrep\u00f4ts";
            }
            else if (typeDest == ObjectType.CLIENT.typeId) {
                return "Envoi pi\u00e8ces client";
            }
        }
        else if (typeParent == ObjectType.EMPLOYE.typeId) {
            if (typeDest == ObjectType.FOURNISSEUR.typeId) {
                return "Retour fournisseur tech";
            }
            else if (typeDest == ObjectType.EMPLOYE.typeId) {
                return "Transfert entre techniciens";
            }
            else if (typeDest == ObjectType.ENTREPOT.typeId) {
                return "Retour pi\u00e8ces technicien";
            }
            else if (typeDest == ObjectType.CLIENT.typeId) {
                return "Envoi pi\u00e8ces client";
            }
        }
        return TypesUtil.getTypeLabel(typeParent)+" -> "+TypesUtil.getTypeLabel(typeDest);
    }*/
}
