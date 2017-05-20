package br.usjt.arqdesis.sistemaPredial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.RE;

import br.usjt.arqdesis.sistemaPredial.model.Conjunto;

public class ConjuntoDAO {
	
	/**
	 * Alterar conjunto com os dados da empresa
	 * @param conjunto objeto conjunto com o número do conjunto
	 */
	public void criar(Conjunto conjunto) {
		String sqlUpdate = "UPDATE conjunto SET status = ?, id_empresa = ? WHERE numeroConjunto = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, 1);
			stm.setInt(2, conjunto.getIdEmpresa());
			stm.setInt(3, conjunto.getNumeroConjunto());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Alterar conjunto retirando os dados da empresa
	 * @param conjunto objeto conjunto com o número do conjunto
	 */
	public void excluir(Conjunto conjunto) {
		String sqlUpdate = "UPDATE conjunto SET status = ?, id_empresa = ? WHERE numeroConjunto = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, 0);
			stm.setNull(2, Types.INTEGER);
			stm.setInt(3, conjunto.getNumeroConjunto());
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Consultar conjunto a partir do número do conjunto
	 * @param numeroConjunto Número do conjunto a ser consultado
	 * @return Objeto conjunto com os dados do conjunto consultado
	 */
	public Conjunto carregar(int numeroConjunto) {
		Conjunto conjunto = new Conjunto();
		String sqlSelect = "SELECT id_conjunto, status, id_empresa FROM conjunto WHERE conjunto.numeroConjunto = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			conjunto.setNumeroConjunto(numeroConjunto);
			stm.setInt(1, numeroConjunto);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
						conjunto.setIdConjunto(rs.getInt("id_conjunto"));
					if(rs.getInt("status") == 1) {
						conjunto.setStatus(true);
					} else {
						conjunto.setStatus(false);
					}
					conjunto.setIdEmpresa(rs.getInt("id_empresa"));
					
				} else {
					conjunto.setIdConjunto(0);
					conjunto.setNumeroConjunto(0);
					conjunto.setStatus(false);
					conjunto.setIdEmpresa(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return conjunto;
	}
	
	/**
	 * Carrega todos os conjuntos vagos
	 * @return Lista de conjuntos com todos o conjuntos vagos
	 */
	public List<Conjunto> carregarConjuntosVagos() {
		Conjunto conjunto;
		
		List<Conjunto> lista = new ArrayList<Conjunto>();
		
		String sqlSelect = "SELECT * from conjunto WHERE status = 0 ORDER BY numeroConjunto";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					conjunto = new Conjunto();
					conjunto.setIdConjunto(rs.getInt("id_conjunto"));
					conjunto.setNumeroConjunto(rs.getInt("numeroConjunto"));
					conjunto.setIdEmpresa(rs.getInt("id_empresa"));
					if(rs.getBoolean("status")) {
						conjunto.setStatus(true);
					} else {
						conjunto.setStatus(false);
					}
					
					lista.add(conjunto);
				}
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Carrega todos os conjuntos ocupados
	 * @return Lista de conjuntos com todos o conjuntos ocupados
	 */
	public List<Conjunto> carregarConjuntosOcupados() {
		Conjunto conjunto;
		
		List<Conjunto> lista = new ArrayList<Conjunto>();
		
		String sqlSelect = "SELECT * from conjunto WHERE status = TRUE ORDER BY numeroConjunto";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					conjunto = new Conjunto();
					conjunto.setIdConjunto(rs.getInt("id_conjunto"));
					conjunto.setNumeroConjunto(rs.getInt("numeroConjunto"));
					conjunto.setIdEmpresa(rs.getInt("id_empresa"));
					if(rs.getBoolean("status")) {
						conjunto.setStatus(true);
					} else {
						conjunto.setStatus(false);
					}
					
					lista.add(conjunto);
				}
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Carregar todos os conjuntos utilizados por uma empresa 
	 * @param idEmpresa id da empresa
	 * @return Lista de conjuntos utilizados pela empresa do id informado 
	 */
	public List<Conjunto> carregarConjuntosEmpresa(int idEmpresa) {
		Conjunto conjunto;
		
		List<Conjunto> lista = new ArrayList<Conjunto>();
		
		String sqlSelect = "SELECT * FROM conjunto WHERE id_empresa = ? ORDER BY numeroConjunto";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect); ) {
			try(ResultSet rs = stm.executeQuery()) {
				while(rs.next()) {
					conjunto = new Conjunto();
					conjunto.setIdConjunto(rs.getInt("id_conjunto"));
					conjunto.setNumeroConjunto(rs.getInt("numeroConjunto"));
					conjunto.setStatus(true);
					conjunto.setIdEmpresa(rs.getInt("id_empresa"));
					
					lista.add(conjunto);
				}
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Carregar todos os conjuntos utilizados por uma empresa 
	 * @param idEmpresa id da empresa
	 * @return Lista de conjuntos utilizados pela empresa do id informado 
	 */
	public List<Conjunto> carregarConjuntosEmpresaEVagos(int idEmpresa) {
		Conjunto conjunto;
		
		List<Conjunto> lista = new ArrayList<Conjunto>();
		
		String sqlSelect = "SELECT * FROM conjunto WHERE id_empresa = ? OR status = FALSE ORDER BY numeroConjunto";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect); ) {
			try(ResultSet rs = stm.executeQuery()) {
				while(rs.next()) {
					conjunto = new Conjunto();
					conjunto.setIdConjunto(rs.getInt("id_conjunto"));
					conjunto.setNumeroConjunto(rs.getInt("numeroConjunto"));
					conjunto.setStatus(true);
					conjunto.setIdEmpresa(rs.getInt("id_empresa"));
					
					lista.add(conjunto);
				}
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Criar um conjunto novo
	 * @param conjunto conjunto com dados do conjunto novo
	 */
	public void insert(Conjunto conjunto) {
		String sqlInsert = "INSERT INTO conjunto(numeroConjunto, status) VALUES (?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, conjunto.getNumeroConjunto());
			if(conjunto.isStatus()) {
				stm.setInt(2, 1);
			} else {
				stm.setInt(2, 0);
			}
			stm.setInt(3, conjunto.getIdEmpresa());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					conjunto.setIdConjunto(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza os dados do conjunto
	 * @param conjunto Objeto com dados a serem atualizados
	 */
	public void update(Conjunto conjunto) {
		String sqlUpdate = "UPDATE conjunto SET numeroConjunto = ?, status = ?, id_empresa = ? WHERE id_conjunto = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, conjunto.getNumeroConjunto());
			if(conjunto.isStatus()){
				stm.setInt(2, 1);
			} else {
				stm.setInt(2, 0);
			}
			stm.setInt(3, conjunto.getIdEmpresa());
			stm.setInt(4, conjunto.getIdConjunto());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exclui um conjunto
	 * @param numeroConjunto Número do conjunto a ser excluído
	 */
	public void delete(int numeroConjunto) {
		String sqlDelete = "DELETE FROM conjunto WHERE numeroConjunto = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, numeroConjunto);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
