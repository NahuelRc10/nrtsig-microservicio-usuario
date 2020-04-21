package nrt.microservicios.usuarios.app.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import nrt.microservicios.main.commons.usuario.entity.Domicilio;

public interface DomicilioRepository extends PagingAndSortingRepository<Domicilio, Long> {

}
