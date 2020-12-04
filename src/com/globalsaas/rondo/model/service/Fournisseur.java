/*------------------------------------------------------------------------------
 * Nom de la classe : Fournisseur
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Objet representant un fournisseur de pieces detachees, ou de materiel
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeName("Fournisseur")
@Data
@NoArgsConstructor
public class Fournisseur extends ServiceObject {
    private static final long serialVersionUID = -5259043477836810264L;
    //@JsonTypeId
    private String typeObjet = ObjectType.FOURNISSEUR.name;
    
    private String nom; // Nom du fournisseur
    private String domainFournisseur; // domaine qui represente ce fournisseur
    private String ownerEmail; // Identifiant du responsable du fournisseur
    private List<Metadata> metadatas;

    @Override
    public String toString() {
        return nom;
    }


}


