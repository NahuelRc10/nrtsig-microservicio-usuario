package nrt.microservicios.usuarios.app.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nrt.microservicios.commons.controllers.CommonController;
import nrt.microservicios.main.commons.usuario.entity.Ciudad;
import nrt.microservicios.usuarios.app.services.CiudadService;

@RestController
@RequestMapping("/ciudad")
public class CiudadController extends CommonController<Ciudad, CiudadService> {

	private static final Logger logger = LoggerFactory.getLogger(CiudadController.class);
	@Autowired
	private CiudadService ciudadService;
	
	@GetMapping("/{idProvincia}/ciudades")
	public ResponseEntity<?> listarCiudadesByProvincia(@PathVariable Long idProvincia) throws Exception {
		logger.debug("Ingresa a listarCiudadesByProvincia()");
		List<Ciudad> ciudades = ciudadService.getCiudadesByProvincia(idProvincia);
		return new ResponseEntity<List<Ciudad>>(ciudades, HttpStatus.OK);
	}
}
