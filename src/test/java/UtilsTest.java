import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UtilsTest {

    @Test
    @DisplayName("Verifica il caricamento del file coi codici dei comuni")
    void caricaCodiciComuni() {
        assertDoesNotThrow(() -> Utils.caricaCodiciComuni("comuni.csv"));
    }

    @Test
    @DisplayName("Verifica il caricamento del file coi codici dei comuni")
    void noncaricaCodiciComuni() {
        assertThrows(IllegalStateException.class, () -> Utils.caricaCodiciComuni("nonesiste.csv"));
    }
}
