package com.airline.model;


public class Aeroport {
    private String nom;
    private String ville;
    private String description;

    // Constructeur
    public Aeroport(String nom, String ville, String description) {
        this.nom = nom;
        this.ville = ville;
        this.description = description;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean affecterVol(Vol vol) {

        return true;
    }

    @Override
    public String toString() {
        return "Aeroport{" +
                "nom='" + nom + '\'' +
                ", ville='" + ville + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}