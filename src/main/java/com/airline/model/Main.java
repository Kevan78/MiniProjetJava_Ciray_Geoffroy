


package com.airline.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        try {
            // Chemins des fichiers avec chemin relatif corrigé
            String cheminAeroports = "src/data/aeroports.txt";
            String cheminAvions = "src/data/avions.txt";
            String cheminVols = "src/data/vols.txt";
            String cheminPassagers = "src/data/passagers.txt";

            // Charger les données depuis des fichiers
            List<Aeroport> aeroports = chargerAeroports(cheminAeroports);
            List<Avion> avions = chargerAvions(cheminAvions);
            List<Vol> vols = chargerVols(cheminVols);
            List<Passager> passagers = chargerPassagers(cheminPassagers);

            // Afficher les données chargées
            System.out.println("=== AÉROPORTS CHARGÉS ===");
            for (Aeroport aeroport : aeroports) {
                System.out.println(aeroport);
            }

            System.out.println("\n=== AVIONS CHARGÉS ===");
            for (Avion avion : avions) {
                System.out.println(avion);
            }

            System.out.println("\n=== VOLS CHARGÉS ===");
            for (Vol vol : vols) {
                System.out.println(vol);
            }

            System.out.println("\n=== PASSAGERS CHARGÉS ===");
            for (Passager passager : passagers) {
                System.out.println(passager.obtenirInfos());
            }

            // Exemple d'utilisation des données chargées
            if (!avions.isEmpty() && !vols.isEmpty()) {
                Avion premierAvion = avions.get(0);
                Vol premierVol = vols.get(0);
                premierAvion.affecterVol(premierVol);
                System.out.println("\nVol " + premierVol.getNumeroVol() + " affecté à l'avion " + premierAvion.getImmatriculation());
            }

            if (!passagers.isEmpty() && !vols.isEmpty()) {
                String dateReservation = "2024-04-10";
                Passager premierPassager = passagers.get(0);
                Vol premierVol = vols.get(0);

                premierPassager.reserverVol(premierVol, dateReservation);

                String reservationID = "RES" + premierPassager.getIdentifiant() + premierVol.getNumeroVol();
                Reservation reservation = new Reservation(reservationID, dateReservation, "En attente", premierPassager, premierVol);
                reservation.confirmerReservation();

                System.out.println("\n=== RÉSERVATION CRÉÉE ===");
                System.out.println(reservation);

                // Exemple d'écriture dans un fichier

                ajouterAeroport("src/data/aeroports.txt", new Aeroport("ICN", "Incheon", "Aéroport International d'Incheon")); // Ajout du meilleur aeroport
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture/écriture des fichiers : " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static List<Aeroport> chargerAeroports(String fichier) throws IOException {
        List<Aeroport> aeroports = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parts = ligne.split(",");
                if (parts.length >= 3) {
                    aeroports.add(new Aeroport(parts[0], parts[1], parts[2]));
                }
            }
        }
        return aeroports;
    }

    private static List<Avion> chargerAvions(String fichier) throws IOException {
        List<Avion> avions = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(fichier))) {
            lines.forEach(ligne -> {
                String[] parts = ligne.split(",");
                if (parts.length >= 3) {
                    try {
                        int capacite = Integer.parseInt(parts[2]);
                        avions.add(new Avion(parts[0], parts[1], capacite));
                    } catch (NumberFormatException e) {
                        System.err.println("Erreur de format pour la capacité de l'avion : " + ligne);
                    }
                }
            });
        }
        return avions;
    }

    private static List<Vol> chargerVols(String fichier) throws IOException {
        List<Vol> vols = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(fichier));
        for (String ligne : lines) {
            String[] parts = ligne.split(",");
            if (parts.length >= 5) {
                vols.add(new Vol(parts[0], parts[1], parts[2], parts[3], parts[4]));
            }
        }
        return vols;
    }

    private static List<Passager> chargerPassagers(String fichier) throws IOException {
        List<Passager> passagers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fichier))) {
            while (scanner.hasNextLine()) {
                String ligne = scanner.nextLine();
                String[] parts = ligne.split(",");
                if (parts.length >= 6) {
                    passagers.add(new Passager(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
                }
            }
        }
        return passagers;
    }



    // Méthode pour ajouter un aéroport au fichier (avec Files.write)
    private static void ajouterAeroport(String cheminFichier, Aeroport aeroport) throws IOException {
        Path path = Paths.get(cheminFichier);
        String contenu = aeroport.getNom() + "," + aeroport.getVille() + "," + aeroport.getDescription() + System.lineSeparator();
        Files.write(path, contenu.getBytes(), java.nio.file.StandardOpenOption.APPEND); // APPEND pour ajouter
        System.out.println("Aéroport ajouté au fichier : " + cheminFichier); // Message de confirmation
    }
}