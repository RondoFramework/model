/*------------------------------------------------------------------------------
 * Nom de la classe : AppMenu
 * Produit : Rondo
 * Module : Model
 * Auteurs : Globalsaas
 * Copyright (c) 2020 Globalsaas
 * 1e version : 26 juillet 2020
 *------------------------------------------------------------------------------
 * Description :
 * Entée de menu pour une WebApp. Ceci permet de faire rentrer une application
 * compatible RONDO dans l'interface graphique du framework. 
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppMenu {
    private String htmlAId;
    private String htmlClass;
    private String libelle;
    private String materialIconLabel;
    private String url;
    private boolean admin;
    private boolean profil;
}