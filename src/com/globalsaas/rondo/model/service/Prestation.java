/*------------------------------------------------------------------------------
 * Nom de la classe : Prestation
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 31 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Prestation, qui represente une demande technique a realiser 
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

@JsonTypeName("Prestation")
@Data
public class Prestation extends ServiceObject implements ServiceAffaireObject, MetadataContainer, DelegationContainer {
    private static final long serialVersionUID = 4611718571460144997L;
    //@JsonTypeId
    private String typeObjet = ObjectType.PRESTATION.name;

    public final static int BLOCAGE_AUCUN = 0;
    public final static int BLOCAGE_CLIENT = 1;
    public final static int BLOCAGE_DO = 2;
    public final static int BLOCAGE_TECH = 3;
    
    private String idAffaire; // Identifiant de l'affaire a laquelle est liee la prestation
    private String idAdresse; // Identifiant du contact sur lequel la prestation est lie
    private String type; // Type de prestation, lie a TypeObjetAffaire
    private String reference; // Reference unique de l'affaire, genere en interne
    private String refDo; // reference communiquee par le client DO
    private String refSt; // Reference communiquee par le prestataire
    private String idAgenceReparation; // Identifiant de l'agence qui traite le dossier
    private String domaineReparation; // Domaine des employes qui traitent la prestation
    private boolean acceptSt; // Indique si le prestataire a accepte de traiter la prestation
    private String dateAcceptSt; // Date a laquelle la prestation a ete acceptee, format ISO
    private String idPrestaPrecedente; // Pour une prestation qui est contrainte par une prestation a realiser precedemment
    private int blocage; // Type de blocage de la prestation. Voir variables BLOCAGE_XXX
    private String motifBlocage; // Libelle du motif de blocage
    private String commentClient; // COmmentaires du client
    private String commentDo; // COmmentaires du donneur d'ordres
    private String demande; // Libelle de la demande
    private String dateFin; // Date de fin de la prestation, format ISO
    private String dateFinDemandee; // Date de fin demandee par le client, format ISO
    private String dateFinPrev; // Date previsionnelle de fin de prestation, format ISO
    private String dateCloture; // Date de cloture de la prestation, format ISO
    private String idEmpCreation; // Employe qui a cree la prestation
    private String idEmpCloture; // Employe qui a cloture la prestation
    private Long dateMandat; // Date a laquelle la prestation a ete mandatee
    private String idEquipement; // Identifiant de l'equipement pour lequel la prestation a ete creee
    private Double plafondIndemnisation; // Plafind d'indemnisation, qui permet de limiter le montant lie a la prestation
    private int statutReparation; // Code de statut de la prestation
    private int priorite; // Statut de priorite (-2 a 2)
    private String idStRefus1; // Identifiant de la premiere station qui a refuse la prestation
    private String idStRefus2; // Identifiant de la deuxieme station qui a refuse la prestation
    private String idStRefus3; // Identifiant de la troisieme station qui a refuse la prestation
    private boolean stationForce; // Le mandat a ete force
    private int longueurTrajetSta; // Longueur du trajet calcule lors du mandat
    private int dureeTrajetSta; // Duree du trajet calcule lors du mandat
    private boolean appelTech; // Flag de gestion : le technicien a ete appele
    private boolean validAdmin; // Flag de gestion : validation adinistrative
    private boolean validSupport; // Flag de gestion : validation de la cloture par le support
    private boolean preValidDepl; // Flag de gestion : validation au moment du prediagnostic, avant envoi d'un technicien
    private boolean cloture; // La prestation a ete cloturee
    private boolean surSite; // La prestation doit etre realisee sur site
    private String idModele; // Modele d'acte, pour faire de l'affectation sur une prestation sans equipement
    private String idClasse; // Pour un equipement, classe de l'appareil

    private List<Metadata> metadatas; // Information complementaires, qui dependent du type
    private List<Delegation> delegations;

    
    public String toString() {
        return reference;
    }

    
    @Override
    public int compareTo(Object o) {
        if (o == null || !(o instanceof Prestation)) {
            return 0;
        }
        Prestation p = (Prestation)o;
        int result = (int)(getDateCreation() - p.getDateCreation());
        if (result != 0) {
            return result;
        }
        result = priorite - p.getPriorite();
        if (result != 0) {
            return result;
        }
        result = statutReparation - p.getStatutReparation();
        if (result != 0) {
            return result;
        }
        if (dateFinDemandee != null) {
            if (p.getDateFinDemandee() == null) {
                return 1;
            }
            else {
                return dateFinDemandee.compareTo(p.getDateFinDemandee());
            }
        }
        return (int)(getDateCreation() - p.getDateCreation());
    }
}
