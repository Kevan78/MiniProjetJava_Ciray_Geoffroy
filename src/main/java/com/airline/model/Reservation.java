package com.airline.model;


public class Reservation {
    private String numeroReservation;
    private String dateReservation;
    private String statut; //  ex: "Confirmée", "En attente", "Annulée"
    private Passager passager;
    private Vol vol;

    // Constructeur
    public Reservation(String numeroReservation, String dateReservation, String statut,
                       Passager passager, Vol vol) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = dateReservation;
        this.statut = statut;
        this.passager = passager;
        this.vol = vol;
    }

    // Getters et Setters
    public String getNumeroReservation() {
        return numeroReservation;
    }

    public void setNumeroReservation(String numeroReservation) {
        this.numeroReservation = numeroReservation;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Passager getPassager() {
        return passager;
    }

    public void setPassager(Passager passager) {
        this.passager = passager;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }


    public boolean confirmerReservation() {
        //confirme une réservation
        this.statut = "Confirmée";
        System.out.println("Réservation " + numeroReservation + " confirmée pour le passager " +
                passager.getNom() + " sur le vol " + vol.getNumeroVol());
        return true;
    }

    public boolean annulerReservation() {
        //annule une réservation
        this.statut = "Annulée";
        System.out.println("Réservation " + numeroReservation + " annulée pour le passager " +
                passager.getNom() + " sur le vol " + vol.getNumeroVol());
        return true;
    }

    public boolean modifierReservation(Vol nouveauVol, String nouvelleDateReservation) {
        // modifiie une réservation
        Vol ancienVol = this.vol;
        this.vol = nouveauVol;
        this.dateReservation = nouvelleDateReservation;
        System.out.println("Réservation " + numeroReservation + " modifiée pour le passager " +
                passager.getNom() + " du vol " + ancienVol.getNumeroVol() +
                " au vol " + nouveauVol.getNumeroVol());
        return true;
    }


    public static Reservation creerReservation(String numeroReservation, String dateReservation,
                                               String statut, Passager passager, Vol vol) {
        Reservation reservation = new Reservation(numeroReservation, dateReservation, statut, passager, vol);

        return reservation;
    }

    public static Reservation rechercherReservation(String numeroReservation) {

        System.out.println("Recherche de la réservation avec le numéro: " + numeroReservation);
        return null;
    }

    public boolean mettreAJour() {
        System.out.println("Mise à jour de la réservation: " + numeroReservation);
        return true;
    }

    public boolean supprimer() {
        System.out.println("Suppression de la réservation: " + numeroReservation);
        return true;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "numeroReservation='" + numeroReservation + '\'' +
                ", dateReservation='" + dateReservation + '\'' +
                ", statut='" + statut + '\'' +
                ", passager=" + passager.getNom() +
                ", vol=" + vol.getNumeroVol() +
                '}';
    }
}