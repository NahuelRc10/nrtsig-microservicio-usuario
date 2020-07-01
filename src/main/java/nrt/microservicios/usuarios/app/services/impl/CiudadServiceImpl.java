package nrt.microservicios.usuarios.app.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nrt.microservicios.commons.services.CommonServiceImpl;
import nrt.microservicios.main.commons.usuario.entity.Ciudad;
import nrt.microservicios.usuarios.app.models.repository.CiudadRepository;
import nrt.microservicios.usuarios.app.services.CiudadService;

@Service
public class CiudadServiceImpl extends CommonServiceImpl<Ciudad, CiudadRepository> implements CiudadService {

	private static final Logger logger = LoggerFactory.getLogger(CiudadServiceImpl.class);
	@Autowired
	private CiudadRepository ciudadRepository;
	
	@Override
	public List<Ciudad> getCiudadesByProvincia(Long idProvincia) throws Exception {
		logger.debug("Ingresar getCiudadesByProvincia()");
		List<Ciudad> ciudades = ciudadRepository.findCiudadByIdProvincia(idProvincia);
		if (ciudades != null && !ciudades.isEmpty()) {
			return ciudades;
		} else {
			throw new Exception("No existen ciudades para la provincia seleccionada");
		}
	}
}
