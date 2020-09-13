package nrt.microservicios.usuarios.app.services.impl;

import
		nrt.microservicios.usuarios.app.models.dto.DocenteDTO;
import nrt.microservicios.usuarios.app.models.dto.DocenteFiltrosDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nrt.microservicios.commons.services.CommonServiceImpl;
import nrt.microservicios.main.commons.usuario.entity.Docente;
import nrt.microservicios.usuarios.app.models.repository.DocenteRepository;
import nrt.microservicios.usuarios.app.services.DocenteService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocenteServiceImpl extends CommonServiceImpl<Docente, DocenteRepository> implements DocenteService {

	private static final Logger logger = LoggerFactory.getLogger(DocenteServiceImpl.class);
	@Autowired
	private DocenteRepository docenteRepository;

	@Override
	public Long getUltimoLegajoDocente() {
		logger.debug("Ingresa a getUltimoLegajoDocente()");
		Long legajo = docenteRepository.getMaxLegajo();
		legajo++;
		return legajo;
	}

	@Override
	public boolean validaCuitDocente(String cuit, String dni, String sexo) {
		logger.debug("Ingresa a validaCuitDocente()");
		// Eliminamos todos los caracteres que no sean numeros
		cuit = cuit.replaceAll("[^\\d]", "");
		// Controllamos si son 11 numeros lo que quedaron, caso contrario return false
		if (cuit.length() != 11) {
			return false;
		}
		// Separamos en partes al cuit
		String primeraParteCuit = cuit.substring(0, 2);
		String segundaParteCuit = cuit.substring(2, 10);
		
		if (sexo.equalsIgnoreCase("M")) {
			if (!primeraParteCuit.equalsIgnoreCase("20")) {
				return false;
			}
		} else {
			if (!primeraParteCuit.equalsIgnoreCase("27")) {
				return false;
			}
		}
		// Validamos la segunda parte debe coincidir con el dni 
		if (!segundaParteCuit.equalsIgnoreCase(dni)) {
			return false;
		}
		// Si pasa todas las validaciones return true
		return true;	
	}

	@Override
	public List<Docente> searchDocentes(DocenteFiltrosDTO filtrosDTO) {
		List<Long> idList = new ArrayList<>();
		// Llamar al customRepository
		List<Docente> docentes = new ArrayList<>();
		return (List<Docente>) docenteRepository.findAllById(idList);
	}

	@Override
	public Docente saveDocente(DocenteDTO docenteDTO) throws Exception {
		logger.debug("Ingresa a saveDocente()");
		// Validamos que el docente no exista en la base
		Long idDocente = docenteRepository.getIdDocenteByTipoDocumentoAndNumeroDocumento(docenteDTO.getTipoDocumento(), docenteDTO.getNumeroDocumento());
		if (idDocente != null) {
			throw new Exception("El docente ya existe!");
		}

		// Validamos que el cuit sea correcto
		boolean validaCuit = validaCuitDocente(docenteDTO.getCuit(), docenteDTO.getNumeroDocumento().toString(), docenteDTO.getSexo());
		if (!validaCuit) {
			throw new Exception("El cuit no es valido");
		}

		Docente docente = dtoToEntity(docenteDTO);

		return docenteRepository.save(docente);
	}

	@Override
	public DocenteDTO getDocenteById(Long id) {
		logger.debug("Ingresa a getDocenteById()");
		Docente docente = docenteRepository.findDocenteById(id);
		if (docente == null) {
			return null;
		}
		DocenteDTO dto = entityToDto(docente);
		return dto;
	}

	@Override
	public DocenteDTO actualizarDatosDocente(Long id, DocenteDTO dto) throws Exception {
		logger.debug("Ingresa a actualizarDocente()");
		Docente docente = docenteRepository.findDocenteById(id);
		if (docente == null) {
			throw new Exception("El Docente que quiere actualizar no existe en la base de datos!");
		}
		// Actualizamos los datos
		docente.setEmail(dto.getEmail());
		docenteRepository.save(docente);
		return entityToDto(docente);
	}

	private Docente dtoToEntity(DocenteDTO dto) {
		Docente entity = new Docente();
		entity.setNombre(dto.getNombre());
		entity.setApellido(dto.getApellido());
		entity.setTipoDocumento(dto.getTipoDocumento());
		entity.setNumeroDocumento(dto.getNumeroDocumento());
		entity.setSexo(dto.getSexo());
		entity.setCuit(dto.getCuit());
		entity.setEmail(dto.getEmail());
		entity.setLegajo(dto.getLegajo());
		return entity;
	}

	private DocenteDTO entityToDto(Docente entity) {
		DocenteDTO dto = new DocenteDTO();
		dto.setId(entity.getId());
		dto.setLegajo(entity.getLegajo());
		dto.setTipoDocumento(entity.getTipoDocumento());
		dto.setNumeroDocumento(entity.getNumeroDocumento());
		dto.setNombre(entity.getNombre());
		dto.setApellido(entity.getApellido());
		dto.setCuit(entity.getCuit());
		dto.setCreateAt(entity.getCreateAt());
		dto.setEmail(entity.getEmail());
		dto.setSexo(entity.getSexo());
		return dto;
	}
}
