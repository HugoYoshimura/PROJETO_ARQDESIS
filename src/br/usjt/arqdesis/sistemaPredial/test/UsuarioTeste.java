package br.usjt.arqdesis.sistemaPredial.test;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.usjt.arqdesis.sistemaPredial.model.Usuario;
import br.usjt.arqdesis.sistemaPredial.service.UsuarioService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioTeste {
	Usuario usuario, copia;
	UsuarioService usuarioService;
	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	static int id = 0;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Cliente. 
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		usuario = new Usuario();
		usuario.setIdUsuario(id);
		usuario.setCpf("123.456.789-00");
		usuario.setNome("Hugo Yoshimura");
		usuario.setLogin("Hugo.Yoshimura");
		usuario.setSenha("Hugo.Yoshimura");
		usuario.setDataNascimento(formatter.parse("06/05/1990"));
		usuario.setSexo("M");
		usuario.setEndereco("Avenida Vital Brasil, 1000");
		usuario.setCep("01234-010");
		usuario.setTelefone("(11)1234-5678");
		usuario.setConta("SINDICO");
		usuario.setAcesso("LIVRE");
		copia = new Usuario();
		copia.setIdUsuario(id);
		copia.setCpf("123.456.789-00");
		copia.setNome("Hugo Yoshimura");
		copia.setLogin("Hugo.Yoshimura");
		copia.setSenha("Hugo.Yoshimura");
		copia.setDataNascimento(formatter.parse("06/05/1990"));
		copia.setSexo("M");
		copia.setEndereco("Avenida Vital Brasil, 1000");
		copia.setCep("01234-010");
		copia.setTelefone("(11)1234-5678");
		copia.setConta("SINDICO");
		copia.setAcesso("LIVRE");
		usuarioService = new UsuarioService();
		System.out.println(usuario);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Usuario fixture = new Usuario();
		fixture.setIdUsuario(1);
		fixture.setCpf("123.456.789-00");
		fixture.setNome("Hugo Yoshimura");
		fixture.setLogin("Hugo.Yoshimura");
		fixture.setSenha("Hugo.Yoshimura");
		try {
			fixture.setDataNascimento(formatter.parse("06/05/1990"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fixture.setSexo("M");
		fixture.setEndereco("Avenida Vital Brasil, 1000");
		fixture.setCep("01234-010");
		fixture.setTelefone("(11)1234-5678");
		fixture.setConta("SINDICO");
		fixture.setAcesso("LIVRE");
		UsuarioService novoService = new UsuarioService();
		Usuario novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = usuarioService.criar(usuario);
		System.out.println(id);
		copia.setIdUsuario(id);
		assertEquals("testa criacao", usuario, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		usuario.setEndereco("Rua Salvador Garcia");
		copia.setEndereco("Rua Salvador Garcia");		
		usuarioService.atualizar(usuario);
		usuario = usuarioService.carregar(usuario.getIdUsuario());
		assertEquals("testa atualizacao", usuario, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setIdUsuario(-1);
		copia.setCpf(null);
		copia.setNome(null);
		copia.setLogin(null);
		copia.setSenha(null);
		try {
			copia.setDataNascimento(formatter.parse("06/05/1990"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		copia.setSexo(null);
		copia.setEndereco(null);
		copia.setCep(null);
		copia.setTelefone(null);
		copia.setConta(null);
		copia.setAcesso(null);
		usuarioService.excluir(id);
		usuario = usuarioService.carregar(id);
		assertEquals("testa exclusao", usuario, copia);
	}

}
