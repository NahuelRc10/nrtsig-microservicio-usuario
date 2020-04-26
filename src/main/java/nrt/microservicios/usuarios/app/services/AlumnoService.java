package nrt.microservicios.usuarios.app.services;

import nrt.microservicios.commons.services.CommonService;
import nrt.microservicios.main.commons.usuario.entity.Alumno;

public interface AlumnoService extends CommonService<Alumno> {
	
	public Alumno actualizarAlumno(Alumno alumno, Long id) throws Exception;
	
	public Long obtenerUltimoLegajo();
}
