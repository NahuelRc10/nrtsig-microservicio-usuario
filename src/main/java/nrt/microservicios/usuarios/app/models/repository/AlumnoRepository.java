package nrt.microservicios.usuarios.app.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import nrt.microservicios.usuarios.app.models.entity.Alumno;

public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Long> {

	@Query("select id from alumnos where tipo_documento = ?1 and nro_documento = ?2")
	public Long getIdAlumnoByTipoDocumentoAndNroDocumento(String tipo_documento, Long numeroDocumento);
	
	@Query("select max(legajo) from alumnos")
	public Long getMaximoLegajo();
}
