package nrt.microservicios.usuarios.app.services;

import nrt.microservicios.commons.services.CommonService;
import nrt.microservicios.main.commons.usuario.entity.Docente;
import nrt.microservicios.usuarios.app.models.dto.DocenteDTO;
import nrt.microservicios.usuarios.app.models.dto.DocenteFiltrosDTO;

import java.util.List;

public interface DocenteService extends CommonService<Docente> {

	public Long getUltimoLegajoDocente();
	public boolean validaCuitDocente(String cuit, String dni, String sexo);
	public List<Docente> searchDocentes(DocenteFiltrosDTO filtrosDTO);
	public Docente saveDocente(DocenteDTO docenteDTO) throws Exception;
	public DocenteDTO getDocenteById(Long id);
	public DocenteDTO actualizarDatosDocente(Long id, DocenteDTO dto) throws Exception;
}
