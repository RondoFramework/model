/*
 * Devis.java
 *
 * Created on 11 janvier 2005, 12:37
 */
package com.globalsaas.rondo.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("Devis")
@Data
public class Devis extends ServiceFinanceObject implements ServiceAffaireObject, ServiceChild, MetadataContainer {
    private static final long serialVersionUID = -1821076204757741449L;
    //@JsonTypeId
    private String typeObjet = ObjectType.DEVIS.name;

    public static final int ETAT_EDITE = 0;
    public static final int ETAT_ANNULE = 1;
    public static final int ETAT_PROPOSE = 2;
    public static final int ETAT_RECU = 3;
    public static final int ETAT_ACCEPTE = 4;
    public static final int ETAT_REFUSE = 5;
    public static final String[] ETATS = { "Edit\u00e9", "Annul\u00e9", "propos\u00e9", "re\u00e7u", "accept\u00e9",
            "refus\u00e9" };
    public static final ArrayList<String> ETATS_LIST = new ArrayList(Arrays.asList(ETATS));

    private boolean accepte; // Flag pour indiquer si le devis a ete accepte
    private Long dateAccept; // Date a laquelle le devis a ete accepte
    private String remarques; // Remarques en fin de devis
    private String remarquesEnTete; // Remarques a afficher en entete
    private String enTete; // Texte libre, a afficher en entete
    private int etat; // edite, propose, accepte ou annule
    private Integer delaiValidite; // Nombre de jours de validite

    private String titre; // Libelle du devis

    private boolean facture; // Indique si le devis a donne lieu a facturation

    private boolean nonGreAGre; // Pour des devis presentes au DO et pas au client

    private List<Metadata> metadatas;
}
