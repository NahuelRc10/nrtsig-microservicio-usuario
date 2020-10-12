package nrt.microservicios.usuarios.app.services;

import java.util.List;

import nrt.microservicios.main.commons.carrera.entity.InscripcionAsignatura;
import org.springframework.web.multipart.MultipartFile;

import nrt.microservicios.commons.services.CommonService;
import nrt.microservicios.main.commons.usuario.entity.Alumno;

public interface AlumnoService extends CommonService<Alumno> {
	
	public Alumno actualizarAlumno(Alumno alumno, Long id) throws Exception;
	public Long obtenerUltimoLegajo();
	public boolean validarCuitAlumno(String cuit, String dni, String sexo);
	public List<Alumno> obtenerAlumnosByFiltro(String filter);
	public Alumno saveFotoPerfilAlumno(Long id, MultipartFile archivo) throws Exception;
	public List<Alumno> getAlumnosFiltrados(String termino);
}
