/*------------------------------------------------------------------------------
 * Nom de la classe : MotifBlocage
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Motif de blocage, pour gerer une sortie du workflow standard
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("MotifBlocage")
@Data
public class MotifBlocage extends ServiceObject {
    private static final long serialVersionUID = 3125262704809338544L;
    //@JsonTypeId
    private String typeObjet = ObjectType.MOTIF_BLOCAGE.name;

    public static final int RESP_CLIENT = 0;
    public static final int RESP_DO = 1;
    public static final int RESP_STATION = 2;
    
    private String domainClient; // Identifiant du domaine des dossiers a laquelle se rettache le motif (Par defaut, 0 s'applique a tous les clients)
    private String codeBlocage; // Code unique, permettant de referencer le blocage. Utile pour appeler un code sur un workflow
    private String libelle; // Libelle du motif de blocage
    private int respBlocage; // Responsable du blocage. Voir codes RESP_XXX


    @Override
    public int compareTo(Object o) {
        if (o == null || !(o instanceof MotifBlocage)) {
            return 0;
        }
        MotifBlocage c = (MotifBlocage)o;
        int diff = respBlocage - c.getRespBlocage();
        if (diff != 0) {
            return diff;
        }
        if (codeBlocage != null && c.getCodeBlocage() != null) {
            diff = codeBlocage.compareTo(c.getCodeBlocage());
            if (diff != 0) {
                return diff;
            }
        }
        return (int)(getDateCreation() - c.getDateCreation());
    }
    
    @Override
    public String toString(){
        String sResp = "";
        if (respBlocage == RESP_CLIENT) {
            sResp = "Client - ";
        }
        else if (respBlocage == RESP_DO) {
            sResp = "DO - ";
        }
        else if (respBlocage == RESP_STATION) {
            sResp = "Station - ";
        }
        return sResp+libelle;
    }
}
