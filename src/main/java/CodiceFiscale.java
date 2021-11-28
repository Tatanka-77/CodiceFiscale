import java.util.HashMap;

public class CodiceFiscale {
    static String calcolaCodice(Persona persona) {
        StringBuilder codice = new StringBuilder();
        codice.append(codificaCognome(persona.getCognome()));
        codice.append(codificaNome(persona.getNome()));
        codice.append(codificaAnno(persona.getAnno()));
        codice.append(persona.getMese().getCarattere());
        codice.append(persona.getGiorno() + persona.getGenere().getOffset());
        codice.append(codificaCitta(persona.getCitta().toLowerCase()));
        codice.append(codiceControllo(codice.toString()).toUpperCase());
        return codice.toString().toUpperCase();
    }

    private static String codiceControllo(String codice) {
        int valore = 0;
        StringBuilder caratteriPari = new StringBuilder();
        StringBuilder caratteriDispari = new StringBuilder();
        codice = codice.toUpperCase();
        for (int i = 0; i + 1 < codice.length(); i += 2) {
            caratteriDispari.append(codice.charAt(i));
            caratteriPari.append(codice.charAt(i + 1));
        }
        caratteriDispari.append(codice.charAt(codice.length() - 1));
        for (int i = 0; i < caratteriPari.length(); i++) {
            if (caratteriPari.substring(i, i + 1).matches("[A-Z]")) valore += (int) caratteriPari.charAt(i) - 65;
            else valore += Character.getNumericValue(caratteriPari.charAt(i));
        }
        int[] numeroDispari = {1, 0, 5, 7, 9, 13, 15, 17, 19, 21};
        for (int i = 0; i < caratteriDispari.length(); i++) {
            if (caratteriDispari.substring(i, i + 1).matches("[A-Z]"))
                valore += CarattereDispari.valueOf(caratteriDispari.substring(i, i + 1)).getValore();
            else valore += numeroDispari[Character.getNumericValue(caratteriDispari.charAt(i))];
        }
        return Character.toString((char) valore % 26 + 65);
    }

    static String codificaCognome(String cognome) {
        if (cognome == null) return "xxx";
        StringBuilder codice = new StringBuilder(cognome.toLowerCase().replaceAll("[ aeiou|1-9]", ""));
        if (codice.length() >= 3) return codice.substring(0, 3);
        else {
            String vocali = cognome.toLowerCase().replaceAll("[ bcdfghjklmnpqrstvxz]", "");
            for (int i = 0; i < vocali.length(); i++) {
                codice.append(vocali.charAt(i));
                if (codice.length() == 3) return codice.toString();
            }
            while (codice.length() < 3) codice.append("x");
        }
        return codice.toString();
    }

    static String codificaNome(String nome) {
        if (nome == null) return "xxx";
        StringBuilder codice = new StringBuilder(nome.toLowerCase().replaceAll("[ aeiou|1-9]", ""));
        if (codice.length() >= 4) return codice.deleteCharAt(1).substring(0, 3);
        if (codice.length() == 3) return codice.toString();
        else {
            String vocali = nome.toLowerCase().replaceAll("[ bcdfghjklmnpqrstvxz|1-9]", "");
            for (int i = 0; i < vocali.length(); i++) {
                codice.append(vocali.charAt(i));
                if (codice.length() == 3) return codice.toString();
            }
            while (codice.length() < 3) codice.append("x");
        }
        return codice.toString();
    }

    static String codificaAnno(int anno) {
        if (anno < 0) throw new IllegalArgumentException("L'anno non può essere negativo");
        anno += 100; //rende significative le due cifre che ci servono
        String codice = String.valueOf(anno);
        return codice.substring(codice.length() - 2);
    }

    static String codificaCitta(String citta) {
        HashMap<String, String> comuni = Utils.caricaCodiciComuni("comuni.csv");
        if (comuni.containsKey(citta)) return comuni.get(citta.toLowerCase().replaceAll(" ", "")).toUpperCase();
        else throw new IllegalArgumentException("CITTA NON TROVATA");
    }


}
