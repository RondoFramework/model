/*------------------------------------------------------------------------------
 * Nom de la classe : CRONDef
 * Produit : Rondo
 * Module : Framework
 * Auteurs : GlobalSaaS
 * CCopyright (c) 2019 Myfowo
 * 1e version : 31 décembre 2019
 *------------------------------------------------------------------------------
 * Description :
 * Description d'une definition de type crontab. La ref, designation et domaine
 * permettent de manipuler les definitions de cron.
 * Les valeurs cronXXX prmettent de definit la frequence des appels.
 * Les valeurs sont de type :
 *    - Numerique pour une valeur fixe. Ex : 10
 *    - * : a chaque unite
 *    - 5,8 : les unites 5 et 8
 *    - 5-8 : les unites 5 a 8
 *    - *\/3 : Toutes les 3 unites (0,3,6,9...)                                 (Attention backslash juste pour ne pas interpreter)
 *    - 10-20/3 : Toutes les 3 unites, de 10 a 20 (10,13,16,19)
 *
 * Exemples :
 *    - 0 0 1 1 * : tous les ans
 *    - 0 * * * * : toutes les heures
 *    - 30 23 1 * * : Tous les 1e du mois a 23h30
 *    - 59 23 *\/2 * * : Tous les jours pais du mois a 23h59
 *    - 
 *    - 
 *    - 
 * https://fr.wikipedia.org/wiki/Cron
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */

package com.globalsaas.rondo.model.framework;

import lombok.Data;

@Data
public class CRONDef extends RondoPersistObject {
    private String designation;
    private String typeObjet;
    private String query;
    
    private String cronMin; // Definition des minutes (0 a 59)
    private String cronHeure; // Definition des heures (0 a 23)
    private String cronJour; // Definition du numero du jour dans le mois (1 a 31)
    private String cronMois; // Definition du mois (1 a 12)
    private String cronNumJour; // 0(dimanche), 1(lundi), 2(mardi), ... 7(dimanche) 

}
