/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.Constantes;
import util.Utilitario;

public class Validador {

    public static boolean validadorCorreo(String correo) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);
        return mather.find();
    }

    public static boolean validadorFechaNacimiento(String fecha) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat(Constantes.FORMATO_FECHA);
            Date dataFormateada = formato.parse(fecha);
            String fechaFormateada = formato.format(dataFormateada);
            Date hoy = new Date();
            if (!fecha.equals(fechaFormateada)) {
                return false;
            }
            if (dataFormateada.compareTo(hoy) >= 0) {
                return false;
            }
            int edad = calcularEdad(dataFormateada);
            return edad >= Utilitario.obtenerEdadMinima();
        } catch (Exception ex) {
            return false;
        }
    }
    
    private static int calcularEdad(Date DateFechaNac) {
        Calendar fechaNac = Calendar.getInstance();
        fechaNac.setTime(DateFechaNac);
        Calendar today = Calendar.getInstance();
        int diffYear = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int diffMonth = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int diffDay = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
        // Si está en ese año pero todavía no los ha cumplido
        if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
            diffYear = diffYear - 1;
        }
        return diffYear;
    }

    public static Long convertirStrinLong(String numero) {
        try {
            return Long.valueOf(numero);

        } catch (Exception e) {

            return null;
        }

    }

}
