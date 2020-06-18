package nrt.microservicios.usuarios.app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import nrt.microservicios.commons.services.CommonServiceImpl;
import nrt.microservicios.main.commons.usuario.entity.Alumno;
import nrt.microservicios.main.commons.usuario.entity.Domicilio;
import nrt.microservicios.usuarios.app.models.repository.AlumnoRepository;
import nrt.microservicios.usuarios.app.services.AlumnoService;
import nrt.microservicios.usuarios.app.services.DomicilioService;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private DomicilioService domicilioService;
	
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
		alumnoDb.setFoto(alumno.getFoto());

		return alumnoRepository.save(alumnoDb);
	}

	@Override
	public Alumno save(Alumno alumno) throws Exception {
		// Validamos que el alumno no exista en la base de datos
		Long id = alumnoRepository.getIdAlumnoByTipoDocumentoAndNroDocumento(alumno.getTipoDocumento(), alumno.getNumeroDocumento());
		if (id != null) {
			throw new Exception("El alumno ya existe en la base de datos");
		}
		
		// Validamos que el cuit corresponda con el dni del alumno/a
		boolean validaCuit = validarCuitAlumno(alumno.getCuit(), alumno.getNumeroDocumento().toString(), alumno.getSexo());
		if (!validaCuit) {
			throw new Exception("El CUIT no coincide con el Numero de Documento");
		}
		
		// Persistimos en la base el domicilio
		Domicilio domicilioDb = domicilioService.save(alumno.getDomicilio());
		alumno.setDomicilio(domicilioDb);
		return alumnoRepository.save(alumno);
	}

	@Override
	public Long obtenerUltimoLegajo() {
		Long ultimoLegajo = alumnoRepository.getMaximoLegajo();
		return ultimoLegajo;
	}

	@Override
	public boolean validarCuitAlumno(String cuit, String dni, String sexo) {
		// Eliminamos todos los caracteres que no sean numeros
		cuit = cuit.replaceAll("[^\\d]", "");
		// Controllamos si son 11 numeros lo que quedaron, caso contrario return false
		if (cuit.length() != 11) {
			return false;
		}
		// Separamos en partes al cuit
		String primeraParteCuit = cuit.substring(0, 2);
		String segundaParteCuit = cuit.substring(2, 10);
		// Controlamos la primera parte del cuit segun el sexo
		if (sexo != null || !(sexo.equalsIgnoreCase("M")) || !(sexo.equalsIgnoreCase("F"))) {
			return false;
		}
		
		if (sexo.equalsIgnoreCase("M")) {
			if (!primeraParteCuit.equalsIgnoreCase("20")) {
				return false;
			}
		} else {
			if (!primeraParteCuit.equalsIgnoreCase("27")) {
				return false;
			}
		}
		// Validamos la segunda parte debe coincidir con el dni 
		if (!segundaParteCuit.equalsIgnoreCase(dni)) {
			return false;
		}
		// Si pasa todas las validaciones return true
		return true;
	}

	@Override
	public List<Alumno> obtenerAlumnosByFiltro(String filter) {
		List<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos = alumnoRepository.getAlumnosByFilter(filter);
		return alumnos;
	}

	@Override
	public Alumno saveFotoPerfilAlumno(Long id, MultipartFile archivo) throws Exception {
		Optional<Alumno> o = alumnoRepository.findById(id);
		if (o.isEmpty()) {
			throw new Exception("No existe el alumno a actualizar!");
		}
		
		Alumno alumno = o.get();
		alumno.setFoto(archivo.getBytes());
		return alumnoRepository.save(alumno);
	}
	
}
