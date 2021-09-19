package vista;

import java.util.Scanner;

public class Vista {

    static Scanner leer = new Scanner(System.in);
    private int opcion;

    public Vista() {
    }

    public Vista(int opcion) {
        this.opcion = opcion;
    }

    public void menu() {
        System.out.println("INSTITUTO LA FLORESTA");
        System.out.println("Seleccione tarea a realizar:");
        System.out.println("1. Ingresar estudiante");
        System.out.println("2. Buscar estudiante");
        System.out.println("3. Modificar estudiante");
        System.out.println("4. Eliminar Estudiante");
        System.out.println("5. Ver directorio de estudiantes");
        System.out.println("6. Salir");
    }

    public int ingreseOpcion() {
        System.out.println("Opción:");
        int opcion = leer.nextInt();
        leer.nextLine();
        System.out.println("");

        return opcion;
    }

    public String ingreseNombre() {
        System.out.println("Ingresar nombres: ");
        String nombre = leer.nextLine();
        System.out.println("");

        return nombre;
    }

    public String ingreseApellido() {
        System.out.println("Ingresar apellidos:");
        String apellido = leer.nextLine();
        System.out.println("");

        return apellido;
    }

    public String ingreseFechaNacimiento() {
        System.out.println("Ingresar fecha de nacimiento (YYYY-MM-DD):");
        String edad = leer.nextLine();
        System.out.println("");

        return edad;
    }

    public String ingreseCorreoInstitucional() {
        System.out.println("Ingresar correo institucional:");
        String correoInstitucional = leer.nextLine();
        System.out.println("");

        return correoInstitucional;
    }

    public String ingreseCorreoPersonal() {
        System.out.println("Ingresar correo personal:");
        String correoPersonal = leer.nextLine();
        System.out.println("");

        return correoPersonal;
    }

    public String ingreseNumeroCelular() {
        System.out.println("Ingresar número de celular:");
        String numeroCelular = leer.nextLine();
        System.out.println("");

        return numeroCelular;
    }

    public String ingreseNumeroFijo() {
        System.out.println("Ingresar número fijo:");
        String numeroFijo = leer.nextLine();

        return numeroFijo;
    }

    public String ingreseProgramaAcademico() {
        System.out.println("Ingresar programa:");
        String programaAcademico = leer.nextLine();

        return programaAcademico;
    }

    public int getOpcion() {
        return opcion;
    }

    public void confirmacion(boolean estado, String metodo) {
        if (estado) {
            System.out.println(metodo);

        }
    }

    public void saltoLinea() {
        System.out.println("");
    }

    public void confirmacion(boolean estado, Object metodo) {
        if (estado) {
            System.out.println(metodo);

        }
    }

}
