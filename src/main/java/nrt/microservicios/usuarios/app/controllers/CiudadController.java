package nrt.microservicios.usuarios.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nrt.microservicios.commons.controllers.CommonController;
import nrt.microservicios.usuarios.app.models.entity.Ciudad;
import nrt.microservicios.usuarios.app.services.CiudadService;

@RestController
@RequestMapping("/ciudad")
public class CiudadController extends CommonController<Ciudad, CiudadService> {

	@Autowired
	private CiudadService ciudadService;
	
	@GetMapping("/{idProvincia}/ciudades")
	public ResponseEntity<?> listarCiudadesByProvincia(@PathVariable Long idProvincia) throws Exception {
		List<Ciudad> ciudades = ciudadService.getCiudadesByProvincia(idProvincia);
		return new ResponseEntity<List<Ciudad>>(ciudades, HttpStatus.OK);
	}
}
