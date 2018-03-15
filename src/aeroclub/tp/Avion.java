package aeroclub.tp;

import java.util.ArrayList;

public class Avion {
    private static ArrayList<Avion> Avions = new ArrayList<Avion>();
    private static int nbAvions = 0;
    private int nbMission;
    private int tempsVol;
    private int nbAtterrissage;
    private int nbVol;
    private String marque;
    private double coutHoraire;

    
    /***
     * Constructeur de la classe Avion
     * @param marque
     * @param coutH
     * @param tV
     * @param nbA 
     * @param nbV
     */
    public Avion(String marque, double coutH, int tV, int nbA, int nbV, int nbM) {
        if(this.checkUniqueMarque(marque) == false && (coutH > 0) && (tV >= 0) && (nbA >=0) && (nbV >=0) ) {
            // Avion
            this.setMarque(marque);
            this.setCoutHoraire(coutH);
            this.setTempsVol(tV);
            this.setNbAtterrissage(nbA);
            this.setNbVol(nbV);
            this.setNbMission(nbM);
            nbAvions ++;
            Avions.add(this);
            // Club
            Club.setNbAvion(Club.getNbAvion()+1);
            System.out.println("Avion bien crée");
        } else {
            System.out.println("Erreur veuillez entrer des valeurs coorectes !");
        }
    }
    
    @Override
    public String toString() {
        return "Marque : "+this.getMarque()+"\nCout horaire : "+this.getCoutHoraire()+"€\nTemps de vol : "+this.getTempsVolHeureMinute()+"\nNombre atterrissage(s) : "+this.getNbAtterrissage()+"\nNombre de vol(s) : "+this.getNbVol();
    }
    /**
     * @return la liste d'avions
     */
    public static ArrayList<Avion> getAvions() {
        return Avions;
    }
    
    /**
     * Affiche tous les avions de la liste Avions
     */
    public static void showAvionsList() {
        for(Avion avion: Avions) {
            System.out.println(avion);
        }
    }
    
    /**
     * 
     * @param marque
     * @return true si marque existe déjà dans la liste des avions sinon false
     */
    public boolean checkUniqueMarque(String marque) {
        for(Avion avion: Avions) {
            if(avion.getMarque() == marque) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return le nombres d'avions
     */
    public static int getNbAvions() {
        return nbAvions;
    }

    /**
     * @return la marque de l'avion
     */
    public String getMarque() {
        return marque;
    }

    /**
     * Setter marque
     * @param marque
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * @return the coutHoraire
     */
    public double getCoutHoraire() {
        return coutHoraire;
    }

    /**
     * @param coutHoraire the coutHoraire to set
     */
    public void setCoutHoraire(double coutHoraire) {
        this.coutHoraire = coutHoraire;
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
     * @return the nbVol
     */
    public int getNbVol() {
        return nbVol;
    }

    /**
     * @param nbVol the nbVol to set
     */
    public void setNbVol(int nbVol) {
        this.nbVol = nbVol;
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

    /**
     * @return the nbMission
     */
    public int getNbMission() {
        return nbMission;
    }

    /**
     * @param nbMission the nbMission to set
     */
    public void setNbMission(int nbMission) {
        this.nbMission = nbMission;
    }
    
    public void avionBilan() {
        System.out.println("***Bilan avion***\n"+"Référence : "+this.getMarque()+"\nTemps vol : "+this.getTempsVolHeureMinute()+"\nAtterrissages : "+this.getNbAtterrissage()+"\nMissions effectuées : "+this.getNbMission());
    }
}
