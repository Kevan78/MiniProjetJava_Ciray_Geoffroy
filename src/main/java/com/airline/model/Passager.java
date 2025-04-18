package com.airline.model;

public class Passager extends Personne {
    private String passeport;

    // Constructeur
    public Passager(String identifiant, String nom, String prenom, String adresse, String contact, String passeport) {
        super(identifiant, nom, prenom, adresse, contact); // Appel au nouveau constructeur de Personne
        this.passeport = passeport;
    }

    // Getters et Setters
    public String getPasseport() {
        return passeport;
    }

    public void setPasseport(String passeport) {
        this.passeport = passeport;
    }


    public boolean reserverVol(Vol vol, String dateReservation) {

        // Créer une nouvelle réservation et l'associer à ce passager
        Reservation reservation = new Reservation(
                generateReservationNumber(),
                dateReservation,
                "En attente",
                this,
                vol
        );

        System.out.println("Vol " + vol.getNumeroVol() + " réservé avec succès pour " +
                this.getNom() + " le " + dateReservation);
        return true;
    }

    public boolean annulerReservation(String numeroReservation) {


        System.out.println("Réservation " + numeroReservation + " annulée pour " + this.getNom());
        return true;
    }

    public Reservation[] obtenirReservations() {
        //retourne la liste des réservations pour ce passager

        System.out.println("Obtention des réservations pour " + this.getNom());
        return new Reservation[0];
    }

    //génére un numéro de réservation
    private String generateReservationNumber() {

        return "RES" + System.currentTimeMillis();
    }

    @Override
    public String obtenirInfos() {
        return super.obtenirInfos() + ", Passeport: " + passeport;
    }

    @Override
    public String toString() {
        return "Passager{" +
                super.toString() +
                ", passeport='" + passeport + '\'' +
                '}';
    }
}