package com.airline.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe représentant un pilote de la compagnie aérienne
 */
public class Pilote extends Employe {
    private int heuresDeVol;
    private List<String> qualifications;
    private List<Vol> volsAssignes;

    /**
     * Constructeur
     */
    public Pilote(String identifiant, String nom, String prenom, String adresse, String contact,
                  Date dateEmbauche, int heuresDeVol) {
        super(identifiant, nom, prenom, adresse, contact, dateEmbauche, "Pilote");
        this.heuresDeVol = heuresDeVol;
        this.qualifications = new ArrayList<>();
        this.volsAssignes = new ArrayList<>();
    }

    /**
     * Getters et Setters
     */
    public int getHeuresDeVol() {
        return heuresDeVol;
    }

    public void setHeuresDeVol(int heuresDeVol) {
        this.heuresDeVol = heuresDeVol;
    }

    public List<String> getQualifications() {
        return qualifications;
    }

    public void ajouterQualification(String qualification) {
        this.qualifications.add(qualification);
    }

    public void supprimerQualification(String qualification) {
        this.qualifications.remove(qualification);
    }

    public List<Vol> getVolsAssignes() {
        return volsAssignes;
    }

    /**
     * Méthode pour assigner un vol au pilote
     */
    public void assignerVol(Vol vol) {
        if (!volsAssignes.contains(vol)) {
            volsAssignes.add(vol);
        }
    }

    /**
     * Méthode pour retirer un vol assigné
     */
    public void retirerVol(Vol vol) {
        volsAssignes.remove(vol);
    }

    @Override
    public String obtenirInfos() {
        StringBuilder info = new StringBuilder(super.obtenirInfos());
        info.append("\nHeures de vol: ").append(heuresDeVol);
        info.append("\nQualifications: ");
        for (String qualification : qualifications) {
            info.append(qualification).append(", ");
        }
        return info.toString();
    }
}