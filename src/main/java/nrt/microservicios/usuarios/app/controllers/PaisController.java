package nrt.microservicios.usuarios.app.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nrt.microservicios.commons.controllers.CommonController;
import nrt.microservicios.main.commons.usuario.entity.Pais;
import nrt.microservicios.usuarios.app.services.PaisService;

@RestController
@RequestMapping("/pais")
public class PaisController extends CommonController<Pais, PaisService> {

	private static final Logger logger = LoggerFactory.getLogger(PaisController.class);
	@Autowired
	private PaisService paisService;
	
	@Override
	@GetMapping
	public ResponseEntity<?> listar() {
		logger.debug("Ingresa a listar()");
		List<Pais> paises = paisService.getPaisesOrdenados();
		return new ResponseEntity<List<Pais>>(paises, HttpStatus.OK);
	}
}
