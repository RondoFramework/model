/*------------------------------------------------------------------------------
 * Nom de la classe : CRUDDef
 * Produit : Rondo
 * Module : Framework
 * Auteurs : Globalsaas
 * CCopyright (c) 2019 Globalsaas
 * 1e version : 31 decembre 2019
 *------------------------------------------------------------------------------
 * Description :
 * Definition d'une regle d'evolution d'un objet. Par exemple, planification 
 * signifie qu'un acte a vu son champ etat passer de 0 a 1.
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */

package com.globalsaas.rondo.model.framework;

import com.globalsaas.rondo.model.service.FieldValue;
import java.util.List;

import lombok.Data;

@Data
public class CRUDDef extends RondoPersistObject {
    private String designation;

    private Integer typeObjet; // Type d'objet pour lequel on va gerer le CRUD
    private List<FieldValue> oldValues; // Liste des valeurs que l'objet old doit avoir
    private List<FieldValue> newValues; // Liste des valeurs que l'objet old doit avoir
}