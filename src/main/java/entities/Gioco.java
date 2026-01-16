package entities;

public abstract class Gioco {

    private final String id;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;

    protected Gioco(String id, String titolo, int annoPubblicazione, double prezzo) {
        if (prezzo <= 0) {
            throw new IllegalArgumentException("Prezzo deve essere positivo");
        }
        this.id = id;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public String getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }
}

