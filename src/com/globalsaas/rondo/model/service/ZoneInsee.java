/*------------------------------------------------------------------------------
 * Nom de la classe : ZoneInsee
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 01 juin 2017
 *------------------------------------------------------------------------------
 * Description :
 * Description d'un code INSEE associe a une ZoneCompetence. Permet de definir
 * un composant d'une zone de competence, a partir d'une zone INSEE (region,
 * departement, arrondissement, canton ou commune)
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("ZoneInsee")
@Data
public class ZoneInsee extends ServiceObject implements ServiceChild {
    private static final long serialVersionUID = -7225591821869751371L;
    //@JsonTypeId
    private String typeObjet = ObjectType.ZONE_INSEE.name;
    
    public static final int TYPE_REGION = 1;
    public static final int TYPE_DEPARTEMENT = 2;
    public static final int TYPE_ARRONDISSSEMENT = 3;
    public static final int TYPE_CANTON = 4;
    public static final int TYPE_COMMUNE = 5;
    
    public static final String[] TYPE_STR ={"Tous","Région","Département","Arrondissement","Canton","Commune"};
    
    
    private String idParent; // Identifiant de la source 
    private String typeParent; // Type de source (ZoneCompetence, ...)
    private int type; // Type de zone - voir TYPE_XXX
    // Valeurs recuperees depuis les objets InseeCommune, InseeCanton, InseeArrondissement, InseeDepartement ou InseeRegion :
    private String nomZone; // Nom de la zone
    private String codeZone; // Code de la zone (Code region a code postal)
    private String codeRegion; // Pour tous les types de zones
    private String codeDepartement; // Pour une zone plus petite qu'une region
    private String codeArrondissement; // Pour une zone plus petite qu'un departement
    private String codeCanton; // Pour un canton ou une commune
    private String codeCommune; // Pour une commune
    private String codeIris; // Pour un code IRIS
    
    @Override
    public String toString(){
        return codeZone+" - "+nomZone;
    }
}
