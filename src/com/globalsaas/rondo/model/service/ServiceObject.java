package com.globalsaas.rondo.model.service;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.globalsaas.rondo.model.tache.Tache;
import com.globalsaas.rondo.model.tache.TacheEtat;
import com.globalsaas.rondo.model.tache.TacheGroupe;
import com.globalsaas.rondo.model.tache.TacheGroupeEmploye;
import com.globalsaas.rondo.model.tache.TachePriorite;
import com.globalsaas.rondo.model.tache.TacheType;

import lombok.Data;

/**
 * ServiceObject
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "typeObjet")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Acte.class, name = "Acte"),
    @JsonSubTypes.Type(value = Activite.class, name = "Activite"),
    @JsonSubTypes.Type(value = Affaire.class, name = "Affaire"),
    @JsonSubTypes.Type(value = AffaireTable.class, name = "AffaireTable"),
    @JsonSubTypes.Type(value = AffaireFiltreConfig.class, name = "AffaireFiltre"),
    @JsonSubTypes.Type(value = Absence.class, name = "Absence"),
    @JsonSubTypes.Type(value = Agence.class, name = "Agence"),
    @JsonSubTypes.Type(value = Article.class, name = "Article"),
    @JsonSubTypes.Type(value = ArticleDossier.class, name = "ArticleDossier"),
    @JsonSubTypes.Type(value = Banque.class, name = "Banque"),
    @JsonSubTypes.Type(value = BlocageStation.class, name = "BlocageStation"),
    @JsonSubTypes.Type(value = Classe.class, name = "Classe"),
    @JsonSubTypes.Type(value = Client.class, name = "Client"),
    @JsonSubTypes.Type(value = ClientTable.class, name = "ClientTable"),
    @JsonSubTypes.Type(value = Communication.class, name = "Communication"),
    @JsonSubTypes.Type(value = Competence.class, name = "Competence"),
    @JsonSubTypes.Type(value = CompteRendu.class, name = "CompteRendu"),
    @JsonSubTypes.Type(value = ConfigCodeNok.class, name = "ConfigCodeNok"),
    @JsonSubTypes.Type(value = Contact.class, name = "Contact"),
    @JsonSubTypes.Type(value = Devis.class, name = "Devis"),
    @JsonSubTypes.Type(value = Employe.class, name = "Employe"),
    @JsonSubTypes.Type(value = Entrepot.class, name = "Entrepot"),
    @JsonSubTypes.Type(value = Equipement.class, name = "Equipement"),
    @JsonSubTypes.Type(value = Etablissement.class, name = "Etablissement"),
    @JsonSubTypes.Type(value = EtatInter.class, name = "EtatInter"),
    @JsonSubTypes.Type(value = Facture.class, name = "Facture"),
    @JsonSubTypes.Type(value = Fichier.class, name = "Fichier"),
    @JsonSubTypes.Type(value = Fournisseur.class, name = "Fournisseur"),
    @JsonSubTypes.Type(value = Gamme.class, name = "Gamme"),
    @JsonSubTypes.Type(value = Groupe.class, name = "Groupe"),
    @JsonSubTypes.Type(value = JourFerie.class, name = "JourFerie"),
    @JsonSubTypes.Type(value = MarqueProduit.class, name = "MarqueProduit"),
    @JsonSubTypes.Type(value = Memo.class, name = "Memo"),
    @JsonSubTypes.Type(value = ModeleIntervention.class, name = "ModeleIntervention"),
    @JsonSubTypes.Type(value = MotifBlocage.class, name = "MotifBlocage"),
    @JsonSubTypes.Type(value = MotifCommunication.class, name = "MotifCommunication"),
    @JsonSubTypes.Type(value = Operation.class, name = "Operation"),
    @JsonSubTypes.Type(value = PieceDetachee.class, name = "PieceDetachee"),
    @JsonSubTypes.Type(value = Prestation.class, name = "Prestation"),
    @JsonSubTypes.Type(value = PrestationTable.class, name = "PrestationTable"),
    @JsonSubTypes.Type(value = PrixArticle.class, name = "PrixArticle"),
    @JsonSubTypes.Type(value = Produit.class, name = "Produit"),
    @JsonSubTypes.Type(value = QualitePrestation.class, name = "QualitePrestation"),
    @JsonSubTypes.Type(value = QualiteStation.class, name = "QualiteStation"),
    @JsonSubTypes.Type(value = ReductionDf.class, name = "ReductionDf"),
    @JsonSubTypes.Type(value = Reglement.class, name = "Reglement"),
    @JsonSubTypes.Type(value = ResultatCommunication.class, name = "ResultatCommunication"),
    @JsonSubTypes.Type(value = SimpleDAOConcept.class, name = ""),
    @JsonSubTypes.Type(value = Entite.class, name = "Entite"),
    @JsonSubTypes.Type(value = SousTraitant.class, name = "SousTraitant"),
    @JsonSubTypes.Type(value = Stock.class, name = "Stock"),
    @JsonSubTypes.Type(value = Tache.class, name = "Tache"),
    @JsonSubTypes.Type(value = TacheEtat.class, name = "TacheEtat"),
    @JsonSubTypes.Type(value = TacheGroupe.class, name = "TacheGroupe"),
    @JsonSubTypes.Type(value = TacheGroupeEmploye.class, name = "TacheGroupeEmploye"),
    @JsonSubTypes.Type(value = TachePriorite.class, name = "TachePriorite"),
    @JsonSubTypes.Type(value = TacheType.class, name = "TacheType"),
    @JsonSubTypes.Type(value = TransfertStock.class, name = "TransfertStock"),
    @JsonSubTypes.Type(value = Transporteur.class, name = "Transporteur"),
    @JsonSubTypes.Type(value = TypeObjetAffaire.class, name = "TypeObjetAffaire"),
    @JsonSubTypes.Type(value = ValidCompetence.class, name = "ValidCompetence"),
    @JsonSubTypes.Type(value = ZoneCompetence.class, name = "ZoneCompetence"),
    @JsonSubTypes.Type(value = ZoneInsee.class, name = "ZoneInsee")
})
@Data
@MappedSuperclass
 public abstract class ServiceObject implements ServiceConcept, Comparable {
    private static final long serialVersionUID = -5829548708882568178L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
    private String domain;
    //private String typeObjet;
    private Long dateCreation;
    private Long dateUpdated;

    public abstract String getTypeObjet();
    public abstract void setTypeObjet(String type);

    @Override
    public int compareTo(Object o) {
        if (o == null || !(o instanceof ServiceObject)) {
            return 1;
        }
        return (int)(dateCreation - ((ServiceObject)o).getDateCreation());
    }

    @Override
    public boolean equals(Object o) {
        if (getId() == null || o == null || !Objects.equals(getClass(), o.getClass())) {
            return false;
        }
        return Objects.equals(getId(), ((ServiceObject)o).getId());
    }
    
}