package com.globalsaas.rondo.model.framework;

import java.util.ArrayList;

import lombok.Data;

@Data
public class WorkflowConfig extends RondoPersistObject {
    public final static int TRIGGER_CRUD = 0;
    public final static int TRIGGER_CRON = 1;
    public final static int TRIGGER_REQUETE = 2;
    public final static int TRIGGER_OPERATION = 3;
    
    private int typeTrigger;
    private String refTrigger; // Pour le CRON et les requetes
    private String typeObjetCRUD; // Pour un trigger CRUD
    private int typeCRUD; // Pour un trigger CRUD
    private int typeOperation; // Pour un trigger operation
    private String typeObjetOperation; // Por un trigger operation
    
    private String refFiltre;
    
    private ActionWorkflow mainAction;
    private ArrayList<ActionWorkflow> asyncActions;
    

}
