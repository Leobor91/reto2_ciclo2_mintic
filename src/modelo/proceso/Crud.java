package modelo.proceso;

import java.util.*;
import modelo.entidades.EstudianteDTO;

public class Crud {//EstudianteDAO

    private Map<String, EstudianteDTO> listadoEstudiante = new TreeMap<String, EstudianteDTO>();
    

    public boolean buscarEstudiante(String correo) {
        if (listadoEstudiante.isEmpty()) {
            return false;
        } else  {
            return listadoEstudiante.containsKey(correo);

        }
    }

    public EstudianteDTO buscarEstudianteDTO(String correo) {
        if (buscarEstudiante(correo)) {
            return listadoEstudiante.get(correo);
        } else {
            return null;
        }
    }

    public boolean crearEstudiante(EstudianteDTO estudiante) {
        if (buscarEstudiante(estudiante.getCorreoInstitucional())) {
            return false;
        } else {
            listadoEstudiante.put(estudiante.getCorreoInstitucional(), estudiante);
            return true;
        }

    }

    public boolean actualizarEstudiante(EstudianteDTO estudiante) {
        if (!buscarEstudiante(estudiante.getCorreoInstitucional())) {
            return false;
        } else {
            listadoEstudiante.put(estudiante.getCorreoInstitucional(), estudiante);
            return true;
        }

    }

    public Map mostraEstudiantes() {
        return listadoEstudiante;
    }

    public boolean eliminarEstudiante(String correoEliminar) {
        if (buscarEstudiante(correoEliminar)) {
            listadoEstudiante.remove(correoEliminar);
            return true;
        } else {
            return false;
        }
    }

}
