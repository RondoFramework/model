/*------------------------------------------------------------------------------
 * Nom de la classe : ActionWorkflow
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Une action de workflow est une description d'une action qui doit etre 
 * effectuee lors d'une programmation du workflow
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.framework;

import lombok.Data;

@Data
public class ActionWorkflow {
    private String refWebApp; // Référence de la webapp de l'action
    private String reference; // Reference de l'action, valeur qui depend de la config de l'application
    private String libelle; // Libelle de l'action, permettant de l'identifier rapidement
    private String param1; // Valeur de parametre qui depend du type (reference) de l'action a realiser
    private String param2; // Valeur de parametre qui depend du type (reference) de l'action a realiser
    private String param3; // Valeur de parametre qui depend du type (reference) de l'action a realiser
    private String param4; // Valeur de parametre qui depend du type (reference) de l'action a realiser
    private String param5; // Valeur de parametre qui depend du type (reference) de l'action a realiser
    
    @Override
    public String toString() {
        return libelle;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof ActionWorkflow)) {
            return false;
        }
        ActionWorkflow a = (ActionWorkflow)o;
        if (reference == null || a.getReference() == null) {
            return false;
        }
        if (reference != null && a.getReference() != null && !reference.equals(a.getReference())) {
            return false;
        }
        if (param1 != null && a.getParam1()!= null && !param1.equals(a.getParam1())) {
            return false;
        }
        if (param2 != null && a.getParam2()!= null && !param2.equals(a.getParam2())) {
            return false;
        }
        if (param3 != null && a.getParam3()!= null && !param3.equals(a.getParam3())) {
            return false;
        }
        if (param4 != null && a.getParam4()!= null && !param4.equals(a.getParam4())) {
            return false;
        }
        return true;
    }
}
