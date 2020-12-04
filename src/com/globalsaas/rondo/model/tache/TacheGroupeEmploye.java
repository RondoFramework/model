/*------------------------------------------------------------------------------
 * Nom de la classe : TacheGroupeEmploye
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Lien entre un employe et un groupe de gestion de taches 
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.tache;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.globalsaas.rondo.model.service.ObjectType;
import com.globalsaas.rondo.model.service.ServiceObject;

import lombok.Data;

@JsonTypeName("TacheGroupeEmploye")
@Data
public class TacheGroupeEmploye extends ServiceObject {
    private static final long serialVersionUID = 5752107233831055163L;
    //@JsonTypeId
    private String typeObjet = ObjectType.TACHE_GROUPE_EMPLOYE.name;

    private String    idGroupe; // Identifiant du groupe
    private String    idEmploye; // Identifiant de l'employe qui est dans le groupe
    private String  nomEmploye; // Nom de l'employe
    private String  prenomEmploye; // Prenom de l'employe
    private boolean isAdmin; // L'employe est administrateur du groupe

    @Override
    public int compareTo(Object tt) {
        TacheGroupeEmploye t = (TacheGroupeEmploye)tt;
        String first  =   getNomEmploye().toUpperCase()+ " " +   getPrenomEmploye();
        String second = t.getNomEmploye().toUpperCase()+ " " + t.getPrenomEmploye();
        return first.compareTo(second);
    }

    @Override
    public String toString() {
        return "TacheGroupeEmploye{" + "id=" + getId() + ", idGroupe=" + idGroupe + ", idEmploye=" + idEmploye + ", nomEmploye=" + nomEmploye + ", prenomEmploye=" + prenomEmploye + ", isAdmin=" + isAdmin + '}';
    }
}
