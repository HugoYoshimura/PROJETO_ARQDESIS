package br.usjt.arqdesis.sistemaPredial.model;

import java.util.List;

public class Empresa {

	private int idEmpresa, temperatura;
	private List<Conjunto> conjuntos;
	private String cnpj, razaoSocial, nomeFantasia, horarioInicio, horarioFim, horLigarAC, horDesligarAC;

	public Empresa() {

	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(String horarioFim) {
		this.horarioFim = horarioFim;
	}

	public String getHorLigarAC() {
		return horLigarAC;
	}

	public void setHorLigarAC(String horLigarAC) {
		this.horLigarAC = horLigarAC;
	}

	public String getHorDesligarAC() {
		return horDesligarAC;
	}

	public void setHorDesligarAC(String horDesligarAC) {
		this.horDesligarAC = horDesligarAC;
	}

	public List<Conjunto> getConjuntos() {
		return conjuntos;
	}

	public void setConjuntos(List<Conjunto> conjuntos) {
		this.conjuntos = conjuntos;
	}
	
	public void addConjunto(Conjunto conjunto) {
		this.conjuntos.add(conjunto);
	}
}
