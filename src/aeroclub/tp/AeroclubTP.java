package aeroclub.tp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.StringTokenizer;

public class AeroclubTP {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Club
        Scanner sc = new Scanner(System.in);
        //Avion Cessna = new Avion("Cessna", 12.5, 0, 0, 0, 0);
        //Avion Pipper = new Avion("Pipper", 22.9, 0, 0, 0, 0);
        //Avion Rafale = new Avion("Rafale", 102.6, 0, 0, 0, 0);
        //Usager Camille = new Usager("Camille");
        //Usager Cesar = new Usager("César");
        //Usager Paul = new Usager("Paul");
        //Camille.setIsMembre(true);
        
        // Menu gestion du club
        int reponse = 0;
        while(reponse != 9) {
            System.out.println("***Gestion du Club***");
            System.out.println("[1]: Ajouter un usager");
            System.out.println("[2]: Inscrire un usager");
            System.out.println("[3]: Ajouter un avion");
            System.out.println("[4]: Ajouter une mission");
            System.out.println("[5]: Bilan du Club");
            System.out.println("[6]: Bilan d'une mission");
            System.out.println("[7]: Bilan d'un membre");
            System.out.println("[8]: Bilan d'un avion");
            System.out.println("[9]: Sortir");
            System.out.print("Votre choix : ");
            try {
                reponse = Integer.parseInt(sc.nextLine());  
            } catch(Exception e) {
                System.out.println(e);
                System.out.print("Appuyez sur une touche pour continuer : ");
                sc.nextLine();
            }
            
            switch(reponse) {
                case 1:
                    usagerAdd();
                break;
                case 2:
                    membreAdd();
                break;
                case 3:
                    avionAdd();
                break;
                case 4:
                    missionAdd();
                break;
                case 5:
                    clubBilan();
                break;
                case 6:
                    missionBilan();
                break;
                case 7:
                    membreBilan();
                break;
                case 8:
                    avionBilan();
                break;
                case 9:
                break;
                default:
                    System.out.println("Veuillez choisir une valeur correcte");
                break;
            }
        }
    }
    // Gestion des avions //
    public static void avionAdd() {
        Scanner sc = new Scanner(System.in);
        float cH;
        int nbV, nbA, nbM, tV, mV;
        String marque;
        try {
            System.out.println("Menu d'ajout d'un avion");                    
            System.out.print("Marque : ");
            marque = sc.nextLine();
            System.out.print("cout horaire : ");
            cH = Float.parseFloat(sc.nextLine());
            System.out.print("temps de vol (Minutes) : ");
            tV = Integer.parseInt(sc.nextLine());
            System.out.print("nombre d'atterissages : ");
            nbA = Integer.parseInt(sc.nextLine());
            System.out.print("nombre de missions : ");
            nbM = Integer.parseInt(sc.nextLine());
            System.out.print("nombre de vols : ");
            nbV = Integer.parseInt(sc.nextLine());
            new Avion(marque, cH, tV, nbA, nbV, nbM);            
        } catch(Exception e) {
            System.out.println("Erreur : valeurs invalides");
            System.out.println(e);
        }
        System.out.print("Appuyez sur une touche pour continuer");
        sc.nextLine();
    }
    
    public static void avionBilan() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Avion> Avions = Avion.getAvions();
        if(!Avions.isEmpty()) {
            for(Avion avion: Avions) {
                System.out.println(Avions.indexOf(avion)+" - "+avion.getMarque());
            }
            System.out.print("Choisissez un avion (numéro) : ");
            int avionIndex = Integer.parseInt(sc.nextLine());
            try {
                Avion avion = Avions.get(avionIndex);
                avion.avionBilan();                 
            } catch(Exception e) {
                System.out.println("Erreur ! Mauvais numéro");
                System.out.println(e);
            }       
        } else {
            System.out.println("Aucun avion pour le moment");
        }
        System.out.print("Appuyez sur une touche pour continuer");
        sc.nextLine();
    }
    
    // Gestion des usagers //
    public static void usagerAdd() {
        Scanner sc = new Scanner(System.in);
        String nom;
        try {
            System.out.println("Menu d'ajout d'un usager");                    
            System.out.print("Nom : ");
            nom = sc.nextLine();
            Usager a = new Usager(nom);           
        } catch(Exception e) {
            System.out.println("Erreur : formulaire invalide");
            System.out.println(e);
        }
        System.out.print("Appuyez sur une touche pour continuer");
        sc.nextLine();
    }
    
    public static void membreAdd() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Usager> Usagers = Usager.getUsagers();
        if(!Usagers.isEmpty()) {
            for(Usager usager: Usagers) {
                if(usager.isIsMembre() == false) {
                    System.out.println("["+Usagers.indexOf(usager)+"] "+usager.getNom_Usager());
                }
            }
            System.out.print("Choisir un usager (numéro) : ");
            try {
                int usagerIndex = Integer.parseInt(sc.nextLine());
                Usager usager = Usagers.get(usagerIndex);
                usager.setIsMembre(true);
                System.out.println(usager.getNom_Usager()+" est désormais membre.");              
            } catch(Exception e) {
                System.out.println("Erreur ! Mauvais numéro");
                System.out.println(e);
            }
        } else {
           System.out.println("Aucun usager à inscrire pour le moment"); 
        }
        System.out.print("Appuyez sur une touche pour continuer");
        sc.nextLine();
    }

    public static void membreBilan() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Usager> Usagers = Usager.getUsagers();
        if(!Usagers.isEmpty()) {
            for(Usager usager: Usagers) {
                if(usager.isIsMembre() == true) {
                   System.out.println(Usagers.indexOf(usager)+" - "+usager.getNom_Usager());
                }
            }
            System.out.print("Choisissez une mission (numéro) : ");
            try {
                int usagerIndex = Integer.parseInt(sc.nextLine());
                Usager usager = Usagers.get(usagerIndex);
                usager.usagerBilan();          
            } catch(Exception e) {
                System.out.println("Erreur ! Mauvais numéro");
                System.out.println(e);
            }
        } else {
            System.out.println("Aucun membre pour le moment");
        }
        System.out.print("Appuyez sur une touche pour continuer");
        sc.nextLine();
    }
    
    // Gestion des missions //
    public static void missionAdd() {
        
        ArrayList<Avion> Avions = Avion.getAvions();
        ArrayList<Usager> Usagers = Usager.getUsagers();
        Calendar dateDepart = Calendar.getInstance();
        Calendar dateRetour = Calendar.getInstance();
        dateDepart.clear();dateRetour.clear();
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu ajout mission");
        // Date de départ
        System.out.print("Date départ (DD/MM/YYYY/hh/mm) ex(31/12/2017/15/30) : ");
        String dd = sc.nextLine();
        StringTokenizer tabDD = new StringTokenizer(dd, "/");
        int day = Integer.parseInt(tabDD.nextToken());
        int month = Integer.parseInt(tabDD.nextToken());
        int year = Integer.parseInt(tabDD.nextToken());
        int hour = Integer.parseInt(tabDD.nextToken());
        int minute = Integer.parseInt(tabDD.nextToken());
        dateDepart.set(Calendar.YEAR, year);dateDepart.set(Calendar.MONTH, month-1);dateDepart.set(Calendar.DAY_OF_MONTH, day);dateDepart.set(Calendar.HOUR_OF_DAY, hour);dateDepart.set(Calendar.MINUTE, minute);
        // Date de retour
        System.out.print("Date retour (DD/MM/YYYY/hh/mm) ex(31/12/2017/15/30) : ");
        String dr = sc.nextLine();
        StringTokenizer tabDR = new StringTokenizer(dr, "/");
        int dayR = Integer.parseInt(tabDR.nextToken());
        int monthR = Integer.parseInt(tabDR.nextToken());
        int yearR = Integer.parseInt(tabDR.nextToken());
        int hourR = Integer.parseInt(tabDR.nextToken());
        int minuteR = Integer.parseInt(tabDR.nextToken());
        dateRetour.set(Calendar.YEAR, yearR);dateRetour.set(Calendar.MONTH, monthR-1);dateRetour.set(Calendar.DAY_OF_MONTH, dayR);dateRetour.set(Calendar.HOUR_OF_DAY, hourR);dateRetour.set(Calendar.MINUTE, minuteR);
        System.out.print("Nombre d'atterissages prévus : ");
        int nbA = Integer.parseInt(sc.nextLine());
        // Si listes avions et membres non vides
        if(!Avions.isEmpty() && !Usagers.isEmpty()) {
            try {
            // Choix de l'avion
            for(Avion avion: Avions) {
                System.out.println(Avions.indexOf(avion)+" "+avion.getMarque());
            }
            System.out.print("Choisissez un avion (numéro) : ");
            int avionIndex = Integer.parseInt(sc.nextLine());
            // Choix de l'usager
            for(Usager usager: Usagers) {
                if(usager.isIsMembre() == true) {
                    System.out.println(Usagers.indexOf(usager)+" "+usager.getNom_Usager());
                }
            }
            System.out.print("Choisissez un membre (numéro) : ");
            int usagerIndex = Integer.parseInt(sc.nextLine());
               Avion avion = Avions.get(avionIndex);
               Usager usager = Usagers.get(usagerIndex);
               Mission mission = new Mission(avion, usager, dateDepart, dateRetour, nbA);
            } catch(Exception e) {
                System.out.println("Erreur ! Mauvais numéro");
                System.out.println(e);
            }          
        } else {
            System.out.println("Aucun membre ou avion pour créer une mission pour le moment");
        }
        System.out.print("Appuyez sur une touche pour continuer");
        sc.nextLine();
    }
    
    public static void missionBilan() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Mission> Missions = Mission.getMissions();
        if(!Missions.isEmpty()) {
            for(Mission mission: Missions) {
                System.out.println(Missions.indexOf(mission)+" - "+mission.getUsager().getNom_Usager());
            }
            System.out.print("Choisissez une mission (numéro) : ");
            try {
                int missionIndex = Integer.parseInt(sc.nextLine());
                Mission mission = Missions.get(missionIndex);
                mission.missionBilan();               
            } catch(Exception e) {
                System.out.println("Erreur ! Mauvais numéro");
                System.out.println(e);
            }
        } else {
            System.out.println("Aucune mission pour le moment");
        }
        System.out.print("Appuyez sur une touche pour continuer");
        sc.nextLine();
    }
    
    // Gestion du club //
    public static void clubBilan() {
        Scanner sc = new Scanner(System.in);
        Club.bilanClub();
        System.out.print("Appuyez sur une touche pour continuer");
        sc.nextLine();
    }
}
