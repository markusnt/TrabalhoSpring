package br.una.veiculos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Morador extends Usuario  {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cpf;
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	@ElementCollection
	@CollectionTable(name="TELEFONE")
	private List<String> telefones = new ArrayList<>();
	
	public Morador() {
		
	}
	
	public Morador(Long id, String login, String senha, boolean eSindico, boolean eRoot, String nome, String cpf,
			Date dataNascimento, List<String> telefones) {
		super(id, login, senha, eSindico, eRoot);
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefones = telefones;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public List<String> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}
	
	
	
	
	
}
