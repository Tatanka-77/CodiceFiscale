public class Persona {

    private final String nome;
    private final String cognome;
    private final int anno;
    private final Mese mese;
    private final int giorno;
    private final Genere genere;
    private final String citta;

    public Persona(String nome, String cognome, int anno, Mese mese, int giorno, Genere genere, String citta) {
        this.nome = nome;
        this.cognome = cognome;
        this.anno = anno;
        this.mese = mese;
        this.giorno = giorno;
        this.genere = genere;
        this.citta = citta;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getAnno() {
        return anno;
    }

    public Mese getMese() {
        return mese;
    }

    public int getGiorno() {
        return giorno;
    }

    public Genere getGenere() {
        return genere;
    }

    public String getCitta() {
        return citta;
    }
}
