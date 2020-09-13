package nrt.microservicios.usuarios.app.models.dto;

import nrt.microservicios.main.commons.carrera.entity.Carrera;
import nrt.microservicios.main.commons.carrera.entity.Departamento;

public class DocenteFiltrosDTO {

    private String nombre;
    private Departamento departamento;
    private Carrera carrera;
    private String asignatura;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
}
