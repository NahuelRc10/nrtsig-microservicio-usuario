package nrt.microservicios.usuarios.app.services;

import java.util.List;

import nrt.microservicios.commons.services.CommonService;
import nrt.microservicios.main.commons.usuario.entity.Provincia;

public interface ProvinciaService extends CommonService<Provincia> {

	public List<Provincia> getProvinciasPorPais(Long idPais) throws Exception;
}
