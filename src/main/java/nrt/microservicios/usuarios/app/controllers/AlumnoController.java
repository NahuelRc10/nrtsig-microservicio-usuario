package nrt.microservicios.usuarios.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nrt.microservicios.commons.controllers.CommonController;
import nrt.microservicios.usuarios.app.models.entity.Alumno;
import nrt.microservicios.usuarios.app.services.AlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController extends CommonController<Alumno, AlumnoService> {

	@Autowired
	private AlumnoService alumnoService;
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarAlumno(@Valid @RequestBody Alumno alumno, BindingResult result, @PathVariable Long id) throws Exception {
		// Validamos las restricciones de las propiedades del entity Alumno
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Alumno alumnoAct = alumnoService.actualizarAlumno(alumno, id);
		return new ResponseEntity<Alumno>(alumnoAct, HttpStatus.CREATED);
	}
	
	@GetMapping("/ultimo-legajo")
	public ResponseEntity<?> getUltimoLegajo() {
		Long ultimoLegajo = alumnoService.obtenerUltimoLegajo();
		return new ResponseEntity<Long>(ultimoLegajo, HttpStatus.OK);
	}
	
}