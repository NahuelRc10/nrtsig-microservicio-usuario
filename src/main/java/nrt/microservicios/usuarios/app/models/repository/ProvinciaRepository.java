package nrt.microservicios.usuarios.app.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import nrt.microservicios.main.commons.usuario.entity.Provincia;

public interface ProvinciaRepository extends PagingAndSortingRepository<Provincia, Long> {

	@Query("select prov from Provincia prov where prov.pais.id = ?1 order by prov.nombre")
	public List<Provincia> findProvincaByIdPais(Long idPais);
}
