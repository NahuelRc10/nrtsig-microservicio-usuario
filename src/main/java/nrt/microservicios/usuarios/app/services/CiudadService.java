package nrt.microservicios.usuarios.app.services;

import java.util.List;

import nrt.microservicios.commons.services.CommonService;
import nrt.microservicios.usuarios.app.models.entity.Ciudad;

public interface CiudadService extends CommonService<Ciudad> {

	public List<Ciudad> getCiudadesByProvincia(Long idProvincia) throws Exception;
}
