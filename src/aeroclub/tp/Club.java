/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeroclub.tp;

/**
 *
 * @author Camille
 */
public class Club {
    private static String nom;
    private static int nbMembre;
    private static int nbAvion;
    private static int nbMission;
    private static double tresorerie;
    
    public Club(String nom) {
        this.setNom(nom);
        this.setNbAvion(0);
        this.setNbMembre(0);
        this.setTresorerie(0);
    }

    /**
     * @return the nom
     */
    public static String getNom() {
        return nom;
    }

    /**
     * @param aNom the nom to set
     */
    public static void setNom(String aNom) {
        nom = aNom;
    }

    /**
     * @return the nbMembre
     */
    public static int getNbMembre() {
        return nbMembre;
    }

    /**
     * @param aNbMembre the nbMembre to set
     */
    public static void setNbMembre(int aNbMembre) {
        nbMembre = aNbMembre;
    }

    /**
     * @return the nbAvion
     */
    public static int getNbAvion() {
        return nbAvion;
    }

    /**
     * @param aNbAvion the nbAvion to set
     */
    public static void setNbAvion(int aNbAvion) {
        nbAvion = aNbAvion;
    }

    /**
     * @return the nbMission
     */
    public static int getNbMission() {
        return nbMission;
    }

    /**
     * @param aNbMission the nbMission to set
     */
    public static void setNbMission(int aNbMission) {
        nbMission = aNbMission;
    }

    /**
     * @return the tresorerie
     */
    public static double getTresorerie() {
        return tresorerie;
    }

    /**
     * @param aTresorerie the tresorerie to set
     */
    public static void setTresorerie(double aTresorerie) {
        tresorerie = aTresorerie;
    }
    
    public static void bilanClub() {
        System.out.println("Nombre de membre(s) : "+getNbMembre()+"\nNombre d'avion(s) : "+getNbAvion()+"\nNombre de mission(s) : "+getNbMission()+"\nTrésorerie : "+getTresorerie()+"€");
    }
}
