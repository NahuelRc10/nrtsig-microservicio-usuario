package nrt.microservicios.usuarios.app.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import nrt.microservicios.main.commons.usuario.entity.Ciudad;

public interface CiudadRepository extends CrudRepository<Ciudad, Long>{

	@Query("select c from Ciudad c where c.provincia.id = ?1")
	public List<Ciudad> findCiudadByIdProvincia(Long idProvincia);
}
