/*
 * Facture.java
 *
 * Created on 11 janvier 2005, 12:38
 */
package com.globalsaas.rondo.model.service;

import java.text.NumberFormat;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("Facture")
@Data
public class Facture extends ServiceFinanceObject implements ServiceAffaireObject, ServiceChild, MetadataContainer {
    private static final long serialVersionUID = 4611773934886849906L;
    //@JsonTypeId
    private String typeObjet = ObjectType.FACTURE.name;
    
    private String remarques; // Remarques affichees en fin de facture
    private String remarquesEnTete; // Remarques positionnees en entete de la facture
    private String enTete; // En tete de la facture, texte libre
    private String remarquesCachees; // Remarques qui n'apparaissent pas sur l'edition
    
    // variables necessaires a la gestion des avoirs
    private int avoir; // si 0 : facture. Sinon : avoir
    private String idFactureParent; // id de la facture sur laquelle on a fait un avoir
    
    private Double escompte; // Valeur d'un escompte
    private boolean appliquerEscompte; // Flag pour appliquer un escompte
    private boolean envoye; // Flag pour une facture envoyee
    
    private boolean aRenouveler; // Flag pour une facture qui doit etre renouvelee
    private Long debutRenouvellement; // Date de debut du renouvellement
    private Long finRenouvellement; // Date de fin de renouvellement
    private int periodeRenouvellement; // Valeur de la periode de renouvellement
    private int typePeriodeRenouvellement; // 0 : jours; 1 : semaines; 2 : Mois; 3 : ans
    
    private boolean valide; // Facture validee
    private boolean regle;
    private long dateReglement;
    private String refReglement;

    private Long dateRecouvrement; // Date a laquelle le recouvrement doit etre effectue
    private boolean affacturage; // On applique de l'affacturage

    private List<Metadata> metadatas;

    
    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        if (avoir == 0) {// c'est une facture
            return "n\u00b0 "+getNumero()+" - "+numberFormat.format(getMontant());
        }
        else {//c'est un avoir
            return "Avoir n\u00b0 "+getNumero()+" - "+numberFormat.format(getMontant());
        }
    }
}
