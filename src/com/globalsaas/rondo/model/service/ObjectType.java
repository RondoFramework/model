package com.globalsaas.rondo.model.service;

import com.globalsaas.rondo.model.tache.*;

/**
 * ObjectType
 */
public enum ObjectType {

    NO_TYPE ("NoType", "", Object.class, 0),
    ACTE ("Acte", "acte", Acte.class, 1),
    ACTIVITE ("Activite", "activite", Activite.class, 2),
    AFFAIRE ("Affaire", "affaire", Affaire.class, 3),
    AFFAIRE_TABLE ("AffaireTable", "affaire_table", AffaireTable.class, 4),
    AFFAIRE_FILTRE ("AffaireFiltre", "affaire_filtre", AffaireFiltreConfig.class, 5),
    ABSENCE ("Absence", "absence", Absence.class, 6),
    AGENCE ("Agence", "agence", Agence.class, 7),
    ARTICLE ("Article", "article", Article.class, 8),
    ARTICLE_DOSSIER ("ArticleDossier", "article_dossier", ArticleDossier.class, 9),
    BANQUE ("Banque", "banque", Banque.class, 10),
    BLOCAGE_STATION ("BlocageStation", "blocage_station", BlocageStation.class, 11),
    CLASSE ("Classe", "classe", Classe.class, 12),
    CLIENT ("Client", "client", Client.class, 13),
    CLIENT_TABLE ("ClientTable", "client_table", ClientTable.class, 14),
    COMMUNICATION ("Communication", "communication", Communication.class, 12),
    COMPETENCE ("Competence", "competence", Competence.class, 16),
    COMPTE_RENDU ("CompteRendu", "compte_rendu", CompteRendu.class, 17),
    CONFIG_CODE_NOK ("ConfigCodeNok", "config_code_nok", ConfigCodeNok.class, 18),
    CONTACT ("Contact", "contact", Contact.class, 19),
    DEVIS ("Devis", "devis", Devis.class, 20),
    EMPLOYE ("Employe", "employe", Employe.class,21),
    ENTREPOT ("Entrepot", "entrepot", Entrepot.class, 22),
    EQUIPEMENT ("Equipement", "equipement", Equipement.class, 23),
    ETABLISSEMENT ("Etablissement", "etablissement", Etablissement.class, 24),
    ETAT_INTER ("EtatInter", "etat_inter", EtatInter.class, 25),
    FACTURE ("Facture", "facture", Facture.class, 26),
    FICHIER ("Fichier", "fichier", Fichier.class, 27),
    FOURNISSEUR ("Fournisseur", "fournisseur", Fournisseur.class, 28),
    GAMME ("Gamme", "gamme", Gamme.class, 29),
    GROUPE ("Groupe", "groupe", Groupe.class, 30),
    JOUR_FERIE ("JourFerie", "jour_ferie", JourFerie.class, 31),
    MARQUE_PRODUIT ("MarqueProduit", "marque_produit", MarqueProduit.class, 32),
    MEMO ("Memo", "memo", Memo.class, 33),
    MODELE_INTERVENTION ("ModeleIntervention", "modele_intervention", ModeleIntervention.class, 34),
    MOTIF_BLOCAGE ("MotifBlocage", "motif_blocage", MotifBlocage.class, 35),
    MOTIF_COMMUNICATION ("MotifCommunication", "motif_communication", MotifCommunication.class, 36),
    OPERATION ("Operation", "operation", Operation.class, 37),
    PIECE_DETACHEE ("PieceDetachee", "piece_detachee", PieceDetachee.class, 38),
    PRESTATION ("Prestation", "prestation", Prestation.class, 39),
    PRESTATION_TABLE ("PrestationTable", "prestation_table", PrestationTable.class, 40),
    PRODUIT ("Produit", "produit", Produit.class, 41),
    PRIX_ARTICLE ("PrixArticle", "prix_article", PrixArticle.class, 42),
    QUALITE_STATION ("QualiteStation", "qualite_station", QualiteStation.class, 43),
    QUALITE_PRESTATION ("QualitePrestation", "qualite_prestation", QualitePrestation.class, 44),
    REDUCTION_DF ("ReductionDf", "reduction_df", ReductionDf.class, 45),
    REGLEMENT ("Reglement", "reglement", Reglement.class, 46),
    RESULTAT_COMMUNICATION ("ResultatCommunication", "resultat_communication", ResultatCommunication.class, 47),
    SIMPLE_DAO ("SimpleDAO", "simple_dao", SimpleDAOConcept.class, 48),
    ENTITE ("Entite", "entite", Entite.class, 49),
    SOUS_TRAITANT ("SousTraitant", "sous_traitant", SousTraitant.class, 50),
    STOCK ("Stock", "stock", Stock.class, 51),
    TACHE ("Tache", "tache", Tache.class, 52),
    TACHE_ETAT ("TacheEtat", "tache_etat", TacheEtat.class, 53),
    TACHE_GROUPE ("TacheGroupe", "tache_groupe", TacheGroupe.class, 54),
    TACHE_GROUPE_EMPLOYE ("TacheGroupeEmploye", "tache_groupe_employe", TacheGroupeEmploye.class, 55),
    TACHE_PRIORITE ("TachePriorite", "tache_priorite", TachePriorite.class, 56),
    TACHE_TYPE ("TacheType", "tache_type", TacheType.class, 57),
    TRANSFERT_STOCK ("TransfertStock", "transfert_stock", TransfertStock.class, 58),
    TRANSPORTEUR ("Transporteur", "transporteur", Transporteur.class, 59),
    TYPE_OBJET_AFFAIRE ("TypeObjetAffaire", "type_objet_affaire", TypeObjetAffaire.class, 60),
    VALID_COMPETENCE ("ValidCompetence", "valid_competence", ValidCompetence.class, 61),
    ZONE_COMPETENCE ("ZoneCompetence", "zone_competence", ZoneCompetence.class, 62),
    ZONE_INSEE ("ZoneInsee", "zone_insee", ZoneInsee.class, 63);

    public String name = "";
    public String storage = "";
    public Class typeClass = Object.class;
    public int typeId;

    ObjectType(String name, String storage, Class typeClass, int typeId) {
        this.name = name;
        this.storage = storage;
        this.typeClass = typeClass;
        this.typeId = typeId;
    }
}