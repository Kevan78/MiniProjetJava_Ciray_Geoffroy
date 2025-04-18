package com.airline.model;
import java.util.Date;


public class Avion {
    private String immatriculation;
    private String modele;
    private int capacite;

    // Constructeur
    public Avion(String immatriculation, String modele, int capacite) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.capacite = capacite;
    }

    // Getters et Setters
    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }


    public boolean affecterVol(Vol vol) {

        if (verifierDisponibilite(vol.getDateHeureDepart(), vol.getDateHeureArrivee())) {

            return true;
        }
        return false;
    }

    public boolean verifierDisponibilite(String ureDepart, String ureArrivee) {
        // vérifie si l'avion est disponible pendant la période spécifiée

        return true; // Placeholder
    }

    @Override
    public String toString() {
        return "Avion{" +
                "immatriculation='" + immatriculation + '\'' +
                ", modele='" + modele + '\'' +
                ", capacite=" + capacite +
                '}';
    }
}