/*------------------------------------------------------------------------------
 * Nom de la classe : ValidCompetence
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 01 juin 2017
 *------------------------------------------------------------------------------
 * Description :
 * Identification d'un contrat entre un domaine et un sous-traitant. Represente
 * un agrement d'une station par un domaine
 * On a des contacts associes a cet agrement pour gerer la communication
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("ValidCompetence")
@Data
public class ValidCompetence extends ServiceObject implements ServiceChild, MetadataContainer {
    private static final long serialVersionUID = 7999416208624199131L;
    //@JsonTypeId
    private String typeObjet = ObjectType.VALID_COMPETENCE.name;

    public static final int GRADE_NONE = 0;
    public static final int GRADE_IVORY = 1;
    public static final int GRADE_SILVER = 2;
    public static final int GRADE_GOLD = 3;
    public static final int GRADE_ELITE = 4;
    public static final int GRADE_SPECIAL = 5;
    
    private String idAgence; // Identifiant de l'agence qui represente le sous-traitant
    private String idParent; // identifiant du proprietaire qui configure et exploite le contrat
    private String typeParent; // Type de proprietaire de l'agrement (domaine, fournisseur)
    private String dateAgrement; // Date de debut de l'agrement, format ISO
    private String dateFinAgrement; // Date de fin de l'agrement, format ISO
    private String numAgrement; // Numero de contrat d'agrement
    private boolean valide; // Agrement valide, flag permettant de bloquer les mandats
    private String dateValide; // Date a laquelle on a valide l'agrement, format ISO
    private int nbDossiersMoisMax; // Nb de prestations possibles par mois
    
    private int grade; // Voir variables GRADE_XXX
    private String commentaires; // Commentaire libre

    private List<Metadata> metadatas;
}
