package com.globalsaas.rondo.model.service;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeName("ClientTable")
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientTable extends ServiceObject {
    private static final long serialVersionUID = 587451235514L;
    //@JsonTypeId
    private String typeObjet = ObjectType.CLIENT_TABLE.name;
    
    private String idClient;
    private String nom;
    private String nomContact;
    private boolean profesionnel;
    private String telephone;
    private String mobile;
    private String email;
    private String siret;
    private String reference;
    private String referenceDo;
    private String commercial;
    private String connuComment;
    private String adresse;
    private String codePostal;
    private String ville;
    private String codeDepartement;
    private String codeRegion;
    private Double montantCa;
    private int nombreAffaires;
    private int nbDevisEnCours;
    private Double montantDevisEnCours;
    private Double montantNonPaye;

}