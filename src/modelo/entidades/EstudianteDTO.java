package modelo.entidades;

public class EstudianteDTO {

    private String correoInstitucional;
    private String correoPersonal;
    private long numeroCelular;
    private long numeroFijo;
    private String programaAcademico;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;

    public EstudianteDTO() {
    }

    public EstudianteDTO(String correoInstitucional, String correoPersonal, long numeroCelular, long numeroFijo, String programaAcademico, String nombre, String apellido, String fechaNacimiento) {
        this.correoInstitucional = correoInstitucional;
        this.correoPersonal = correoPersonal;
        this.numeroCelular = numeroCelular;
        this.numeroFijo = numeroFijo;
        this.programaAcademico = programaAcademico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public long getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(long numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public long getNumeroFijo() {
        return numeroFijo;
    }

    public void setNumeroFijo(long numeroFijo) {
        this.numeroFijo = numeroFijo;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombres: ").append(nombre).append("\n");
        sb.append("Apellidos: ").append(apellido).append("\n");
        sb.append("Fecha nacimiento: ").append(fechaNacimiento).append("\n");
        sb.append("Correo institucional: ").append(correoInstitucional).append("\n");
        sb.append("Correo personal: ").append(correoPersonal).append("\n");
        sb.append("Número de teléfono celular: ").append(numeroCelular).append("\n");
        sb.append("Número de teléfono fijo: ").append(numeroFijo).append("\n");
        sb.append("Programa académico: ").append(programaAcademico);
        return sb.toString();
    }

}