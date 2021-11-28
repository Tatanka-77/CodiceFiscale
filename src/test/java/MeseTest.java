import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeseTest {
    @ParameterizedTest
    @CsvSource({"Gennaio,A", "Febbraio,B", "Marzo,C", "Aprile,D",
            "Maggio,E", "Giugno,H", "Luglio,L", "Agosto,M", "Settembre,P",
            "Ottobre,R", "Novembre,S", "Dicembre,T"})
    void verificaCarattereMese(String inMese, String expChar) {
        Mese mese = Mese.valueOf(inMese.toUpperCase());
        assertEquals(expChar, mese.getCarattere());
    }

}