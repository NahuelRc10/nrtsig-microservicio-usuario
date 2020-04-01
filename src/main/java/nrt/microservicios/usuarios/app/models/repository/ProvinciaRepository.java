package nrt.microservicios.usuarios.app.models.repository;

import org.springframework.data.repository.CrudRepository;

import nrt.microservicios.usuarios.app.models.entity.Provincia;

public interface ProvinciaRepository extends CrudRepository<Provincia, Long> {

}
