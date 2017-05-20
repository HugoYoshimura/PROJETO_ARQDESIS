package br.usjt.arqdesis.sistemaPredial.service;

import java.util.List;

import br.usjt.arqdesis.sistemaPredial.dao.ConjuntoDAO;
import br.usjt.arqdesis.sistemaPredial.model.Conjunto;

public class ConjuntoService {
	ConjuntoDAO dao = new ConjuntoDAO();
	
	/**
	 * Alterar conjunto com os dados da empresa
	 * @param conjunto objeto conjunto com o número do conjunto
	 */
	public void criar(Conjunto conjunto) {
		dao.criar(conjunto);
	}
	
	/**
	 * Alterar conjunto retirando os dados da empresa
	 * @param conjunto objeto conjunto com o número do conjunto
	 */
	public void excluir(Conjunto conjunto) {
		dao.excluir(conjunto);
	}
	
	/**
	 * Consultar conjunto a partir do número do conjunto
	 * @param numeroConjunto Número do conjunto a ser consultado
	 * @return Objeto conjunto com os dados do conjunto consultado
	 */
	public Conjunto carregar(int numeroConjunto) {
		return dao.carregar(numeroConjunto);
	}
	
	/**
	 * Carrega todos os conjuntos vagos
	 * @return Lista de conjuntos com todos o conjuntos vagos
	 */
	public List<Conjunto> carregarConjuntosVagos() {
		return dao.carregarConjuntosVagos();
	}
	
	/**
	 * Carrega todos os conjuntos ocupados
	 * @return Lista de conjuntos com todos o conjuntos ocupados
	 */
	public List<Conjunto> carregarConjuntosOcupados() {
		return dao.carregarConjuntosOcupados();
	}
	
	/**
	 * Carregar todos os conjuntos utilizados por uma empresa 
	 * @param idEmpresa id da empresa
	 * @return Lista de conjuntos utilizados pela empresa do id informado 
	 */
	public List<Conjunto> carregarConjuntosEmpresa(int idEmpresa) {
		return dao.carregarConjuntosEmpresa(idEmpresa);
	}
	
	/**
	 * Carregar todos os conjuntos utilizados por uma empresa e os conjuntos vagos 
	 * @param idEmpresa id da empresa
	 * @return Lista de conjuntos utilizados pela empresa do id informado 
	 */
	public List<Conjunto> carregarConjuntosEmpresaEVagos(int idEmpresa) {
		return dao.carregarConjuntosEmpresaEVagos(idEmpresa);
	}
	
	/**
	 * Criar um conjunto novo
	 * @param conjunto conjunto com dados do conjunto novo
	 */
	public void insert(Conjunto conjunto) {
		dao.insert(conjunto);
	}
	
	/**
	 * Atualiza os dados do conjunto
	 * @param conjunto Objeto com dados a serem atualizados
	 */
	public void update(Conjunto conjunto) {
		dao.update(conjunto);
	}
	
	/**
	 * Exclui um conjunto
	 * @param numeroConjunto Número do conjunto a ser excluído
	 */
	public void delete(int numeroConjunto) {
		dao.delete(numeroConjunto);
	}
}
