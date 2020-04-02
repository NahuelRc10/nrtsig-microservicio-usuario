package nrt.microservicios.usuarios.app.services.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nrt.microservicios.commons.services.CommonServiceImpl;
import nrt.microservicios.usuarios.app.models.entity.Alumno;
import nrt.microservicios.usuarios.app.models.repository.AlumnoRepository;
import nrt.microservicios.usuarios.app.services.AlumnoService;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Override
	public Alumno actualizarAlumno(Alumno alumno, Long id) throws Exception {
		Optional<Alumno> o = alumnoRepository.findById(id);
		if (o.isEmpty()) {
			throw new Exception("No existe el alumno a actualizar!");
		}
		
		Alumno alumnoDb = o.get();
		alumnoDb.setLegajo(alumno.getLegajo());
		alumnoDb.setTipoDocumento(alumno.getTipoDocumento());
		alumnoDb.setNumeroDocumento(alumno.getNumeroDocumento());
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());
		alumnoDb.setTelefono(alumno.getTelefono());
		alumnoDb.setFechaNacimiento(alumno.getFechaNacimiento());
		alumnoDb.setCuit(alumno.getCuit());
		alumnoDb.setSexo(alumno.getSexo());
		alumnoDb.setCiudad(alumno.getCiudad());
		alumnoDb.setDomicilio(alumno.getDomicilio());
		 
		return alumnoRepository.save(alumnoDb);
	}
	
}
