package nrt.microservicios.usuarios.app.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import nrt.microservicios.main.commons.usuario.entity.Ciudad;

public interface CiudadRepository extends PagingAndSortingRepository<Ciudad, Long>{

	@Query("select c from Ciudad c where c.provincia.id = ?1 order by c.nombre")
	public List<Ciudad> findCiudadByIdProvincia(Long idProvincia);
}
