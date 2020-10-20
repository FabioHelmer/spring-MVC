package com.example.demo.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "rh_departamentos")

public class Departamento {

	@Id
	@Column(name = "id", nullable = false, unique = true, length = 20)
	private String id;

	@NotBlank(message = "Nome obrigatorio")
	@Length(max = 60, min = 3, message = " Nome deve ter entre 3 á 60 caracteres")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;

	@Column(name = "codigo", nullable = false, unique = true, length = 4)
	private String codigo;

	@OneToMany(mappedBy = "departamento")
	private List<Cargo> cargos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
