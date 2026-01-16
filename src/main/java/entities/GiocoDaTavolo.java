package entities;



public class GiocoDaTavolo extends Gioco {

    private int numeroGiocatori;
    private int durataMediaMinuti;

    public GiocoDaTavolo(String id, String titolo, int anno, double prezzo,
                         int numeroGiocatori, int durataMediaMinuti) {
        super(id, titolo, anno, prezzo);

        if (numeroGiocatori < 2 || numeroGiocatori > 10) {
            throw new IllegalArgumentException("Numero giocatori deve essere tra 2 e 10");
        }

        this.numeroGiocatori = numeroGiocatori;
        this.durataMediaMinuti = durataMediaMinuti;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public int getDurataMediaMinuti() {
        return durataMediaMinuti;
    }
}
