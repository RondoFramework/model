/*------------------------------------------------------------------------------
 * Nom de la classe : Tache
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Une tache represente un travail a effectuer par un agent utilisateur de 
 * l'application. Elle n'est pas liee au contexte des affaires.
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.tache;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.globalsaas.rondo.model.service.ObjectType;
import com.globalsaas.rondo.model.service.ServiceObject;

import lombok.Data;

@JsonTypeName("Tache")
@Data
public class Tache extends ServiceObject {
    private static final long serialVersionUID = -3956757252718199005L;
    //@JsonTypeId
    private String typeObjet = ObjectType.TACHE.name;

    private String idAffaire; // Une tache peut etre liee a une affaire
    private String  titre; // Texte libre, pour les affichages des listes de taches
    private String  contenu; // Texte representant le contenu de la tache
    private String  groupeLibelle; // Libelle du groupe auquel la tache est assignee
    private String  etatLibelle; // Libelle de l'etat de la tache
    private String  tacheTypeLibelle; // Libelle du type de tache
    private String    groupeId; // Identifiant du groupe auquel est assignee la tache
    private String    etatId; // Identifiant de l'etat de la tache
    private String    tacheTypeId; // identifiant du type de tache
    private String    prioriteId; // Identifiant de la priorite de la tache
    private String    createurId; // Identifiant de l'employe createur de la tache
    private String    lastModifEmpId; // Identifiant de l'employe ayant modifie en dernier la tache
    private Long    dateExecution; // Horodatage de l'execution de la tache
    private Long    dateLastModif; // Horodatage de la derniere modification de la tache
    
    private ArrayList<String> listTacheGroupeEmployeId = new ArrayList<String>(); // destinataires passes sous forme de string dans le M001

    @Override
    public int compareTo(Object m2) {
        if (m2 == null || !(m2 instanceof Tache)) {
            return 0;
        }
        Tache t = (Tache) m2;
        if (dateExecution != t.getDateExecution()) {
            return (int)(dateExecution - t.getDateExecution());
        }
        return (int)(getDateCreation() - t.getDateCreation());
    }

    @Override
    public String toString() {
        return "Tache{" + "id=" + getId() + ", idAffaire=" + idAffaire + ", titre=" + titre + ", contenu=" + contenu + ", groupeLibelle=" + groupeLibelle + ", etatLibelle=" + etatLibelle + ", tacheTypeLibelle=" + tacheTypeLibelle + ", groupeId=" + groupeId + ", etatId=" + etatId + ", tacheTypeId=" + tacheTypeId + ", prioriteId=" + prioriteId + ", createurId=" + createurId + ", lastModifEmpId=" + lastModifEmpId + ", dateExecution=" + dateExecution + ", dateCreation=" + getDateCreation() + ", dateLastModif=" + dateLastModif + ", listTacheGroupeEmployeId=" + listTacheGroupeEmployeId + '}';
    }

}