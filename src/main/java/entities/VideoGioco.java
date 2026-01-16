package entities;

public class VideoGioco extends Gioco {

    private String piattaforma;
    private int durataOre;
    private Genere genere;

    public VideoGioco(String id, String titolo, int anno, double prezzo,
                      String piattaforma, int durataOre, Genere genere) {
        super(id, titolo, anno, prezzo);
        this.piattaforma = piattaforma;
        this.durataOre = durataOre;
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public int getDurataOre() {
        return durataOre;
    }

    public Genere getGenere() {
        return genere;
    }
    @Override
    public String toString() {
        return getTitolo() + " (ID: " + getId() + ", Prezzo: " + getPrezzo() +
                ", Piattaforma: " + piattaforma + ", Durata: " + durataOre + "h, Genere: " + genere + ")";
    }
}