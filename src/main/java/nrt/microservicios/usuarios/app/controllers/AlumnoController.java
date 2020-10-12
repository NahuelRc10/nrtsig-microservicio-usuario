package nrt.microservicios.usuarios.app.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import nrt.microservicios.commons.controllers.CommonController;
import nrt.microservicios.main.commons.usuario.entity.Alumno;
import nrt.microservicios.usuarios.app.services.AlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController extends CommonController<Alumno, AlumnoService> {

	private final Logger logger = LoggerFactory.getLogger(AlumnoController.class);
	@Autowired
	private AlumnoService alumnoService;
	
	@PostMapping("/crear-con-foto")
	public ResponseEntity<?> addWithPhoto(@Valid Alumno alumno, BindingResult result, @RequestParam MultipartFile archivo) throws IOException {
		logger.debug("Ingresa a addWithPhoto()");
		if (!archivo.isEmpty()) {
			alumno.setFoto(archivo.getBytes());
		}
		return super.add(alumno, result);
	}
	
	@GetMapping("/uploads/img/{id}")
	public ResponseEntity<?> verFoto(@PathVariable Long id) {
		logger.debug("Ingresa a verFoto()");
		Optional<Alumno> alumno = alumnoService.findById(id);
		if (alumno.isEmpty() || alumno.get().getFoto() == null) {
			return ResponseEntity.notFound().build();
		}
		Resource imagen = new ByteArrayResource(alumno.get().getFoto());
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagen);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editAlumno(@Valid @RequestBody Alumno alumno, BindingResult result, @PathVariable Long id) throws Exception {
		logger.debug("Ingresa a editAlumno()");
		// Validamos las restricciones de las propiedades del entity Alumno
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Alumno alumnoAct = alumnoService.actualizarAlumno(alumno, id);
		return new ResponseEntity<Alumno>(alumnoAct, HttpStatus.CREATED);
	}
	
	@PutMapping("/editar-con-foto/{id}")
	public ResponseEntity<?> editWithFoto(Alumno alumno, @PathVariable Long id,
			@RequestParam MultipartFile archivo) throws Exception {
		logger.debug("Ingresa a editWithFoto()");

		if (!archivo.isEmpty()) {
			alumno.setFoto(archivo.getBytes());
		}
		
		Alumno alumnoAct = alumnoService.saveFotoPerfilAlumno(id, archivo);
		return new ResponseEntity<Alumno>(alumnoAct, HttpStatus.CREATED);
	}
	
	@GetMapping("/ultimo-legajo")
	public ResponseEntity<?> getUltimoLegajo() {
		logger.debug("Ingresa a getUltimoLegajo()");
		Long ultimoLegajo = alumnoService.obtenerUltimoLegajo();
		return new ResponseEntity<Long>(ultimoLegajo, HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> searchAlumnoByFilter(@RequestParam(value = "filter", required = true) String filter) {
		logger.debug("Ingresa a searchAlumnoByFilter()");
		List<Alumno> alumnosByFilter = new ArrayList<Alumno>();
		alumnosByFilter = alumnoService.obtenerAlumnosByFiltro(filter);
		return new ResponseEntity<List<Alumno>>(alumnosByFilter, HttpStatus.OK);
	}

	@GetMapping("/filtrar-alumnos/{termino}")
	public ResponseEntity<?> filtrarAlumnos(@PathVariable String termino) {
		logger.debug("Ingresa a filtrarAlumnos()");
		return ResponseEntity.ok(alumnoService.getAlumnosFiltrados(termino));
	}

}
