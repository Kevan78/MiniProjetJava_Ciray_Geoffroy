package com.airline.model;


public class Vol {


    private String numeroVol;
    private String origine;
    private String destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String etat;  //  ex: "Prévu", "En vol", "Terminé", "Annulé"

    // Constructeur
    public Vol(String numeroVol, String origine, String destination,
               String dateHeureDepart, String dateHeureArrivee) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.etat = "Prévu";  // État par défaut
    }

    // Getters et Setters
    public String getNumeroVol() {
        return numeroVol;
    }

    public void setNumeroVol(String numeroVol) {
        this.numeroVol = numeroVol;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDateHeureDepart() {
        return dateHeureDepart;
    }

    public void setDateHeureDepart(String dateHeureDepart) {
        this.dateHeureDepart = dateHeureDepart;
    }

    public String getDateHeureArrivee() {
        return dateHeureArrivee;
    }

    public void setDateHeureArrivee(String dateHeureArrivee) {
        this.dateHeureArrivee = dateHeureArrivee;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }


    public void planifierVol() {
        //planifier le vol
        this.etat = "Prévu";
        System.out.println("Vol " + numeroVol + " planifié avec succès.");
    }

    public void annulerVol() {
        //annule le vol
        this.etat = "Annulé";
        System.out.println("Vol " + numeroVol + " annulé.");
    }

    public void modifierVol(String origine, String destination,
                            String dateHeureDepart, String dateHeureArrivee) {
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        System.out.println("Vol " + numeroVol + " modifié avec succès.");
    }

    public String[] listingPassager() {
        // retourne liste des passagers pour ce vol
        return new String[]{"Liste des passagers pour le vol " + numeroVol};
    }

    @Override
    public String toString() {
        return "Vol{" +
                "numeroVol='" + numeroVol + '\'' +
                ", origine='" + origine + '\'' +
                ", destination='" + destination + '\'' +
                ", dateHeureDepart='" + dateHeureDepart + '\'' +
                ", dateHeureArrivee='" + dateHeureArrivee + '\'' +
                ", etat='" + etat + '\'' +
                '}';
    }
}