package nrt.microservicios.usuarios.app.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import nrt.microservicios.usuarios.app.models.entity.Alumno;

public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Long> {

	@Query(value = "select a.id from alumnos a where a.tipo_documento = ?1 and a.nro_documento = ?2", nativeQuery = true)
	public Long getIdAlumnoByTipoDocumentoAndNroDocumento(String tipo_documento, Long numeroDocumento);
	
	@Query(value = "select max(a.legajo) from alumnos a", nativeQuery = true)
	public Long getMaximoLegajo();
}
