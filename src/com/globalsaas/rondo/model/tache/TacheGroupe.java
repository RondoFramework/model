/*------------------------------------------------------------------------------
 * Nom de la classe : TacheGroupe
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Groupe cible pour une tache
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

@JsonTypeName("TacheGroupe")
@Data
public class TacheGroupe extends ServiceObject {
    private static final long serialVersionUID = -9043013395630078859L;
    //@JsonTypeId
    private String typeObjet = ObjectType.TACHE_GROUPE.name;
    
    private String libelle; // Nom du groupe
    private boolean typePlanif; // Indique s'il fait de la planification
    private boolean typeSupport; // Indique s'il fait du support
    private boolean typeFinance; // Indique s'il fait de la finance
    private boolean typeAdmin; // Indique s'il fait de l'administration d'affaires
    private boolean typePieces; // Indique s'il s'occupe de pieces

    @Override
    public int compareTo(Object t) {
        if (t == null || !(t instanceof TacheGroupe)) {
            return 0;
        }
        TacheGroupe tg = (TacheGroupe)t;
        return libelle.compareTo(tg.getLibelle());
    }

    @Override
    public String toString() {
        return "TacheGroupe{" + "id=" + getId() + ", domain=" + getDomain() + ", libelle=" + libelle + ", typePlanif=" + typePlanif + ", typeSupport=" + typeSupport + ", typeFinance=" + typeFinance + ", typeAdmin=" + typeAdmin + ", typePieces=" + typePieces + '}';
    }
}
