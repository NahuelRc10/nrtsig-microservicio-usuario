package nrt.microservicios.usuarios.app.services.impl;

import org.springframework.stereotype.Service;

import nrt.microservicios.commons.services.CommonServiceImpl;
import nrt.microservicios.usuarios.app.models.entity.Pais;
import nrt.microservicios.usuarios.app.models.repository.PaisRepository;
import nrt.microservicios.usuarios.app.services.PaisService;

@Service
public class PaisServiceImpl extends CommonServiceImpl<Pais, PaisRepository> implements PaisService {

}
