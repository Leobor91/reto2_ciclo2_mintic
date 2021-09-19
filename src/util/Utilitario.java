package util;

import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import static util.Constantes.EDAD_MINIMA;

public class Utilitario {

    public static String obtenerPropiedades(String key) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("app.properties"));
            return properties.getProperty(key);
        } catch (Exception e) {
            Logger.getLogger(Utilitario.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public static Integer obtenerEdadMinima() {
        return Integer.valueOf(obtenerPropiedades(EDAD_MINIMA));
    }

}
