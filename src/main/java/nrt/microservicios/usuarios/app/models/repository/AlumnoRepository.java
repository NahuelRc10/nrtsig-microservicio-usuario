package nrt.microservicios.usuarios.app.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import nrt.microservicios.main.commons.usuario.entity.Alumno;

public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Long> {

	@Query(value = "select a.id from alumnos a where a.tipo_documento = ?1 and a.nro_documento = ?2", nativeQuery = true)
	public Long getIdAlumnoByTipoDocumentoAndNroDocumento(String tipo_documento, Long numeroDocumento);
	
	@Query(value = "select max(a.legajo) from alumnos a", nativeQuery = true)
	public Long getMaximoLegajo();
	
	// Query JPQL
	@Query("select a from Alumno a where a.nombre like %?1% or a.apellido like %?1%")
	public List<Alumno> getAlumnosByFilter(String filter);
	
	// Otra forma de buscar por filtro con query nativa sql
//	@Query(value = "select * from alumnos a where a.nombre like %?1% or a.apellido like %?1%")
//	public List<Alumno> getAlumnosByFilter(String filter);
}
