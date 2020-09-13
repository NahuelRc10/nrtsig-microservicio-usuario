package nrt.microservicios.usuarios.app.controllers;

import nrt.microservicios.usuarios.app.models.dto.DocenteDTO;
import nrt.microservicios.usuarios.app.models.dto.DocenteFiltrosDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nrt.microservicios.commons.controllers.CommonController;
import nrt.microservicios.main.commons.usuario.entity.Docente;
import nrt.microservicios.usuarios.app.services.DocenteService;

import java.util.List;

@RestController
@RequestMapping("/docente")
public class DocenteController extends CommonController<Docente, DocenteService> {

    private static final Logger logger = LoggerFactory.getLogger(DocenteController.class);
    @Autowired
    private DocenteService docenteService;

    @PostMapping("/search")
    public ResponseEntity<?> search(@RequestBody DocenteFiltrosDTO filtrosDto) {
        logger.debug("Ingresa a search()");
        List<Docente> docentes = docenteService.searchDocentes(filtrosDto);
        return new ResponseEntity<List<Docente>>(docentes, HttpStatus.OK);
    }

    @PostMapping("/add-docente")
    public ResponseEntity<?> addDocente(@RequestBody DocenteDTO dto) {
        logger.debug("Ingresa a addDocente()");
        try {
            Docente docente = docenteService.saveDocente(dto);
            return new ResponseEntity<Docente>(docente, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/generar-legajo-docente")
    public ResponseEntity<?> generarLegajo() {
        logger.debug("Ingresa a generarLegajo()");
        Long legajo = docenteService.getUltimoLegajoDocente();
        return new ResponseEntity<Long>(legajo, HttpStatus.OK);
    }

    @GetMapping("/obtener-docente/{id}")
    public ResponseEntity<?> obtenerDocenteById(@PathVariable Long id) {
        logger.debug("Ingresa a obtenerDocenteById()");
        DocenteDTO dto = docenteService.getDocenteById(id);
        return new ResponseEntity<DocenteDTO>(dto, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateDocente(@PathVariable Long id, @RequestBody DocenteDTO dto) throws Exception {
        logger.debug("Ingresa a updateDocente()");
        DocenteDTO docenteResponse = docenteService.actualizarDatosDocente(id, dto);
        return new ResponseEntity<DocenteDTO>(docenteResponse, HttpStatus.CREATED);
    }
}
