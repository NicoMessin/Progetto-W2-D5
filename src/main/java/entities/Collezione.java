package entities;
import Exceptions.*;

import java.util.*;
import java.util.stream.Collectors;

public class Collezione {

    private List<Gioco> giochi = new ArrayList<>();

    public void aggiungi(Gioco gioco) throws ElementoDuplicatoException {
        boolean exists = giochi.stream()
                .anyMatch(g -> g.getId().equals(gioco.getId()));
        if (exists) throw new ElementoDuplicatoException("ID già presente");
        giochi.add(gioco);
    }

    public Gioco cercaPerId(String id) throws ElementoNonTrovatoException {
        return giochi.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ElementoNonTrovatoException("ID non trovato"));
    }

    public List<Gioco> cercaPerPrezzo(double prezzoMax) {
        return giochi.stream()
                .filter(g -> g.getPrezzo() < prezzoMax)
                .toList();
    }

    public List<GiocoDaTavolo> cercaPerNumeroGiocatori(int n) {
        return giochi.stream()
                .filter(g -> g instanceof GiocoDaTavolo)
                .map(g -> (GiocoDaTavolo) g)
                .filter(g -> g.getNumeroGiocatori() == n)
                .toList();
    }

    public void rimuovi(String id) throws ElementoNonTrovatoException {
        boolean removed = giochi.removeIf(g -> g.getId().equals(id));
        if (!removed) throw new ElementoNonTrovatoException("ID non trovato");
    }

    public void aggiorna(String id, Gioco nuovo) throws ElementoNonTrovatoException {
        for (int i = 0; i < giochi.size(); i++) {
            if (giochi.get(i).getId().equals(id)) {
                giochi.set(i, nuovo);
                return;
            }
        }
        throw new ElementoNonTrovatoException("ID non trovato");
    }

    public void statistiche() {
        long numVideogiochi = giochi.stream()
                .filter(g -> g instanceof VideoGioco)
                .count();

        long numGiochiTavolo = giochi.stream()
                .filter(g -> g instanceof GiocoDaTavolo)
                .count();

        Gioco piùCaro = giochi.stream()
                .max(Comparator.comparing(Gioco::getPrezzo))
                .orElse(null);

        double mediaPrezzi = giochi.stream()
                .mapToDouble(Gioco::getPrezzo)
                .average()
                .orElse(0);

        System.out.println("Videogiochi: " + numVideogiochi);
        System.out.println("Giochi da tavolo: " + numGiochiTavolo);
        System.out.println("Gioco più caro: " + piùCaro);
        System.out.println("Prezzo medio: " + mediaPrezzi);
    }
}