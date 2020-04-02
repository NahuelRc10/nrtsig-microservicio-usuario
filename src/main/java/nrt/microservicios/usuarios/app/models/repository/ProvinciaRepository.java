package nrt.microservicios.usuarios.app.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import nrt.microservicios.usuarios.app.models.entity.Provincia;

public interface ProvinciaRepository extends CrudRepository<Provincia, Long> {

	@Query("select prov from Provincia prov where prov.pais.id = ?1")
	public List<Provincia> findProvincaByIdPais(Long idPais);
}
