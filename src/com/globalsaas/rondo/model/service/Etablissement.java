/*------------------------------------------------------------------------------
 * Nom de la classe : Etablissement
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Represente une entite juridique, pour faire de la gestion commerciale
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

@JsonTypeName("Etablissement")
@Data
public class Etablissement extends ServiceObject implements MetadataContainer, DelegationContainer {
    private static final long serialVersionUID = 6807700099026468010L;
    //@JsonTypeId
    private String typeObjet = ObjectType.ETABLISSEMENT.name;
   
    private String nom; // Nom de l'etablissement
    private String idSociete; // Societe a laquelle est rattache l'etablissement
    private String siteWeb;
    private String emailOwner; // Employe responsable de l'etablissement
    private String siret; // Numero de SIRET de l'etablissement
    private String rcs; // Numero de SIREN
    private String lieuRcs; // Lieu d'enregistrement du RCS
    private String codeAPE; // Code APE de l'entreprise
    private String typeSociete; // SA, SARL, etc.
    private String capital; // Capital en toute lettres
    private String codeTva; // Numero de TVA intracommunautaire
    private String agrement; // Pour certaines activites reglementees, numero d'agrement a presenter
    private String dateAgrement; // Date d'obtention de l'agrement // Format ISO
    private int currentYear; // Annee courante de facturation
    private int currentMonth; // Mois courant de facturation
    private long compteurFacture; // Compteur de facture, pour une numerotation continue
    private long compteurDevis; // Compteur de devis, pour une numerotation continue
    private long compteurAvoir; // Peut etre utilise pour les avoirs
    private String patternNumeroFacture; // Pattern utilise pour generer le numero de facture
    private String patternNumeroDevis; // Pattern utilise pour generer le numero de devis
    private String patternNumeroAvoir; // Pattern utilise pour generer le numero d'avoir
    private boolean remiseAZero; // Effectuer une remise a zero des compteurs au changement de mois ou annee de facturation
    
    private List<Metadata> metadatas;
    private List<Delegation> delegations;

    @Override
    public String toString() {
        return nom;
    }

    @Exclude
    public void increaseMonth() {
        setCurrentMonth(currentMonth + 1);
        if (currentMonth > 12) {
            setCurrentMonth(1);
            setCurrentYear(currentYear + 1);
        }
    }
}
