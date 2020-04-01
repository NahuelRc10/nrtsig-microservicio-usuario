package nrt.microservicios.usuarios.app.models.repository;

import org.springframework.data.repository.CrudRepository;

import nrt.microservicios.usuarios.app.models.entity.Pais;

public interface PaisRepository extends CrudRepository<Pais, Long> {

}
