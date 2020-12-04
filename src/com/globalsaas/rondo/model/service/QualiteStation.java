/*------------------------------------------------------------------------------
 * Nom de la classe : QualiteStation
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 01 juin 2017
 *------------------------------------------------------------------------------
 * Description :
 * Resultat d'une evaluation d'une station pour une requete de station
 * competence.
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("QualiteStation")
@Data
public class QualiteStation extends ServiceObject {
    private static final long serialVersionUID = 2823535346875398714L;
    //@JsonTypeId
    private String typeObjet = ObjectType.QUALITE_STATION.name;
    
    // Elements de requete
    private String idAgence; // Agence qui represente la station
    private String dateMin; // Date min de recherche de disponibilite, format ISO
    private String dateMax; // Date max de recherche de disponibilite, format ISO
    private String idGroupe; // Id du groupe pour la recherche de competence
    private String idClasse; // Id de classe de produit pour la recherche
    private String idFournisseur; // Pour une recherche d'agrement, Id du fournisseur

    // Qualite objective, valeurs recuperes par calcul des dossiers en BDD
    private int nbDossiersAtelier;
    private int nbDossiersIad;
    private double delaiPremierPassageIad;
    private double nbPassageMoyIad;
    private double delaiReparationAtelier;
    private double delaiReparationIad;
    private double montantMoyDevisIad;
    private double montantMoyDevisAtelier;
    
    // Qualite subjective
    private double noteMoyPortail; // Valeurs moyennes sur etoilage par les particuliers
    private int nbNotesPortail; // Nb de notes par etoilage par les particuliers
    private double noteMoyDomain; // Valeurs moyennes sur etoilage par les gestionnaires du domaine
    private int nbNotesDomain; // Nb de notes par etoilage par les gestionnaires du domaine
}
