/*------------------------------------------------------------------------------
 * Nom de la classe : ConfigCodeNok
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Configuration des codes de cloture d'un acte, avec informations pour gerer
 * l'orientation
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

@JsonTypeName("ConfigCodeNok")
@Data
public class ConfigCodeNok extends ServiceObject {
    private static final long serialVersionUID = 3636710314670241893L;
    //@JsonTypeId
    private String typeObjet = ObjectType.CONFIG_CODE_NOK.name;
    
    public static final int RESP_CLIENT_FINAL = 0;
    public static final int RESP_STATION = 1;
    public static final int RESP_DO = 2;
    public static final int RESP_FOURNISSEUR = 3;
    
    private String domainClient; // Identifiant du domaine du dossier pour laquelle on exploite la config (0 : tous les domaines)
    private String codeNok; // Reference du code NOK
    private int codeReparation; // Code de reparation a appliquer a la prestation qui est concernee
    private String libelle; // Libelle du code
    private int responsabilite; // Responsabilite de l'echec de l'acte (voir variables RESP_XXX)
    private boolean newInter; // On cree un nouvel acte sur l'affaire
    private boolean blocage; // On applique un blocage sur les prestations concernees
    private long codeBlocage; // Identifiant du motif de blocage a appliquer (voir MotifBlocage)
    private boolean annulation; // S'applique lors d'une annulation d'acte
    private boolean technicien; // Possibilite presentee au technicien
    private boolean solCom; // Conduit a une solution commerciale
    private boolean sendSMS; // Envoi d'un SMS
    private boolean sendMail; // Envoi d'un e-mail
    private String modeleEmail; // Modele de l'e-mail a envoyer
    private String modeleSMS; // Modele du SMS a envoyer

    @Override
    public String toString(){
        return libelle;
    }

}
