package nrt.microservicios.usuarios.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nrt.microservicios.commons.services.CommonServiceImpl;
import nrt.microservicios.usuarios.app.models.entity.Domicilio;
import nrt.microservicios.usuarios.app.models.repository.DomicilioRepository;
import nrt.microservicios.usuarios.app.services.DomicilioService;

@Service
public class DomicilioServiceImpl extends CommonServiceImpl<Domicilio, DomicilioRepository> implements DomicilioService {

	@Autowired
	private DomicilioRepository domicilioRepository;
}
