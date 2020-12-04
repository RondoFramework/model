/*------------------------------------------------------------------------------
 * Nom de la classe : ModeleIntervention
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Modele d'intervention pour les actes. Les modeles sont lies a une activite 
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("ModeleIntervention")
@Data
public class ModeleIntervention extends ServiceObject {
    private static final long serialVersionUID = -8869695459952255558L;
    //@JsonTypeId
    private String typeObjet = ObjectType.MODELE_INTERVENTION.name;

    private String idActivite; // Identifiant de l'activite a laquelle est rattachee le modele
    private int temps; // Temps d'intervention par defaut (en minutes)
    private String label; // Label du modele d'intervention
    private float correction; // Configuration d'un ratio pour prise en compte d'un horaire corrige
    private int numeroIcone;

    @Override
    public String toString() {
        return label;
    }
}
