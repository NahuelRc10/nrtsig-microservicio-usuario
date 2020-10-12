package nrt.microservicios.usuarios.app.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import nrt.microservicios.main.commons.usuario.entity.Docente;

import java.util.List;

public interface DocenteRepository extends PagingAndSortingRepository<Docente, Long> {

	@Query(value = "select d.id from docentes d where d.tipo_documento = ?1 and d.nro_documento = ?2", nativeQuery = true)
	public Long getIdDocenteByTipoDocumentoAndNumeroDocumento(String tipoDocumento, Long numeroDocumento);
	
	@Query(value = "select max(d.legajo) from docentes d", nativeQuery = true)
	public Long getMaxLegajo();

	@Query(value = "select * from docentes d where d.id = ?1", nativeQuery = true)
	public Docente findDocenteById(Long id);

	@Query("select d from Docente d where d.nombre like %?1% or d.apellido like %?1%")
	public List<Docente> findByNombre(String termino);
}
