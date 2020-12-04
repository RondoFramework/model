package com.globalsaas.rondo.model.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

import com.google.cloud.firestore.annotation.Exclude;

import lombok.Data;

@Data
public abstract class ServiceTimeObject extends ServiceObject {
    private static final long serialVersionUID = 1871279492075600204L;
    
    public static final int PRIORITE_NORMALE = 0;
    public static final int PRIORITE_HAUTE = 1;
    public static final int PRIORITE_URGENTE = 2;
    
    public static final int DUREE_SECONDES = 0;
    public static final int DUREE_MINUTES = 1;
    public static final int DUREE_HEURES = 2;
    public static final int DUREE_JOURS = 3;

    private Integer priorite;
    private Long debut;
    private Long fin;
    private Double duree;
    private Integer typeDuree; 
    private Long creneauDebut;
    private Long creneauFin;
    private String idActivite;
    private String idEmploye;
    private String reference;
    private Double easting;
    private Double northing;

    @Override
    public int compareTo(Object o) {
        if (o == null || !o.getClass().equals(ServiceTimeObject.class)) {
            throw new ClassCastException();
        }
        ServiceTimeObject i = (ServiceTimeObject) o;
        int comparaison = 0;
        if (getDebut() > 0 && i.getDebut() > 0) {
            comparaison = (int)(getDebut() - ((Acte) o).getDebut());
        }
        if (comparaison != 0) {
            return comparaison;
        }
        comparaison = getIdActivite().compareTo(i.getIdActivite());
        if (comparaison != 0) {
            return comparaison;
        }
        return (int)(duree - i.getDuree());
    }

    @Exclude
    public static final LocalDateTime getLocalDateFromTimestamp(long timestamp) {
        LocalDateTime triggerTime = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(timestamp), TimeZone.getDefault().toZoneId());
        return triggerTime;
    }
}