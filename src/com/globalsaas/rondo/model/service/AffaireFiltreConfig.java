/*------------------------------------------------------------------------------
 * Nom de la classe : AffaireFiltreConfig
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Objet de configuration, pour communiquer au client l'ensemble des valeurs
 * possible dans les differents champs de filtrage pour les affaires
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonTypeId;

import lombok.Data;

@Data
public class AffaireFiltreConfig extends ServiceObject {
    private static final long serialVersionUID = -2395704898966183587L;
    //@JsonTypeId
    private String typeObjet = ObjectType.NO_TYPE.name;

    private String requeteBase;
    private final ArrayList<SimpleDAOConcept> domains = new ArrayList<SimpleDAOConcept>();
    private final ArrayList<SimpleDAOConcept> sousTraitants = new ArrayList<SimpleDAOConcept>();
    private final ArrayList<SimpleDAOConcept> departements = new ArrayList<SimpleDAOConcept>();
    private final ArrayList<SimpleDAOConcept> typesAffaire = new ArrayList<SimpleDAOConcept>();
    private final ArrayList<SimpleDAOConcept> typesPresta = new ArrayList<SimpleDAOConcept>();
    private final ArrayList<SimpleDAOConcept> statutAffaire = new ArrayList<SimpleDAOConcept>();
    private final ArrayList<SimpleDAOConcept> delaisOuverture = new ArrayList<SimpleDAOConcept>();
    private final ArrayList<SimpleDAOConcept> statutsDevis = new ArrayList<SimpleDAOConcept>();
    private final ArrayList<SimpleDAOConcept> statutsFacturation = new ArrayList<SimpleDAOConcept>();
    private final ArrayList<SimpleDAOConcept> gestionnaires = new ArrayList<SimpleDAOConcept>();
    private final ArrayList<SimpleDAOConcept> priorites = new ArrayList<SimpleDAOConcept>();
    private final ArrayList<SimpleDAOConcept> garantiesReparation = new ArrayList<SimpleDAOConcept>();
    private final ArrayList<SimpleDAOConcept> statutsPresta = new ArrayList<SimpleDAOConcept>();
    private final ArrayList<SimpleDAOConcept> blocages = new ArrayList<SimpleDAOConcept>();
    private final ArrayList<SimpleDAOConcept> statutsPieces = new ArrayList<SimpleDAOConcept>();
    private final ArrayList<SimpleDAOConcept> statutsInter = new ArrayList<SimpleDAOConcept>();
    private final ArrayList<SimpleDAOConcept> codesNok = new ArrayList<SimpleDAOConcept>();

}
