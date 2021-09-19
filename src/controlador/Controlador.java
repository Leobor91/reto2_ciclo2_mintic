package controlador;

import java.util.Iterator;
import modelo.entidades.EstudianteDTO;
import modelo.entidades.Validador;
import modelo.proceso.Crud;
import util.Constantes;
import vista.Vista;

public class Controlador {

    Vista vista = new Vista();

    Crud crud = new Crud();

    public void iniciar() {

        vista.menu();
        vista = new Vista(vista.ingreseOpcion());

        switch (vista.getOpcion()) {
            case 1:
                EstudianteDTO estudiante = new EstudianteDTO();
                vista.confirmacion(true, Constantes.INGRESAR_ESTUDIANTE);
                estudiante.setNombre(vista.ingreseNombre());
                estudiante.setApellido(vista.ingreseApellido());
                String fechaTemporal = vista.ingreseFechaNacimiento();
                while (!Validador.validadorFechaNacimiento(fechaTemporal)) {
                    fechaTemporal = vista.ingreseFechaNacimiento();
                }
                estudiante.setFechaNacimiento(fechaTemporal);
                String correoTemporal = vista.ingreseCorreoInstitucional();
                while (!Validador.validadorCorreo(correoTemporal)) {
                    correoTemporal = vista.ingreseCorreoInstitucional();
                }
                estudiante.setCorreoInstitucional(correoTemporal);
                correoTemporal = vista.ingreseCorreoPersonal();
                while (!Validador.validadorCorreo(correoTemporal)) {
                    correoTemporal = vista.ingreseCorreoPersonal();
                }
                estudiante.setCorreoPersonal(correoTemporal);
                String numeroTemporal = vista.ingreseNumeroCelular();

                while (Validador.convertirStrinLong(numeroTemporal) == null) {
                    numeroTemporal = vista.ingreseNumeroCelular();
                }
                estudiante.setNumeroCelular((Validador.convertirStrinLong(numeroTemporal)));
                numeroTemporal = vista.ingreseNumeroFijo();
                while (Validador.convertirStrinLong(numeroTemporal) == null) {
                    numeroTemporal = vista.ingreseNumeroFijo();
                }
                estudiante.setNumeroFijo((Validador.convertirStrinLong(numeroTemporal)));
                vista.saltoLinea();
                estudiante.setProgramaAcademico(vista.ingreseProgramaAcademico());
                vista.saltoLinea();
                vista.confirmacion(crud.crearEstudiante(estudiante), Constantes.SE_AGREGO_EL_ESTUDIANTE);
                vista.saltoLinea();
                iniciar();
                break;
            case 2:

                vista.confirmacion(true, Constantes.BUSCAR_ESTUDIANTE);
                correoTemporal = vista.ingreseCorreoInstitucional();
                while (!crud.buscarEstudiante(correoTemporal)) {
                    correoTemporal = vista.ingreseCorreoInstitucional();
                }
                vista.confirmacion(true, Constantes.INFORMACION_DEL_ESTUDIANTE);
                vista.confirmacion(true, crud.buscarEstudianteDTO(correoTemporal));
                vista.saltoLinea();
                iniciar();
                break;
            case 3:
                vista.confirmacion(true, Constantes.MODIFICAR_ESTUDIANTE);
                correoTemporal = vista.ingreseCorreoInstitucional();
                EstudianteDTO estudianteModificar = crud.buscarEstudianteDTO(correoTemporal);
                correoTemporal = vista.ingreseCorreoPersonal();
                while (!Validador.validadorCorreo(correoTemporal)) {
                    correoTemporal = vista.ingreseCorreoPersonal();
                }
                estudianteModificar.setCorreoPersonal(correoTemporal);
                numeroTemporal = vista.ingreseNumeroCelular();

                while (Validador.convertirStrinLong(numeroTemporal) == null) {
                    numeroTemporal = vista.ingreseNumeroCelular();
                }
                estudianteModificar.setNumeroCelular((Validador.convertirStrinLong(numeroTemporal)));
                numeroTemporal = vista.ingreseNumeroFijo();
                while (Validador.convertirStrinLong(numeroTemporal) == null) {
                    numeroTemporal = vista.ingreseNumeroFijo();
                }
                estudianteModificar.setNumeroFijo((Validador.convertirStrinLong(numeroTemporal)));
                estudianteModificar.setProgramaAcademico(vista.ingreseProgramaAcademico());
                vista.confirmacion(true, Constantes.SE_MODIFICO_EL_ESTUDIANTE);
                crud.actualizarEstudiante(estudianteModificar);
                vista.saltoLinea();
                iniciar();
                break;
            case 4:
                vista.confirmacion(true, Constantes.ELIMINAR_ESTUDIANTE);
                vista.confirmacion(crud.eliminarEstudiante(vista.ingreseCorreoInstitucional()), Constantes.SE_ELIMINO_EL_ESTUDIANTE);
                vista.saltoLinea();
                iniciar();
                break;
            case 5:
                vista.confirmacion(true, Constantes.EL_DIRECTORIO_DE_LOS_ESTUDIANTES);
                vista.saltoLinea();
                Iterator it = crud.mostraEstudiantes().keySet().iterator();
                while (it.hasNext()) {
                    vista.confirmacion(true, crud.buscarEstudianteDTO((String) it.next()));
                }
                vista.saltoLinea();
                iniciar();
                break;
            case 6:
                vista.confirmacion(true, Constantes.HASTA_PRONTO);
                break;

        }

    }
}
