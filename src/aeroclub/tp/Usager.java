package aeroclub.tp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Usager {
    private static ArrayList<Usager> Usagers = new ArrayList<Usager>();
    protected String nom_Usager;
    protected Calendar date_Inscription;
    private boolean isMembre;
    private int tempsVol;
    private int nombreMission;
    private double totalDepenseMission;
    
    public Usager(String nom) {
        if(checkUniqueNom(nom) == false) {
            Calendar date = Calendar.getInstance();
            this.setDate_Inscription(date);
            this.setNom_Usager(nom);
            this.setIsMembre(false);
            this.tempsVol = 0;
            this.nombreMission = 0;
            this.totalDepenseMission = 0;
            Usagers.add(this);
            System.out.println("Usager bien crée");
        } else {
            System.out.println("Erreur formulaire ou usager déjà existant !");
        }
    }
    
    @Override
    public String toString() {
        return "Nom : "+this.getNom_Usager()+" Membre : "+this.isIsMembre()+" Date inscription : Le "+this.getDateInscriptionMy();
    }
    
    public boolean checkUniqueNom(String nom) {
        for(Usager usager: getUsagers()) {
            if(usager.getNom_Usager() == nom) {
                return true;
            }
        }
        return false;
    }
    
    public void afficher_Usagers() {
        for(Usager usager: getUsagers()) {
            if(usager.isIsMembre() == false) {
                System.out.println(usager);
            }
        }
    }

    /**
     * @return the nom_Usager
     */
    public String getNom_Usager() {
        return nom_Usager;
    }

    /**
     * @param nom_Usager the nom_Usager to set
     */
    public void setNom_Usager(String nom_Usager) {
        this.nom_Usager = nom_Usager;
    }

    /**
     * @return the date_Inscription
     */
    public Calendar getDate_Inscription() {
        return date_Inscription;
    }
    
    public String getDateInscriptionMy() {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return formater.format(this.getDate_Inscription().getTime());      
    }

    /**
     * @param date_Inscription the date_Inscription to set
     */
    public void setDate_Inscription(Calendar date_Inscription) {
        this.date_Inscription = date_Inscription;
    }

    /**
     * @return the isMembre
     */
    public boolean isIsMembre() {
        return isMembre;
    }

    /**
     * @param isMembre the isMembre to set
     */
    public void setIsMembre(boolean isMembre) {
        this.isMembre = isMembre;
        if(isMembre == true) {
            Club.setNbMembre(Club.getNbMembre()+1);
            Club.setTresorerie(Club.getTresorerie()+70);
        }
    }

    /**
     * @return the Usagers
     */
    public static ArrayList<Usager> getUsagers() {
        return Usagers;
    }

    /**
     * @return the tempsVol
     */
    public int getTempsVol() {
        return tempsVol;
    }

    /**
     * @param tempsVol the tempsVol to set
     */
    public void setTempsVol(int tempsVol) {
        this.tempsVol = tempsVol;
    }

    /**
     * @return the nombreMission
     */
    public int getNombreMission() {
        return nombreMission;
    }

    /**
     * @param nombreMission the nombreMission to set
     */
    public void setNombreMission(int nombreMission) {
        this.nombreMission = nombreMission;
    }

    /**
     * @return the totalDepenseMission
     */
    public double getTotalDepenseMission() {
        return totalDepenseMission;
    }

    /**
     * @param totalDepenseMission the totalDepenseMission to set
     */
    public void setTotalDepenseMission(double totalDepenseMission) {
        this.totalDepenseMission = totalDepenseMission;
    }
    
    public String getTempsVolHeureMinute() {
        int H = 0;
        int M = this.getTempsVol();
        if(M%60 == 0) {
            H = M/60;
            M = 0;
        } else {
            H = (int)(M/60);
            M = M%60;   
        }
        return H+"h"+M+"mn";
    }
    
    public void usagerBilan() {
        System.out.println("Nombre de mission(s) : "+this.getNombreMission()+"\nTemps vol : "+this.getTempsVolHeureMinute()+"\nTotal payé : "+this.getTotalDepenseMission()+"€");
    }
}
