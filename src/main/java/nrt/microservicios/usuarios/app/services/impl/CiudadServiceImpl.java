package nrt.microservicios.usuarios.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nrt.microservicios.commons.services.CommonServiceImpl;
import nrt.microservicios.usuarios.app.models.entity.Ciudad;
import nrt.microservicios.usuarios.app.models.repository.CiudadRepository;
import nrt.microservicios.usuarios.app.services.CiudadService;

@Service
public class CiudadServiceImpl extends CommonServiceImpl<Ciudad, CiudadRepository> implements CiudadService {

	@Autowired
	private CiudadRepository ciudadRepository;
	
	@Override
	public List<Ciudad> getCiudadesByProvincia(Long idProvincia) throws Exception {
		List<Ciudad> ciudades = ciudadRepository.findCiudadByIdProvincia(idProvincia);
		if (ciudades != null && !ciudades.isEmpty()) {
			return ciudades;
		} else {
			throw new Exception("No existen ciudades para la provincia seleccionada");
		}
	}
}
