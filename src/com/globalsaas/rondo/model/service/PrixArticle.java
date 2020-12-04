package com.globalsaas.rondo.model.service;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("PrixArticle")
@Data
public class PrixArticle extends ServiceObject implements ServiceChild {
    private static final long serialVersionUID = 6487454125478L;
    //@JsonTypeId
    private String typeObjet = ObjectType.PRIX_ARTICLE.name;

    private double monantAchat;
    private double montantVente;
    private String typeParent; // Type de document source (ArticleDossier, PieceDetachee)
    private String idParent; // Identifiant du parent
}