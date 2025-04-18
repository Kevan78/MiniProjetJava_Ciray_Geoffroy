package com.airline.model;

/**
 * Classe abstraite représentant une personne dans le système
 */
public abstract class Personne {
    private String nom;
    private String prenom;
    private String identifiant;
    private String adresse;
    private String contact;

    /**
     * Constructeur
     */
    public Personne(String identifiant, String nom, String prenom, String adresse, String contact) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.contact = contact;
    }

    /**
     * Getters et Setters
     */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Méthode qui retourne les informations de la personne
     */
    public String obtenirInfos() {
        return "Identifiant: " + identifiant +
                "\nNom: " + nom +
                "\nPrénom: " + prenom +
                "\nAdresse: " + adresse +
                "\nContact: " + contact;
    }
}