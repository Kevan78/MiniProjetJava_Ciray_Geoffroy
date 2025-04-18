package com.airline.model;

import java.util.Date;

/**
 * Classe représentant un employé de la compagnie aérienne
 */
public class Employe extends Personne {
    private Date dateEmbauche;
    private String poste;

    /**
     * Constructeur
     */
    public Employe(String identifiant, String nom, String prenom, String adresse, String contact,
                   Date dateEmbauche, String poste) {
        super(identifiant, nom, prenom, adresse, contact);
        this.dateEmbauche = dateEmbauche;
        this.poste = poste;
    }

    /**
     * Getters et Setters
     */
    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    /**
     * Méthode qui retourne le rôle de l'employé
     */
    public String obtenirRole() {
        return this.poste;
    }

    @Override
    public String obtenirInfos() {
        return super.obtenirInfos() +
                "\nDate d'embauche: " + dateEmbauche +
                "\nPoste: " + poste;
    }
}