/*------------------------------------------------------------------------------
 * Nom de la classe : JourFerie
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Pour une gestion de planning, jour ferie
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */

package com.globalsaas.rondo.model.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.cloud.firestore.annotation.Exclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeName("JourFerie")
@Data
@NoArgsConstructor
public class JourFerie extends ServiceObject {
    private static final long serialVersionUID = -1185182871901015800L;
    //@JsonTypeId
    private String typeObjet = ObjectType.JOUR_FERIE.name;

    private int annee; // Annee
    private Date jour; // Jour
    private String label; // Libelle du jour ferie (Noel, jour de l'an, etc.)
    private String pays; // Pays pour lequel on a un jour ferie
    private String region; // Region, pour une specificite
    private String date;
    
    public JourFerie(int annee, Date jour){
        this.annee = annee;
        this.jour = jour;
    }

    @Override
    public boolean equals (Object other){
        if (!(other instanceof JourFerie)) return false;
        JourFerie j = (JourFerie)other;
        if (annee == j.getAnnee() && jour.equals(j.getJour())) return true;
        return false;
    }
    
    @Override
    public String toString(){
        return jour.toString();
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || !o.getClass().equals(JourFerie.class)) throw new ClassCastException();
        JourFerie j = (JourFerie)o;
        if (j.getAnnee() != annee) return annee-j.getAnnee();
        return jour.compareTo(j.getJour());
    }

    /**
     * Retourne la liste des jours feries de l'annee pour un pays
     * 
     * @param int    annee
     * @param String pays retour Arraylist
     * @throws CloneNotSupportedException
     */
    @Exclude
    public ArrayList feries(int annee, String pays) throws CloneNotSupportedException {
        return feries(annee,pays,null);
    }
    
    /**
     * Listes jours feries en fonction des pays
     * 
     * @param int    annee
     * @param String pays ("FR", "BE", "DE")
     * @param String region (BW, BY, BE, BB, HB, HH, HE, MV, NI, NW, RP, SL, SN, ST,
     *               SH, TH pour l'Allemagne)
     * @return ArrayList jours feries
     * @throws CloneNotSupportedException
     */
    @Exclude
    public ArrayList feries(int annee, String pays, String region) throws CloneNotSupportedException {
        JourFerie jferie=new JourFerie();
        ArrayList liste = new ArrayList();
        String uPays = pays.toUpperCase();
        String uRegion = "";
        
        // calcul du lundi de Paques
        
        int     y = annee,
                a = y%19, 
                b = (int) (y/100), 
                c = y%100, 
                p = (int) (b/4), 
                e = b%4, 
                f = (int) ((b+8)/25), 
                g = (int) ((b-f+1)/3), 
                h = (19*a+b-p-g+15)%30, 
                i = (int) (c/4), 
                k = c%4, 
                r = (32+2*e+2*i-h-k)%7, 
                n = (int) ((a+11*h+22*r)/451), 
                m = (int) ((h+r-7*n+114)/31), 
                d = ((h+r-7*n+114)%31+1);        
        Calendar cal = new GregorianCalendar();
        
        if (region!=null && region!="") {
            uRegion=region.toUpperCase();
        }
        cal.set(Calendar.DAY_OF_MONTH, d);
        cal.set(Calendar.MONTH, m-1);
        cal.set(Calendar.YEAR, y); // jour de Paques
        cal.add(Calendar.DAY_OF_YEAR, -2); // vendredi saint
        jferie.setAnnee(annee);
        jferie.setPays(uPays);
        jferie.setRegion(uRegion);
        if (uPays.equals("FR") || uPays.equals("BE") || uPays.equals("DE")) {
            jferie.setDate(annee+"-01-01");
            jferie.setLabel("Jour de l'an");
            if (uPays.equals("DE")) {
                jferie.setLabel("Neujahrstag");
            }
            liste.add(jferie.clone()); // jour de l'an
        }
        if (uPays.equals("DE") && (uRegion.equals("BW") || uRegion.equals("BY") || uRegion.equals("ST"))) {
            jferie.setDate(annee+"-01-06");
            jferie.setLabel("Heilige Drei K?nige");
            liste.add(jferie.clone()); // Epiphanie - Fete des rois          
        }
        jferie.setDate(new java.sql.Date(cal.getTimeInMillis()).toString());
        jferie.setLabel("Karfreitag"); // vendredi saint
        if (uPays.equals("DE")) {
            liste.add(jferie.clone());
        }
        cal.add(Calendar.DAY_OF_YEAR, 3);
        jferie.setDate(new java.sql.Date(cal.getTimeInMillis()).toString());
        jferie.setLabel("Paques");
        if (uPays.equals("FR") || uPays.equals("BE") || uPays.equals("DE")) {
            if (uPays.equals("DE")) {
                jferie.setLabel("Ostermontag");
            }
            liste.add(jferie.clone()); // Paques
        }
        if (uPays.equals("FR") || uPays.equals("BE") || uPays.equals("DE")) {
            jferie.setDate(annee+"-05-01");
            jferie.setLabel("fete du travail");
            if (uPays.equals("DE")) {
                jferie.setLabel("Tag der Arbeit");
            }
            liste.add(jferie.clone()); // 1er mai - fete du travail
        }
        if (uPays.equals("FR")) {
            jferie.setDate(annee+"-05-08");
            jferie.setLabel("armistice 1945");
            liste.add(jferie.clone()); // 8 mai - armistice 1945
        }
        cal.add(Calendar.DAY_OF_YEAR, 39);
        jferie.setDate(new java.sql.Date(cal.getTimeInMillis()).toString());
        jferie.setLabel("Ascension");
        if (uPays.equals("DE")) {
            jferie.setLabel("Christi Himmelfahrt");
        }
        if (uPays.equals("FR") || uPays.equals("BE") || uPays.equals("DE") ) {
            liste.add(jferie.clone()); // Ascension
        }
        cal.add(Calendar.DAY_OF_YEAR, 11);
        jferie.setDate(new java.sql.Date(cal.getTimeInMillis()).toString());
        jferie.setLabel("Pentecote");
        if (uPays.equals("DE")) {
            jferie.setLabel("Pfingstmontag");
        }
        if (uPays.equals("FR") || uPays.equals("BE") || uPays.equals("DE")) {
            liste.add(jferie.clone()); // Pentecote        
        }
        cal.add(Calendar.DAY_OF_YEAR, 11);
        jferie.setDate(new java.sql.Date(cal.getTimeInMillis()).toString());
        jferie.setLabel("Fronleichnam");
        if (uPays.equals("DE") && (uRegion.equals("BW") || uRegion.equals("BY") 
                || uRegion.equals("HE") || uRegion.equals("NW") || uRegion.equals("RP")
                || uRegion.equals("SL"))) {
            liste.add(jferie.clone()); // Fete Dieu
        }
        if (uPays.equals("FR")) {
            jferie.setDate(annee+"-07-14");
            jferie.setLabel("fete nationale");
            liste.add(jferie.clone()); // Fete nationale fran?aise
        }
        if (uPays.equals("FR") || uPays.equals("BE")) {
            jferie.setDate(annee+"-07-21");
            jferie.setLabel("fete nationale"); // Fete nationale belge
            liste.add(jferie.clone());
        }
        if (uPays.equals("FR") || uPays.equals("BE") || (uPays.equals("DE") && uRegion.equals("SL"))) {
            jferie.setDate(annee+"-08-15");
            jferie.setLabel("Assomption");
            if (uPays.equals("DE")) {
                jferie.setLabel("Mari? Himmelfahrt");
            }
            liste.add(jferie.clone()); // Assomption
        }
        if (uPays.equals("DE")) {
            jferie.setDate(annee+"-10-03");
            jferie.setLabel("Tag der Deutschen Einheit");
            liste.add(jferie.clone()); // jour de l'unite allemande
        }
        if (uPays.equals("DE") && (uRegion.equals("BB") || uRegion.equals("MV") ||
                uRegion.equals("SN") || uRegion.equals("ST") || uRegion.equals("TH"))) {
            jferie.setDate(annee+"-10-31");
            jferie.setLabel("Reformationstag"); // jour de la reformation
            liste.add(jferie.clone());
        }
        if (uPays.equals("FR") || uPays.equals("BE") || (uPays.equals("DE") && 
                (uRegion.equals("BW") || uRegion.equals("BY") || uRegion.equals("NW") ||
                uRegion.equals("RP") || uRegion.equals("SL")))) { // Allemagne, selon region
            jferie.setDate(annee+"-11-01");
            jferie.setLabel("Toussaint");
            if (uPays.equals("DE")) {
                jferie.setLabel("Allerheiligen");
            }
            liste.add(jferie.clone()); // Toussaint
        }
        if (uPays.equals("FR") || uPays.equals("BE")) {
            jferie.setDate(annee+"-11-11");
            jferie.setLabel("armistice 1918");
            liste.add(jferie.clone()); // 11 novembre - armistice 1918
        }
        if (uPays.equals("DE") && uRegion.equals("SN")) {
            jferie.setLabel("Bu?- und Bettag");
            cal.set(Calendar.DAY_OF_MONTH, 22);
            cal.set(Calendar.MONTH, 11);
            while (cal.get(Calendar.DAY_OF_WEEK)!=Calendar.WEDNESDAY) {
                cal.add(Calendar.DAY_OF_YEAR, -1);
            }
            jferie.setDate(new java.sql.Date(cal.getTimeInMillis()).toString());
        } // Mercredi avant le 23 novembre, jour de penitences et de prieres
        if (uPays.equals("FR") || uPays.equals("BE") || uPays.equals("DE")) {
            jferie.setDate(annee+"-12-25");
            jferie.setLabel("Noel");
            if (uPays.equals("DE")) {
                jferie.setLabel("Weihnachtstag");
            }
            liste.add(jferie.clone()); // Noel
        }
        if (uPays.equals("DE")) {
            jferie.setDate(annee+"-12-26");
            jferie.setLabel("Zweiter Weihnachtsfeiertag");
            liste.add(jferie.clone()); // lendemain de No?l
        }
        return liste;
    }
    
    /**
     * Retourne la liste des jours feries de l'annee pour le pays par defaut
     * 
     * @param annee
     * @return
     * @throws CloneNotSupportedException
     */
    @Exclude
    public ArrayList feries(int annee) throws CloneNotSupportedException {
        
        return feries(annee, "fr");
    }
    
    @Exclude
    public ArrayList feries (String debut, String fin) throws CloneNotSupportedException {
        return feries(java.sql.Date.valueOf(debut),java.sql.Date.valueOf(fin));
    }
        
    @Exclude
    public ArrayList feries (Date debut, Date fin) throws CloneNotSupportedException {
        
        JourFerie ferie = new JourFerie();
        Calendar cal=new GregorianCalendar();
        cal.setTime(debut);
        int aDebut = cal.get(Calendar.YEAR);
        cal.setTime(fin);
        int aFin = cal.get(Calendar.YEAR);
        ArrayList liste = new ArrayList();
        ArrayList listeAnnee = new ArrayList();
        for (int i = aDebut; i <= aFin ; i++) {
            listeAnnee = feries(i);
            for (Iterator it = listeAnnee.iterator(); it.hasNext();) {
                ferie = (JourFerie) it.next();
                if ((ferie.getJour().after(debut) && 
                    (ferie.getJour().before(fin)) || 
                     ferie.getJour().equals(debut) || 
                     ferie.getJour().equals(fin)))
                     {
                    liste.add(ferie);
                }
            }
        }        
        return liste;
    }

    @Exclude
    public Boolean isFerie(Date date) throws CloneNotSupportedException {
        ArrayList liste = new ArrayList();
        Calendar cal=new GregorianCalendar();
        cal.setTime(date);
        liste = feries(cal.get(Calendar.YEAR));
        return liste.contains(date);
    }
    
    @Exclude
    public Boolean isFerie(String date, String pays) throws CloneNotSupportedException {
        return isFerie(Date.valueOf(date),pays);
    }
    
    @Exclude
    public Boolean isFerie(Calendar date, String pays) throws CloneNotSupportedException {
        return isFerie(new Date(date.getTime().getTime()),pays);
    }
    
    @Exclude
    public Boolean isFerie(Date date, String pays) throws CloneNotSupportedException {
        ArrayList liste = new ArrayList();
        Calendar cal=new GregorianCalendar();
        cal.setTime(date);
        liste = feries(cal.get(Calendar.YEAR), pays);
        return (liste.contains(date) && liste.contains(pays));
    }

    @Exclude
    public int joursOuvrables(Calendar debut, Calendar fin) throws CloneNotSupportedException {
        return joursOuvrables(new Date(debut.getTime().getTime()),new Date(fin.getTime().getTime()));
    }
    
    /**
     * Retourne le nombre de jours ouvrables entre deux dates
     * 
     * @param String debut (aaaa-MM-dd)
     * @param String fin (aaaa-MM-dd)
     * @return
     * @throws CloneNotSupportedException
     */
    @Exclude
    public int joursOuvrables(String debut, String fin) throws CloneNotSupportedException {
        return joursOuvrables(java.sql.Date.valueOf(debut),java.sql.Date.valueOf(fin));
    }
    
    /**
     * Retourne le nombre de jours ouvrables entre deux dates
     * 
     * @param java.sql.Date debut
     * @param java.sql.Date fin
     * @return nombre de jours ouvrables
     * @throws CloneNotSupportedException
     */
    @Exclude
    public int joursOuvrables(Date debut, Date fin) throws CloneNotSupportedException {
        int c=0;
        Date f;
        GregorianCalendar d = new java.util.GregorianCalendar();
        d.setTime(debut);
        
        do {
            if (!isFerie(new Date(d.getTime().getTime())) && 
               (d.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY)) {
                    c++;
            }
            d.add(Calendar.DAY_OF_YEAR, 1);
            f=new Date(d.getTime().getTime());
        } 
        while (!f.after(fin));
        return c;
    }

    @Exclude
    public int joursOuvres(Calendar debut, Calendar fin) throws CloneNotSupportedException {
        return joursOuvres(new Date(debut.getTime().getTime()),new Date(fin.getTime().getTime()));
    }
    
    /**
     *
     * @param String debut (aaaa-MM-dd)
     * @param String fin (aaaa-MM-dd)
     * @return nombre de jours ouvres
     * @throws CloneNotSupportedException
     */
    @Exclude
    public int joursOuvres(String debut, String fin) throws CloneNotSupportedException {
        return joursOuvres(java.sql.Date.valueOf(debut),java.sql.Date.valueOf(fin));
    }
    
    /**
     *
     * @param Date debut
     * @param Date fin
     * @return nombre de jours ouvres
     * @throws CloneNotSupportedException
     */
    @Exclude
    public int joursOuvres(Date debut, Date fin) throws CloneNotSupportedException {
        int c=0;
        Date f;
        GregorianCalendar d = new java.util.GregorianCalendar();
        d.setTime(debut);
        
        do {
            if (!isFerie(new Date(d.getTime().getTime())) && 
               (d.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY) &&
               (d.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY)) {
                    c++;
            }
            d.add(Calendar.DAY_OF_YEAR, 1);
            f=new Date(d.getTime().getTime());
        } 
        while (!f.after(fin));
        return c;
    }
}
