package nrt.microservicios.usuarios.app.controllers;

import java.util.List;

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

	@Autowired
	private PaisService paisService;
	
	@Override
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Pais> paises = paisService.getPaisesOrdenados();
		return new ResponseEntity<List<Pais>>(paises, HttpStatus.OK);
	}
}
