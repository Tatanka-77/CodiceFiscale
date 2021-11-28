import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CodiceFiscaleTest {

    @ParameterizedTest
    @DisplayName("Verifica la codifica del cognome")
    @CsvSource({"RANELI,RNL", "CUCCO,CCC", "ADA,DAA", "B,BXX",
            "AB,BAX", "A,AXX", "B,BXX", "BA,BAX", "AAA,AAA", ",XXX", "DE ROSSI,DRS"})
    void dovrebbeCodificareIlCognomeCorrettamente(String cognome, String valoreAtteso) {
        assertEquals(valoreAtteso, CodiceFiscale.codificaCognome(cognome).toUpperCase());
    }

    @ParameterizedTest
    @DisplayName("Verifica la codifica del nome")
    @CsvSource({"SERGIO,SRG", "GREGORIO,GGR", "ADA,DAA", "B,BXX",
            "AB,BAX", "A,AXX", "B,BXX", "BA,BAX", "AAA,AAA", ",XXX", "LUCA MARIA,LMR"})
    void dovrebbeCodificareIlNomeCorrettamente(String nome, String valoreAtteso) {
        assertEquals(valoreAtteso, CodiceFiscale.codificaNome(nome).toUpperCase());
    }

    @ParameterizedTest
    @DisplayName("Verifica la codifica dell'anno")
    @CsvSource({"9,09", "1982,82", "2000,00", "1900,00",
            "2015,15"})
    void dovrebbeCodificareLAnnoCorrettamente(int anno, String valoreAtteso) {
        assertEquals(valoreAtteso, CodiceFiscale.codificaAnno(anno).toUpperCase());
    }

    @Test
    @DisplayName("Se l'anno è negativo lancia un eccezione")
    void dovrebbeLanciareUnEccezione() {
        assertThrows(IllegalArgumentException.class, () -> CodiceFiscale.codificaAnno(-4));
    }

    @Test
    @DisplayName("Verifica che in caso di citta non trovata sia lanciata un eccezione")
    void verificaEsistenzaCitta() {
        Persona persona = new Persona("Tizio", "Caio", 1990,
                Mese.MARZO, 11, Genere.UOMO, "non esiste");
        assertThrows(IllegalArgumentException.class, () -> CodiceFiscale.codificaCitta(persona.getCitta().toLowerCase().replaceAll(" ", "")));
    }

    @Test
    @DisplayName("Verifica che il codice calcolato sia formalmente corretto")
    void verificaCorrettezzaFormale() {
        Persona persona = new Persona("Mario", "Rossi", 2001,
                Mese.SETTEMBRE, 11, Genere.UOMO, "Palermo");
        String codice = CodiceFiscale.calcolaCodice(persona);
        assertTrue(codice.matches("^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$"));
    }

    @Test
    @DisplayName("Verifica che il codice calcolato sia corretto")
    void verificaCodice() {
        Persona persona = new Persona("MARIA", "ROSSI", 2001,
                Mese.SETTEMBRE, 11, Genere.DONNA, "Palermo");
        String codice = CodiceFiscale.calcolaCodice(persona);
        System.out.println("TEST CALCOLO CODICE");
        System.out.println(persona);
        System.out.println("Codice Fiscale atteso:    RSSMRA01P51G273P" );
        System.out.println("Codice fiscale calcolato: " + codice.toUpperCase());
        assertEquals("RSSMRA01P51G273P", codice.toUpperCase());
    }

}