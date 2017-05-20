package br.usjt.arqdesis.sistemaPredial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.usjt.arqdesis.sistemaPredial.model.Usuario;

public class UsuarioDAO {
	/**
	 * Cadastra um usuário novo
	 * @param usuario Objeto usuário com dados do usuário a ser cadastrado
	 * @return Id do usuário cadastrado 
	 */
	public int criar(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuario(cpf, nome, login, senha, dataNascimento, sexo, endereco, cep, telefone, email, conta, acesso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		try {
			conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, usuario.getCpf());
			stm.setString(2, usuario.getNome());
			stm.setString(3, usuario.getLogin());
			stm.setString(4, usuario.getSenha());
			stm.setDate(5, new java.sql.Date(usuario.getDataNascimento().getTime()));
			stm.setString(6, usuario.getSexo());
			stm.setString(7, usuario.getEndereco());
			stm.setString(8, usuario.getCep());
			stm.setString(9, usuario.getTelefone());
			stm.setString(10, usuario.getEmail());
			stm.setString(11, usuario.getConta());
			stm.setString(12, usuario.getAcesso());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			stm = conn.prepareStatement(sqlQuery);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				usuario.setIdUsuario(rs.getInt(1));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario.getIdUsuario();
	}

	/**
	 * Atualiza dados do usuário
	 * @param usuario Objeto usuário com dados a serme atualizados
	 */
	public void atualizar(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET cpf = ?, nome = ?, login = ?, senha = ?, dataNascimento = ?, sexo = ?, endereco = ?, cep = ?, telefone = ?, email = ?, conta = ?, acesso = ? WHERE id_usuario = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, usuario.getCpf());
			stm.setString(2, usuario.getNome());
			stm.setString(3, usuario.getLogin());
			stm.setString(4, usuario.getSenha());
			stm.setDate(5, new java.sql.Date(usuario.getDataNascimento().getTime()));
			stm.setString(6, usuario.getSexo());
			stm.setString(7, usuario.getEndereco());
			stm.setString(8, usuario.getCep());
			stm.setString(9, usuario.getTelefone());
			stm.setString(10, usuario.getEmail());
			stm.setString(11, usuario.getConta());
			stm.setString(12, usuario.getAcesso());
			stm.setInt(13, usuario.getIdUsuario());
			stm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exclui usuário a partir do id informado
	 * @param id Id do usuário a ser excluído
	 */
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM usuario WHERE id_usuario = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Consulta usuário a partir do id informado
	 * @param id Id do usuário a ser consultado
	 * @return Objeto usuário com dados do usuário consultado
	 */
	public Usuario carregar(int id) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(id);
		String sqlSelect = "SELECT cpf, nome, login, senha, dataNascimento, sexo, endereco, cep, telefone, email, conta, acesso FROM usuario WHERE usuario.id_usuario = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuario.getIdUsuario());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setCpf(rs.getString("cpf"));
					usuario.setNome(rs.getString("nome"));
					usuario.setLogin(rs.getString("login"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setDataNascimento(rs.getDate("dataNascimento"));
					usuario.setSexo(rs.getString("sexo"));
					usuario.setEndereco(rs.getString("endereco"));
					usuario.setCep(rs.getString("cep"));
					usuario.setTelefone(rs.getString("telefone"));
					usuario.setEmail(rs.getString("email"));
					usuario.setConta(rs.getString("conta"));
					usuario.setAcesso(rs.getString("acesso"));
				} else {
					usuario.setIdUsuario(-1);
					usuario.setCpf(null);
					usuario.setNome(null);
					usuario.setLogin(null);
					usuario.setSenha(null);
					usuario.setDataNascimento(null);
					usuario.setSexo(null);
					usuario.setEndereco(null);
					usuario.setCep(null);
					usuario.setTelefone(null);
					usuario.setEmail(null);
					usuario.setConta(null);
					usuario.setAcesso(null);
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}

	/**
	 * Consulta todos os usuários cadastrados
	 * @return Lista de usuários cadastrados
	 */
	public List<Usuario> carregarTodosUsuarios() {
		Usuario usuario;

		List<Usuario> lista = new ArrayList<Usuario>();

		String sqlSelect = "SELECT id_usuario, cpf, nome, login, senha, dataNascimento, sexo, endereco, cep, telefone, email, conta, acesso FROM usuario;";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					usuario = new Usuario();
					usuario.setIdUsuario(rs.getInt("id_usuario"));
					usuario.setCpf(rs.getString("cpf"));
					usuario.setNome(rs.getString("nome"));
					usuario.setLogin(rs.getString("login"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setDataNascimento(rs.getDate("dataNascimento"));
					usuario.setSexo(rs.getString("sexo"));
					usuario.setEndereco(rs.getString("endereco"));
					usuario.setCep(rs.getString("cep"));
					usuario.setTelefone(rs.getString("telefone"));
					usuario.setEmail(rs.getString("email"));
					usuario.setConta(rs.getString("conta"));
					usuario.setAcesso(rs.getString("acesso"));
					
					lista.add(usuario);
				}
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
