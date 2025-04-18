// https://github.com/Kevan78/MiniProjetJava_Ciray_Geoffroy
package com.airline.model;
// TEST BRUT !!!!!
public class Main {
    public static void main(String[] args) {

        Aeroport paris = new Aeroport("CDG", "Paris", "Aéroport Charles de Gaulle");
        Aeroport newyork = new Aeroport("JFK", "New York", "Aéroport John F. Kennedy");

        Avion avion = new Avion("F-GSPQ", "Boeing 777-300ER", 350);

        Vol vol = new Vol("AF123", "Paris", "New York", "2024-04-18 08:00", "2024-04-18 20:00");

        Passager passager = new Passager("P002", "Marie Martin", "456 rue de Lyon", "+33987654321", "PAS123456", "AZERTY123"); // Ajout d'un exemple de numéro de passeport
        System.out.println(passager.obtenirInfos());

        avion.affecterVol(vol);

        String reservationID = "RES001";
        passager.reserverVol(vol, "2024-04-10");

        Reservation reservation = new Reservation(reservationID, "2024-04-10", "En attente", passager, vol);
        reservation.confirmerReservation();

        System.out.println(vol);
        System.out.println(reservation);
    }
}