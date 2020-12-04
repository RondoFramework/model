package com.globalsaas.rondo.rest.model;

import java.util.List;

import com.globalsaas.rondo.model.service.Acte;
import com.globalsaas.rondo.model.service.Affaire;
import com.globalsaas.rondo.model.service.ArticleDossier;
import com.globalsaas.rondo.model.service.Client;
import com.globalsaas.rondo.model.service.CompteRendu;
import com.globalsaas.rondo.model.service.Contact;
import com.globalsaas.rondo.model.service.Devis;
import com.globalsaas.rondo.model.service.Facture;
import com.globalsaas.rondo.model.service.Fichier;
import com.globalsaas.rondo.model.service.Memo;
import com.globalsaas.rondo.model.service.Operation;

import lombok.Data;

@Data
public class RestAffaire {
    private Affaire affaire;
    private Client client;
    private List<Acte> actes;
    private Contact adresse;
    private List<Devis> devis;
    private List<Facture> factures;
    private List<Memo> memos;
    private List<Operation> operations;
    private List<ArticleDossier> articles;
    private List<Fichier> fichiers;
    private List<RestPrestation> prestations;
    private List<CompteRendu> compteRendus;
}