package nrt.microservicios.usuarios.app.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import nrt.microservicios.usuarios.app.models.entity.Alumno;

public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Long> {

}
