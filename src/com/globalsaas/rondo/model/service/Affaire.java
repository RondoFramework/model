/*------------------------------------------------------------------------------
 * Nom de la classe : Affaire
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 * 2e version : 24 decembre 2019, pour coller au nouveau modele Rondo
 *------------------------------------------------------------------------------
 * Description :
 * Objet metier principal pour une activite de service. Une affaire est un 
 * conteneur dans lequel on retrouvera des prestations et des actes, ainsi
 * que toutes les informations de gestion et administratives.
 * Une affaire est un contrat entre un domaine cliente, un domaine de gestion
 * et un client final.
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

@JsonTypeName("Affaire")
@Data
public class Affaire extends ServiceObject implements MetadataContainer, DelegationContainer {
    private static final long serialVersionUID = 235889451L;
    //@JsonTypeId
    private String typeObjet = ObjectType.AFFAIRE.name;

    private String type; // Type d'affaire, lie a l'objet TypeObjetAffaire
    private String reference;
    private String refDo; // Reference client de l'affaire, telle que communiquee a la creation
    private String idAgenceGestion; // Id de l'agence qui gere l'affaire
    private String domaineGestion;
    private String idClient; // Identifiant du client final
    private String idAdresse; // Identifiant du contact du client final ou se traite l'affaire
    private String idResponsable; // Identifiant de l'employe qui a en charge la gestion de cette affaire
    private String titre; // Libelle de l'affaire, texte libre
    private long dateOuverture; // Date a laquelle on a ouvert l'affaire
    private boolean cloture; // determine si l'affaire est ouverte ou pas
    private long dateCloture; // Date a laquelle l'affaire a ete cloturee
    private boolean comAutoDesactive; // Flag permettant de desactiver les envois de com. du workflow
    private String idEmpCreation; // Identifiant de l'employe qui a cree l'affaire
    private String webhookURL; // Adresse sur laquelle en transmet les evolutions

    private List<Metadata> metadatas;
    private List<Delegation> delegations;

    @Override
    public int compareTo(Object o) {
        if (o == null || !(o instanceof Affaire)) {
            return 0;
        }
        Affaire a = (Affaire)o;
        int result = (int) (dateOuverture - a.getDateOuverture());
        if (result != 0) {
            return result;
        }
        String sId = getId();
        if (sId == null) {
            sId = "";
        }
        return sId.compareTo(a.getId());
    }

}
