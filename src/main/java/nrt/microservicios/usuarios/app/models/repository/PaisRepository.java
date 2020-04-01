package nrt.microservicios.usuarios.app.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import nrt.microservicios.usuarios.app.models.entity.Pais;

public interface PaisRepository extends CrudRepository<Pais, Long> {

	@Query("select p from Pais p order by p.nombre asc")
	public List<Pais> findPaisesOrderByNombreAsc();
}
