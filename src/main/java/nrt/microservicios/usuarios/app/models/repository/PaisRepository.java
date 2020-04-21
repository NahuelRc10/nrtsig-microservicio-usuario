package nrt.microservicios.usuarios.app.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import nrt.microservicios.main.commons.usuario.entity.Pais;

public interface PaisRepository extends PagingAndSortingRepository<Pais, Long> {

	@Query("select p from Pais p order by p.nombre asc")
	public List<Pais> findPaisesOrderByNombreAsc();
}
