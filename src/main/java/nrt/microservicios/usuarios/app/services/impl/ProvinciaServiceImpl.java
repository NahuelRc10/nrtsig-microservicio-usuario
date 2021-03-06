package nrt.microservicios.usuarios.app.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nrt.microservicios.commons.services.CommonServiceImpl;
import nrt.microservicios.main.commons.usuario.entity.Provincia;
import nrt.microservicios.usuarios.app.models.repository.ProvinciaRepository;
import nrt.microservicios.usuarios.app.services.ProvinciaService;

@Service
public class ProvinciaServiceImpl extends CommonServiceImpl<Provincia, ProvinciaRepository> implements ProvinciaService {

	private static final Logger logger = LoggerFactory.getLogger(ProvinciaServiceImpl.class);
	@Autowired
	private ProvinciaRepository provinciaRepository;
	
	@Override
	public List<Provincia> getProvinciasPorPais(Long idPais) throws Exception {
		logger.debug("Ingresa a getProvinciasPorPais()");
		List<Provincia> provincias = provinciaRepository.findProvincaByIdPais(idPais);
		if (provincias != null && !provincias.isEmpty()) {
			return provincias;
		} else {
			throw new Exception("No existen provincias para el pais seleccionado");
		}
	}

}
