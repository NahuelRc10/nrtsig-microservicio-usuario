package nrt.microservicios.usuarios.app.services.impl;

import org.springframework.stereotype.Service;

import nrt.microservicios.commons.services.CommonServiceImpl;
import nrt.microservicios.usuarios.app.models.entity.Provincia;
import nrt.microservicios.usuarios.app.models.repository.ProvinciaRepository;
import nrt.microservicios.usuarios.app.services.ProvinciaService;

@Service
public class ProvinciaServiceImpl extends CommonServiceImpl<Provincia, ProvinciaRepository> implements ProvinciaService {

}
