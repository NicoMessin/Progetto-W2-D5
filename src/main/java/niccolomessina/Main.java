package niccolomessina;
import entities.*;
import Exceptions.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Collezione collezione = new Collezione();
        boolean exit = false;

        while (!exit) {
            System.out.println(" MENU COLLEZIONE GIOCHI ");
            System.out.println("1. Aggiungi Videogioco");
            System.out.println("2. Aggiungi Gioco da Tavolo");
            System.out.println("3. Mostra statistiche");
            System.out.println("4. Cerca per prezzo");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");
            String scelta = sc.nextLine();

            if (scelta.equals("1")) {
                try {
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Titolo: ");
                    String titolo = sc.nextLine();
                    System.out.print("Anno pubblicazione: ");
                    int anno = Integer.parseInt(sc.nextLine());
                    System.out.print("Prezzo: ");
                    double prezzo = Double.parseDouble(sc.nextLine());
                    System.out.print("Piattaforma: ");
                    String piattaforma = sc.nextLine();
                    System.out.print("Durata ore: ");
                    int durata = Integer.parseInt(sc.nextLine());
                    System.out.print("Genere (AZIONE, RPG, SPORT, STRATEGIA, AVVENTURA): ");
                    Genere genere = Genere.valueOf(sc.nextLine().toUpperCase());

                    VideoGioco vg = new VideoGioco(id, titolo, anno, prezzo, piattaforma, durata, genere);
                    collezione.aggiungi(vg);
                    System.out.println("Videogioco aggiunto!");
                } catch (ElementoDuplicatoException | IllegalArgumentException e) {
                    System.out.println("Errore: " + e.getMessage());
                }

            } else if (scelta.equals("2")) {
                try {
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Titolo: ");
                    String titolo = sc.nextLine();
                    System.out.print("Anno pubblicazione: ");
                    int anno = Integer.parseInt(sc.nextLine());
                    System.out.print("Prezzo: ");
                    double prezzo = Double.parseDouble(sc.nextLine());
                    System.out.print("Numero giocatori (2-10): ");
                    int nGiocatori = Integer.parseInt(sc.nextLine());
                    System.out.print("Durata media partita (minuti): ");
                    int durata = Integer.parseInt(sc.nextLine());

                    GiocoDaTavolo gdt = new GiocoDaTavolo(id, titolo, anno, prezzo, nGiocatori, durata);
                    collezione.aggiungi(gdt);
                    System.out.println("Gioco da tavolo aggiunto!");
                } catch (ElementoDuplicatoException | IllegalArgumentException e) {
                    System.out.println("Errore: " + e.getMessage());
                }

            } else if (scelta.equals("3")) {
                collezione.statistiche();

            } else if (scelta.equals("4")) {
                try {
                    System.out.print("Prezzo massimo: ");
                    double prezzoMax = Double.parseDouble(sc.nextLine());
                    System.out.println(collezione.cercaPerPrezzo(prezzoMax));
                } catch (IllegalArgumentException e) {
                    System.out.println("Errore: " + e.getMessage());
                }

            } else if (scelta.equals("5")) {
                exit = true;

            } else {
                System.out.println("Scelta non valida!");
            }
        }

        sc.close();
    }
}