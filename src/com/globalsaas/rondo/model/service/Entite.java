/*------------------------------------------------------------------------------
 * Nom de la classe : Societe
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Represente un groupement d'employes et d'agences
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

@JsonTypeName("Entite")
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Entite extends ServiceObject implements MetadataContainer, DelegationContainer {
    private static final long serialVersionUID = -8618587072460554966L;
    //@JsonTypeId
    //@JsonProperty("typeObjet")
    private String typeObjet = ObjectType.ENTITE.name;

    private String nom; // Nom de la societe
    private String ownerEmail; // Identifiant du responsable de la societe
    private String remarques; // Texte libre de remarques et commentaires sur la societe
    private String type; // Type de societe. Les types sont representes par l'objet TypeSociete
    private List<Delegation> delegations;
    private List<Metadata> metadatas;

    @Override
    public String toString(){
        return nom;
    }
    
    @Override
    public int compareTo(Object o) {
        if(o == null || !(o instanceof Entite))
            throw new ClassCastException();
        return this.getNom().compareTo(((Entite)o).getNom());
    }  
}
