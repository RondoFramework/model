/*------------------------------------------------------------------------------
 * Nom de la classe : CompteRendu
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Informations necessaires pour un compte rendu
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

@JsonTypeName("CompteRendu")
@Data
public class CompteRendu extends ServiceObject implements ServiceAffaireObject, MetadataContainer {
    private static final long serialVersionUID = -4258780555026344281L;
    //@JsonTypeId
    private String typeObjet = ObjectType.COMPTE_RENDU.name;
    
    private String idPrestation; // Identifiant de la prestation pour laquelle on fait le compte-rendu
    private String idAffaire; // Identifiant de l'affaire de la prestation ou de l'acte
    private String idActe; // Identifiant de l'acte au cours duquel le compte-rendu a ete saisi
    private String type; // Type de compte-rendu (lie a TypeObjetAffaire)
    private Long date; // Date d'edition du compte-rendu
    private String idEmploye; // Id de l'employe qui a saisi le compte-rendu
    private long codeNok; // Code NOK permettant de gerer le workflow apres le compte-rendu
    private boolean cloturePrestation; // Le CR amene a une cloture de la prestation
    private boolean accordNecessaire; // Un accord du DO est necessaire pour continuer la prestation
    private boolean commandeNecessaire; // Une commande de piece est necessaire suite a ce CR
    private List<Metadata> metadatas; // Informations specifiques au type de CR
    private String travauxEffectues; // Informations textuelles pour decrire les travaux effectues
    
    @Override
    public String toString() {
        return "CR du "+date;
    }

}
