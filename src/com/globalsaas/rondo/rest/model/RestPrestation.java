package com.globalsaas.rondo.rest.model;

import java.util.List;

import com.globalsaas.rondo.model.service.Equipement;
import com.globalsaas.rondo.model.service.PieceDetachee;
import com.globalsaas.rondo.model.service.Prestation;

import lombok.Data;

@Data
public class RestPrestation {
    private Prestation prestation;
    private Equipement equipement;
    private List<PieceDetachee> pieces;
}