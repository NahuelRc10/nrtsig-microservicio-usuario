package nrt.microservicios.usuarios.app.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nrt.microservicios.commons.services.CommonServiceImpl;
import nrt.microservicios.main.commons.usuario.entity.Pais;
import nrt.microservicios.usuarios.app.models.repository.PaisRepository;
import nrt.microservicios.usuarios.app.services.PaisService;

@Service
public class PaisServiceImpl extends CommonServiceImpl<Pais, PaisRepository> implements PaisService {

	private static final Logger logger = LoggerFactory.getLogger(PaisServiceImpl.class);
	@Autowired
	private PaisRepository paisRepository;
	
	@Override
	public List<Pais> getPaisesOrdenados() {
		logger.debug("Ingresa a getPaisesOrdenados()");
		List<Pais> paises = paisRepository.findPaisesOrderByNombreAsc();
		return paises;
	}

}
