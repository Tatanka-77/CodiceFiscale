import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

public class Utils {

    static HashMap<String, String> caricaCodiciComuni(String fileIn) {
        HashMap<String, String> mappa = new HashMap<>();
        Path path = Paths.get(fileIn);
        try (Stream<String> lines = Files.lines(path)) {

            lines.forEach(x -> {
                String[] dato = x.split(",");
                mappa.put(dato[0].replaceAll(" ", "").toLowerCase(), dato[1]);
            });
        } catch (Exception ex) {
            throw new IllegalStateException("File non trovato o non valido");
        }
        return mappa;
    }
}
