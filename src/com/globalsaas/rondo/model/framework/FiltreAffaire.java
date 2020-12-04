/*------------------------------------------------------------------------------
 * Nom de la classe : RequeteAffaire
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Objet permettant de filtrer des affaires par les differentes valeurs que
 * peuvent prendre les lignes de AffaireTable er PrestaTable
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.framework;

import java.time.LocalDate;
import java.util.ArrayList;

import com.globalsaas.rondo.model.service.SimpleDAOConcept;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FiltreAffaire extends RondoPersistObject implements java.io.Serializable {
    private static final long serialVersionUID = -332364420995743537L;

    public final static String STATUT_AFFAIRE_OUVERT = "OUVERT";
    public final static String STATUT_AFFAIRE_EN_COURS = "EN_COURS";
    public final static String STATUT_AFFAIRE_CLOTURE = "CLOTURE";
    
    public final static String STATUT_FACTURATION_RIEN = "NA";
    public final static String STATUT_FACTURATION_A_FACTURER_A_PAYER = "A_FACTURER_A_PAYER";
    public final static String STATUT_FACTURATION_A_FACTURER_PAYE = "A_FACTURER_PAYE";
    public final static String STATUT_FACTURATION_FACTURE_A_PAYER = "FACTURE_A_PAYER";
    public final static String STATUT_FACTURATION_FACTURE_PAYE = "FACTURE_PAYE";
    
    public final static String STATUT_DELAI_INF_2J = "INF_2J";
    public final static String STATUT_DELAI_2J_A_7J = "2_A_7J";
    public final static String STATUT_DELAI_7J_A_14J = "7_A_14J";
    public final static String STATUT_DELAI_14J_A_21J = "14_A_21J";
    public final static String STATUT_DELAI_PLUS_21J = "SUP_21J";
    
    public final static String STATUT_PRIORITE_BASSE = "BASSE";
    public final static String STATUT_PRIORITE_NORMALE = "NORMALE";
    public final static String STATUT_PRIORITE_HAUTE = "HAUTE";
    public final static String STATUT_PRIORITE_TRES_HAUTE = "TRES_HAUTE";
    public final static String STATUT_PRIORITE_VIP_URGENT = "URGENT_VIP";

    public final static String STATUT_REPARATION_AUCUNE = "NA";
    public final static String STATUT_REPARATION_EN_COURS = "EN_COURS";
    public final static String STATUT_REPARATION_BLOCAGE = "BLOCAGE";
    public final static String STATUT_REPARATION_TERMINE = "TERMINE";
    
    public final static String STATUT_GARANTIE_AUCUNE = "NA";
    public final static String STATUT_GARANTIE_REPARATION = "G_REPARATION";
    
    public final static String STATUT_DEVIS_AUCUN = "AUCUN";
    public final static String STATUT_DEVIS_ACCEPTE = "ACCEPTE";
    public final static String STATUT_DEVIS_REFUSE = "REFUSE";
    public final static String STATUT_DEVIS_EN_ATTENTE = "EN_ATTENTE";
    
    public final static int TEXTE_NOM = 0;
    public final static int TEXTE_NUM_SERIE = 1;
    public final static int TEXTE_REF = 2;
    public final static int TEXTE_REF_ST = 3;
    public final static int TEXTE_REF_DO = 4;
    public final static int TEXTE_MARQUE = 5;
    public final static int TEXTE_REF_CLIENT = 6;
    public final static int TEXTE_DEPT = 7;
    public final static int TEXTE_TEL = 8;
    
    public final static int TYPE_DATE_AUCUNE = 0;
    public final static int TYPE_DATE_INTEGRATION = 1;
    public final static int TYPE_DATE_INTER = 2;
    
    public final static int STATUT_PIECE_AUCUN = 0;
    public final static int STATUT_PIECE_POSEE = 1;
    public final static int STATUT_PIECE_RECU = 2;
    public final static int STATUT_PIECE_ENVOYE = 3;
    public final static int STATUT_PIECE_RESERVE = 4;
    public final static int STATUT_PIECE_EN_COMMANDE = 5;
    public final static int STATUT_PIECE_A_COMMANDER = 6;
    public final static int STATUT_PIECE_ATTENTE_REFERENCE = 7;
    public final static String[] STATUT_PIECE_LIBELLE = new String[] {"Aucun", "Pi\u00e8ce(s) pos\u00e9e(s)", "Pi\u00e8ce(s) re\u00e7ue(s)", 
        "Pi\u00e8ce(s) envoy\u00e9e(s)", "Pi\u00e8ce(s) r\u00e9serv\u00e9e(s)", "Pi\u00e8ce(s) en commande", 
        "Pi\u00e8ce(s) \u00e0 commander", "Pi\u00e8ce(s) \u00e0 r\u00e9f\u00e9rencer"};
    
    public final static String STATUT_INTER_AUCUN = "NA";
    public final static String STATUT_INTER_ANNULE = "ANNULE";
    public final static String STATUT_INTER_TERMINE = "TERMINE";
    public final static String STATUT_INTER_EN_COURS = "EN_COURS";
    public final static String STATUT_INTER_PLANIFIE_RDV_CONFIRME = "RDV_CONFIRME";
    public final static String STATUT_INTER_PLANIFIE = "PLANIFIE";
    public final static String STATUT_INTER_A_PLANIFIER_CONTACTE = "A_PLANIFIER_CONTACTE";
    public final static String STATUT_INTER_A_PLANIFIER = "A_PLANIFIER";
    public final static String[] STATUT_INTER_LIBELLE = new String[] {"Aucun", "Acte termin\u00e9", "Acte en cours", 
        "Acte planifi\u00e9 - RDV confirm\u00e9", "Acte planifi\u00e9", "A planifier - client contact\u00e9", 
        "A planifier"};
  
    private ArrayList<SimpleDAOConcept> idsClient = new ArrayList<SimpleDAOConcept>(); // Pour une requete par les identifiants de clients
    private ArrayList<SimpleDAOConcept> idsAffaire = new ArrayList<SimpleDAOConcept>(); // Pour une requete par les identifiants des affaires
    private ArrayList<SimpleDAOConcept> domaines = new ArrayList<SimpleDAOConcept>(); // Filtre des domaines des affaires
    private ArrayList<SimpleDAOConcept> departements = new ArrayList<SimpleDAOConcept>(); // Filtre sur les departements des adresses des affaires
    private ArrayList<SimpleDAOConcept> typesAffaire = new ArrayList<SimpleDAOConcept>(); // Filtre sur les types d'affaires
    private ArrayList<SimpleDAOConcept> statutsAffaire = new ArrayList<SimpleDAOConcept>(); // Filtre sur les statuts des affaires (TypeObjetAffaire)
    private ArrayList<SimpleDAOConcept> statutsDelais = new ArrayList<SimpleDAOConcept>(); // Filtre sur les statuts de delai - STATUT_DELAI_XXX
    private ArrayList<SimpleDAOConcept> statutsFacturation = new ArrayList<SimpleDAOConcept>(); // Filtre sur les statuts de facturationd es affaires - STATUT_FACTURATION_XXX
    private ArrayList<SimpleDAOConcept> statutsPriorite = new ArrayList<SimpleDAOConcept>(); // Filtre sur les statuts de priorite - STATUT_PRIORITE_XXX
    private ArrayList<SimpleDAOConcept> statutsGarantieReparation = new ArrayList<SimpleDAOConcept>(); // Filtre sur les statuts de garantie reparation - STATUT_GARANTIE_XXX
    private ArrayList<SimpleDAOConcept> statutsReparation = new ArrayList<SimpleDAOConcept>(); // Filtre sur les statuts de reparation des prestations
    private ArrayList<SimpleDAOConcept> typesPrestation = new ArrayList<SimpleDAOConcept>(); // Filtre sur les types de prestations (TypeObjetAffaire)
    private ArrayList<SimpleDAOConcept> agencesReparation = new ArrayList<SimpleDAOConcept>(); // Filtre sur les agences de reparation affectees aux prestations
    private ArrayList<SimpleDAOConcept> blocages = new ArrayList<SimpleDAOConcept>(); // Filtre sur les statuts de blocage
    private ArrayList<SimpleDAOConcept> statutsDevis = new ArrayList<SimpleDAOConcept>(); // Filtre sur les statuts de devis - STATUT_DEVIS_XXX
    private ArrayList<SimpleDAOConcept> statutsInter = new ArrayList<SimpleDAOConcept>(); // Filtre sur les statuts de planification des inters - STATUT_INTER_XXX
    private ArrayList<SimpleDAOConcept> statutsPiece = new ArrayList<SimpleDAOConcept>(); // Filtre sur les statuts de commande de pieces - STATUT_PIECE_XXX
    private ArrayList<SimpleDAOConcept> responsables = new ArrayList<SimpleDAOConcept>(); // Filtre sur les ids des employes responsables des affaires
    private ArrayList<SimpleDAOConcept> codesNok = new ArrayList<SimpleDAOConcept>(); // Filtre sur les codes NOK de cloture des actes
    private String userEmail; // Identifiant du proprietaire pour une config privee
    private boolean clientPro; // Permet de filtrer sur les clients pro
    private int typeChamp; // Pour une recherche par texte libre, champ de recherche - TEXTE_XXX
    private String champRecherche; // Valeur du champ de recherche txte libre
    private boolean dossiersClotures; // Flag pour inclure les dossiers clotures
    private int typeDate; // Type de date pour un filtre par date - TYPE_DATE_XXX
    private LocalDate dateDebut; // Pour une recherche par date, date min
    private LocalDate dateFin; // Pour une recherche par date, date max
    
    private String requeteBase;
    
    public FiltreAffaire(String requeteBase) {
        this.requeteBase = requeteBase;
    }

    public String getValuesList(ArrayList<SimpleDAOConcept> values, String colName, boolean ids) {
        if (values != null && !values.isEmpty()) {
            StringBuilder builder = new StringBuilder(" AND ").append(colName).append(" IN (");
            boolean first = true;
            for (SimpleDAOConcept value : values){
                if (!first) {
                    builder.append(", ");
                }
                if (ids) {
                    builder.append(value.getId());
                }
                else {
                    builder.append("'").append(value.getLibelle()).append("'");
                }
                first = false;
            }
            builder.append(")");
            return builder.toString();
        }
        return "";
    }
}
