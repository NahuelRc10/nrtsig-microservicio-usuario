package nrt.microservicios.usuarios.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nrt.microservicios.commons.controllers.CommonController;
import nrt.microservicios.usuarios.app.models.entity.Pais;
import nrt.microservicios.usuarios.app.services.PaisService;

@RestController
@RequestMapping("/pais")
public class PaisController extends CommonController<Pais, PaisService> {

}
