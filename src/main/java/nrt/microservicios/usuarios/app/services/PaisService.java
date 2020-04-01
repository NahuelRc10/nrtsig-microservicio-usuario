package nrt.microservicios.usuarios.app.services;

import java.util.List;

import nrt.microservicios.commons.services.CommonService;
import nrt.microservicios.usuarios.app.models.entity.Pais;

public interface PaisService extends CommonService<Pais> {

	public List<Pais> getPaisesOrdenados();
}
