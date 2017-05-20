package br.usjt.arqdesis.sistemaPredial.model;

import java.util.List;

public class Conjunto {
	
	private int idConjunto, numeroConjunto, idEmpresa;
	private boolean status;	
	
	public Conjunto() {
		
	}

	public int getIdConjunto() {
		return idConjunto;
	}

	public void setIdConjunto(int idConjunto) {
		this.idConjunto = idConjunto;
	}

	public int getNumeroConjunto() {
		return numeroConjunto;
	}

	public void setNumeroConjunto(int numeroConjunto) {
		this.numeroConjunto = numeroConjunto;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String conjuntosString(List<Conjunto> conjuntos) {
		String result = "";
		if (conjuntos.size() > 0) {
			for (int i = 0; i < conjuntos.size(); i++) {
				result += conjuntos.get(i).getNumeroConjunto() + " ";
			}
		}
		return result;
	}
}
