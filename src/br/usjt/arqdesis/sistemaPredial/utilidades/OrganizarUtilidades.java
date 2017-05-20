package br.usjt.arqdesis.sistemaPredial.utilidades;

public class OrganizarUtilidades {
	
	/**
	 * Ordena vetor de int informado por parametro
	 * @param vetor Vetor de int a ser ordenado  
	 */
	public void quick(int[] vetor) {
		quick(vetor, 0, vetor.length - 1);
	}
	
	public void quick(int[] vetor, int esquerda, int direita) {
		int indice = particao(vetor, esquerda, direita);
		if(esquerda < indice - 1) {
			quick(vetor, esquerda, indice - 1);
		}
		if(indice < direita) {
			quick(vetor, indice, direita);
		}
	}
	
	public int particao(int[] vetor, int esquerda, int direita) {
		int i = esquerda, j = esquerda;
		int aux, pivo = vetor[(esquerda + direita) / 2];
		while (i <= j) {
			while (vetor[i] < pivo) {
				i++;
			}
			while (vetor[j] > pivo) {
				j--;
			}
			if (i <= j) {
				aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;
				i++;
				j--;
			}
		}
		return i;
	}
	
	
}
