/*------------------------------------------------------------------------------
 * Nom de la classe : ResultatCommunication
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 23 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Definition d'un resultat de communication. Depend d'un domaine', ce qui permet
 * a un client de definir sa propre terminologie. Permet de declarer, pour un
 * appel telephonique, comment s'est cloture la communication, et quelle 
 * orientation donner.
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

@JsonTypeName("ResultatCommunication")
@Data
public class ResultatCommunication extends ServiceObject {
    private static final long serialVersionUID = 290234843794265024L;
    //@JsonTypeId
    private String typeObjet = ObjectType.RESULTAT_COMMUNICATION.name;

    private String nom; // Libelle du resultat
    private boolean coordNonAttribuee; // Les coordonnees n'ont pas permis de contacter le client
    private boolean appelDecroche; // Les coordonnees sont correctes, et il y a eu un decroche sur un appel sortant
    private boolean contactArgumente; // La communication a amene a une argumentation entre l'employe et le contact du client
    
    @Override
    public String toString() {
        return getNom();
    }
}
