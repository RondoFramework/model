/*------------------------------------------------------------------------------
 * Nom de la classe : PrestationTable
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Table d'agregat permettant de representer une prestation et les objets joints
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.globalsaas.rondo.model.service.AffaireTable.AffaireTableBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeName("PrestationTable")
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrestationTable extends ServiceObject {
    private static final long serialVersionUID = 2386448777174312052L;
    //@JsonTypeId
    private String typeObjet = ObjectType.PRESTATION_TABLE.name;

    private String idGroupeEquipement;
    private String groupeEquipement;
    private String idClasseEquipement;
    private String classeEquipement;
    private String refEquipement;
    private String numSerieEquipement;
    private String marqueEquipement;
    private String gammeEquipement;
    private boolean garantieMarque;
    private String texteGarantie;
    private String idFournisseurEquipement;
    private String idAgenceReparation;
    private String nomAgenceReparation;
    private String villeAgenceReparation;
    private int nbPiecesAPoser;
    private String statutPiecesAPoser;
    private int idStatutPiece;
    private String reference;
    private String refDo;
    private String refSt;
    private boolean garantieReparation;
    private long type;
    private String nomTypePrestation;
    private int priorite;
    private int statutReparation;
    private String nomStatutReparation;
    private int blocage;
    private String motifBlocage;
    private String dateCreationPresta;
    private String dateFinPresta;
    private boolean cloture;
    private boolean surSite;
    private String idSocieteReparation;
    private String idEmployeReparation;
}
