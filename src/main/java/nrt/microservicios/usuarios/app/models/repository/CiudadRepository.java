package nrt.microservicios.usuarios.app.models.repository;

import org.springframework.data.repository.CrudRepository;

import nrt.microservicios.usuarios.app.models.entity.Ciudad;

public interface CiudadRepository extends CrudRepository<Ciudad, Long>{

}
