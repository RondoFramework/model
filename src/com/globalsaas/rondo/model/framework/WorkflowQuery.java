package com.globalsaas.rondo.model.framework;

/*------------------------------------------------------------------------------
 * Nom de la classe : WorkflowQuery
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2020 Myfowo
 * 1e version : 13 juillet 2017
 *------------------------------------------------------------------------------
 * Description :
 * Une requete de workflow, lorsqu'elle a ete receptionnee, doit etre traitee.
 * C'est l'objet workflowquery qui permet de stocker la requete, le resultat et
 * le statut de la requete. Une fois traitee, elle pourra etre historisee dans
 * un systeme le logs et supprimee de la file active.
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : Gilles
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
import lombok.Data;

@Data
public class WorkflowQuery {
    public final static String STATUT_INIT = "INIT";
    public final static String STATUT_SENT = "SENT";
    public final static String STATUT_TREATED = "TREATED";
    public final static String STATUT_ERROR = "ERROR";
    public final static String STATUT_NO_CONFIG = "NO_CONFIG";

    private String reference;
    private String statut;
    private String error;
    private String requeteBase64;
    private String resultatBase64;
    private Long requeteStart;
    private Long requeteResult;
}