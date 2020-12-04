/*------------------------------------------------------------------------------
 * Nom de la classe : Banque
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Description d'un compte bancaire, pour une remise de reglement
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;
import lombok.NoArgsConstructor;
@JsonTypeName("Banque")
@Data
@NoArgsConstructor
public class Banque extends ServiceObject implements ServiceChild {
    private static final long serialVersionUID = 5254064024020315036L;
    //@JsonTypeId
    private String typeObjet = ObjectType.BANQUE.name;
    
    private String numeroCompte; // Numero de compte
    private String etablissement; // Code etablissement du RIB
    private String guichet; // Code guichet du RIB
    private String cleRib; // Cle du RIB
    private String nom; // Nom du compte bancaire
    private String adresse; // Adresse de la banque
    private String cpVille; // CP et ville de la banque
    private String iban1; // Valeurs IBAN du compte
    private String iban2;
    private String iban3;
    private String iban4;
    private String iban5;
    private String iban6;
    private String iban7;
    private String bic; // Valeur BIC du compte
    private String refComptable; // Reference comptable du compte bancaire
    private String journalComptable; // Numero du journal comptable
    private String typeParent; // Type de l'objet auquel est rattache un compte (Etablissement, client)
    private String idParent; // Identifiant de l'objet auquel est rattache un compte

    public Banque(String nom, String cpVille) {
        this.nom = nom;
        this.cpVille = cpVille;
    }

    @Override
    public String toString() {
        return nom + " - " + cpVille;
    }

}
