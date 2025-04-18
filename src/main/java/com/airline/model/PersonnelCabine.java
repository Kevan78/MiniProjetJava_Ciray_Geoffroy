package com.airline.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe représentant un membre du personnel de cabine
 */
public class PersonnelCabine extends Employe {
    private String fonction; // hôtesse, chef de cabine, etc.
    private List<String> languesParlees;
    private List<Vol> volsAssignes;

    /**
     * Constructeur
     */
    public PersonnelCabine(String identifiant, String nom, String prenom, String adresse, String contact,
                           Date dateEmbauche, String fonction) {
        super(identifiant, nom, prenom, adresse, contact, dateEmbauche, "Personnel Cabine");
        this.fonction = fonction;
        this.languesParlees = new ArrayList<>();
        this.volsAssignes = new ArrayList<>();
    }

    /**
     * Getters et Setters
     */
    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public List<String> getLanguesParlees() {
        return languesParlees;
    }

    public void ajouterLangue(String langue) {
        this.languesParlees.add(langue);
    }

    public void supprimerLangue(String langue) {
        this.languesParlees.remove(langue);
    }

    public List<Vol> getVolsAssignes() {
        return volsAssignes;
    }

    /**
     * Méthode pour assigner un vol au personnel de cabine
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
        info.append("\nFonction: ").append(fonction);
        info.append("\nLangues parlées: ");
        for (String langue : languesParlees) {
            info.append(langue).append(", ");
        }
        return info.toString();
    }
}