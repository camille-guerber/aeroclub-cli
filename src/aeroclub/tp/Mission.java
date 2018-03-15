/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeroclub.tp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Camille
 */
public class Mission {
    
    private static ArrayList<Mission> Missions = new ArrayList<Mission>();
    private Calendar dateDepart;
    private Calendar dateRetour;
    private int nbAtterrissage;
    private double coutMission;
    private Usager usager;
    private Avion avion;
    
    public Mission(Avion a, Usager u, Calendar dd, Calendar dr, int nbA) {
        if(dd.before(dr) && (nbA>=0) && (u.isIsMembre() == true)) {
            // Pour la mission
            this.setAvion(a);
            this.setUsager(u);
            this.setDateDepart(dd);
            this.setDateRetour(dr);
            this.setNbAtterrissage(nbA);
            this.setCoutMission(this.calculCoutMission(a, dd, dr));
            Missions.add(this);
            // Mise à jour de l'avion
            a.setNbMission(a.getNbMission()+1);
            a.setNbAtterrissage(a.getNbAtterrissage()+nbA);
            long diff = dr.getTimeInMillis() - dd.getTimeInMillis();
            int M = (int)diff/1000/60;
            a.setTempsVol(a.getTempsVol()+M);
            a.setNbVol(a.getNbVol()+nbA);
            // Mise à jour de l'usager
            u.setTempsVol(M);
            u.setNombreMission(u.getNombreMission()+1);
            u.setTotalDepenseMission(u.getTotalDepenseMission()+this.calculCoutMission(a, dd, dr));
            // Mise à jour du Club
            Club.setNbMission(Club.getNbMission()+1);
            Club.setTresorerie(Club.getTresorerie()+this.calculCoutMission(a, dd, dr));
            System.out.println("Mission bien crée");
        } else {
            System.out.println("Erreur formulaire sur les dates ou usager non inscrit !");
        }
    }
    
    @Override
    public String toString() {
        return "Avion : "+this.getAvion().getMarque()+"\nUsager : "+this.getUsager().getNom_Usager()+"\n"+this.getFormatedDate()+"\nNombre atterrissage(s) : "+this.getNbAtterrissage()+"\nCout mission : "+this.getCoutMission()+" €";
    }
    
    public double calculCoutMission(Avion a, Calendar dd, Calendar dr) {
        double diffMillis = dr.getTimeInMillis() - dd.getTimeInMillis();
        double diffHours = diffMillis / (60 * 60 * 1000);
        return diffHours*a.getCoutHoraire();
    }
    
    public String getFormatedDate() {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return "Date départ : "+formater.format(this.getDateDepart().getTime())+"\nDate retour : "+formater.format(this.getDateRetour().getTime());
    }
    /**
     * @return the Missions
     */
    public static ArrayList<Mission> getMissions() {
        return Missions;
    }

    /**
     * @param aMissions the Missions to set
     */
    public static void setMissions(ArrayList<Mission> aMissions) {
        Missions = aMissions;
    }

    /**
     * @return the dateDepart
     */
    public Calendar getDateDepart() {
        return dateDepart;
    }

    /**
     * @param dateDepart the dateDepart to set
     */
    public void setDateDepart(Calendar dateDepart) {
        this.dateDepart = dateDepart;
    }

    /**
     * @return the dateRetour
     */
    public Calendar getDateRetour() {
        return dateRetour;
    }

    /**
     * @param dateRetour the dateRetour to set
     */
    public void setDateRetour(Calendar dateRetour) {
        this.dateRetour = dateRetour;
    }

    /**
     * @return the nbAtterrissage
     */
    public int getNbAtterrissage() {
        return nbAtterrissage;
    }

    /**
     * @param nbAtterrissage the nbAtterrissage to set
     */
    public void setNbAtterrissage(int nbAtterrissage) {
        this.nbAtterrissage = nbAtterrissage;
    }

    /**
     * @return the coutMission
     */
    public double getCoutMission() {
        return coutMission;
    }

    /**
     * @param coutMission the coutMission to set
     */
    public void setCoutMission(double coutMission) {
        this.coutMission = coutMission;
    }

    /**
     * @return the usager
     */
    public Usager getUsager() {
        return usager;
    }

    /**
     * @param usager the usager to set
     */
    public void setUsager(Usager usager) {
        this.usager = usager;
    }

    /**
     * @return the avion
     */
    public Avion getAvion() {
        return avion;
    }

    /**
     * @param avion the avion to set
     */
    public void setAvion(Avion avion) {
        this.avion = avion;
    }
    
    public String getVolHeureMinute() {
        long diff = this.getDateRetour().getTimeInMillis() - this.getDateDepart().getTimeInMillis();
        int M = (int)diff/1000/60;
        int H = 0;
        if(M%60 == 0) {
            H = M/60;
            M = 0;
        } else {
            H = (int)(M/60);
            M = M%60;   
        }
        return H+"h"+M+"mn";
    }
    
    public void missionBilan() {
        System.out.println("Avion : "+this.getAvion().getMarque()+"\nMembre : "+this.getUsager().getNom_Usager()+"\nAtterrissages : "+this.getNbAtterrissage()+"\nTemps vol : "+this.getVolHeureMinute()+"\nCout : "+this.getCoutMission()+"€");
    }
    
}
