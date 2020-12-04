package com.globalsaas.rondo.model.framework;

import com.globalsaas.rondo.model.service.ServiceObject;

import lombok.Data;

@Data
public class ActionRequete {
    private Profil profil; // Profil de l'emetteur de la requete
    
    private String refAction; // Si on sait quelle est l'action a effectuer, on saisit ces valeurs
    private String refWebAppAction; // On peut forcer l'envoi d'une action a une webapp specifique.
    private String refApp; // Reference de la webapp qui transmet la requete
    private String refCallback; // Reference de la query que doit retourner une webapp dans son callback
    private ServiceObject entree;
    private String param1;
    private String param2;
    private String param3;
    private String param4;
    private String param5;
    
}
