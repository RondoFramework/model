/*------------------------------------------------------------------------------
 * Nom de la classe : Equipement
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Identifiant d'un equipement, avec emplacement et elements permettant sa 
 * gestion.
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("Equipement")
@Data
public class Equipement extends ServiceObject implements MetadataContainer {
    private static final long serialVersionUID = 6824811017774666640L;
    //@JsonTypeId
    private String typeObjet = ObjectType.EQUIPEMENT.name;

    private String idClient; // Client auquel est lie l'equipement
    
    private int etat; // Voir EtatEquipement

    private String marque; // Marque de l'appareil
    private String modele; // Reference commerciale de l'appareil
    private String modeleTech; // Reference commerciale, relevee par le technicien
    private String version; // Version du modele, pour referencement
    private String versionTech; // Version du modele, relevee par le technicien
    private String designation; // Designation de l'appareil
    private String numeroSerie; // Numero de serie de l'appareil
    private String numeroSerieTech; // Numero de serie, releve par le tech
    private String codeEAN; // Code EAN
    private String numeroImei; // Numero IMEI, pour un telephone
    
    private String idStock; // Stock sur lequel est positionne l'equipement
    private String typeStock; // Type de stock : entrepot, employe, client
    private String nomStock; // Nom du stock
    private String emplacementStock; // Pour un stockage dans un entrepot avec emplacements, l'emplacement de l'appareil
    
    private String dateAchat; // Date d'achat // Format ISO
    private double prixAchat; // Prix TTC d'achat
    private String dateMES; // Date de mise en service // Format ISO
    private String nomLieuAchat; // Lieu de l'achat, en toutes lettres
    private String adresseLieuAchat; // Adresse du magasin d'achat, en toutes lettres
    private String numeroFactureHA; // Numero de la facture d'achat du produit
    private String idGarantie; // vers type garantie
    private String idProduit; // On peut avoir le lien vers un produit du catalogue
    private String idClasse; // Lien vers la classe de l'appareil
    private String idContrat; // Lien vers un contrat de maintenance
    private String remarques; // Texte libre pour commentaires
    private String idFournisseur; // Identifiant du fournisseur, pour des conditions de prise en charge particulieres
    private String idGamme; // Gamme de l'equipement
    private String idAgenceAchat; // Identifiant d'une agence d'achat, pour de la gestion de conditions de garantie

    private boolean appareilDePret; // Cet appareil est un equipement de pret
    private String idEntrepotPret; // Entrepot principal de rattachement pour un appareil de pret

    private String libelleGarantie; // Libelle de la garantie

    private List<Metadata> metadatas;

    @Override
    public String toString() {
        if (modele == null || modele.equals("")) {
            return "N\u00B0 " + getId();
        } else if (marque == null || marque.equals("")) {
            return modele;
        }
        return modele + " (" + marque + ")";
    }

    @Override
    public boolean equals(Object toCompare) {
        Equipement other = null;
        try {
            other = (Equipement) toCompare;
        } catch (Exception e) {
            return false;
        }
        if (other == null) {
            return false;
        }
        if (Objects.equals(other.getId(), getId())) {
            return true;
        }
        if (numeroSerie != null && other.getNumeroSerie() != null && !other.getNumeroSerie().trim().isEmpty() && numeroSerie.trim().equals(other.getNumeroSerie().trim())) {
            return true;
        }
        if (numeroImei != null && other.getNumeroImei() != null && numeroImei.length() >= 15 && numeroImei.equals(other.getNumeroImei())) {
            return true;
        }
        return false;
    }
}
