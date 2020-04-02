package nrt.microservicios.usuarios.app.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "domicilios")
public class Domicilio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "direccion")
	@NotEmpty
	private String direccion;
	@Column(name = "numero")
	@NotNull
	private Integer numero;
	@Column(name = "nro_departamento")
	private Integer nroDepartamento;
	@Column(name = "nro_piso")
	private Integer nroPiso;
	@Column(name = "create_at")
	private Date createAt;
	@ManyToOne
	@JoinColumn(name = "id_ciudad")
	private Ciudad ciudad;

	public Domicilio() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getNroDepartamento() {
		return nroDepartamento;
	}

	public void setNroDepartamento(Integer nroDepartamento) {
		this.nroDepartamento = nroDepartamento;
	}

	public Integer getNroPiso() {
		return nroPiso;
	}

	public void setNroPiso(Integer nroPiso) {
		this.nroPiso = nroPiso;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
}
