package com.globalsaas.rondo.model.framework;

import lombok.Data;

@Data
public class RequeteDef {
    private String reference; // Reference unique de la requete
    private String designation; // Designation, texte libre pour designer la requete
    private String description; // Texte libre pour decrire la requete
    private String webAppRef; // Reference de la webapp
    private String typeDataIn; // Pour requetes autre que get, format de l'objet en entree (voir ObjectType pour les valeurs)
    private String typeDataOut; // Valeur de l'objet retourne (voir ObjectType pour les valeurs). Pour un formatRetour : JSON
    private String defParam1;
    private String defParam2;
    private String defParam3;
    private String defParam4;
    private String defParam5;
    private String classeParam1;
    private String classeParam2;
    private String classeParam3;
    private String classeParam4;
    private String classeParam5;

}
