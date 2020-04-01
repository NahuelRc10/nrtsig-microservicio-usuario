package nrt.microservicios.usuarios.app.services.impl;

import org.springframework.stereotype.Service;

import nrt.microservicios.commons.services.CommonServiceImpl;
import nrt.microservicios.usuarios.app.models.entity.Alumno;
import nrt.microservicios.usuarios.app.models.repository.AlumnoRepository;
import nrt.microservicios.usuarios.app.services.AlumnoService;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

}
