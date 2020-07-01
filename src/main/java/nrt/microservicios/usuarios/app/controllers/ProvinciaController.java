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
import nrt.microservicios.main.commons.usuario.entity.Provincia;
import nrt.microservicios.usuarios.app.services.ProvinciaService;

@RestController
@RequestMapping("/provincia")
public class ProvinciaController extends CommonController<Provincia, ProvinciaService> {

	private static final Logger logger = LoggerFactory.getLogger(ProvinciaController.class);
	@Autowired
	private ProvinciaService provinciaService;
	
	@GetMapping("/{idPais}/provincias")
	public ResponseEntity<?> listarProvinciasPorPais(@PathVariable Long idPais) throws Exception{
		logger.debug("Ingresa a listarProvinciasPorPais()");
		List<Provincia> provincias = provinciaService.getProvinciasPorPais(idPais);
		return new ResponseEntity<List<Provincia>>(provincias, HttpStatus.OK);
	}
}
