package br.usjt.arqdesis.sistemaPredial.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.usjt.arqdesis.sistemaPredial.model.Conjunto;
import br.usjt.arqdesis.sistemaPredial.service.ConjuntoService;

public class ConjuntoTeste {
	Conjunto conjunto, copia;
	ConjuntoService conjuntoService;
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
		conjunto = new Conjunto();
		//idConjunto, numeroConjunto, idEmpresa
		conjunto.setIdConjunto(id);
		conjunto.setNumeroConjunto(101);
		conjunto.setIdEmpresa(9001);
		copia = new Conjunto();
		copia.setIdConjunto(id);
		copia.setNumeroConjunto(101);
		copia.setIdEmpresa(9001);
		conjuntoService = new ConjuntoService();
		System.out.println(conjunto);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Conjunto fixture = new Conjunto();
		fixture.setIdConjunto(1);
		fixture.setNumeroConjunto(101);
		fixture.setIdEmpresa(9001);
		ConjuntoService novoService = new ConjuntoService();
		Conjunto novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		conjuntoService.insert(conjunto);
		System.out.println(id);
		copia.setIdConjunto(id);
		assertEquals("testa criacao", conjunto, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		conjunto.setNumeroConjunto(101);
		copia.setNumeroConjunto(101);		
		conjuntoService.insert(conjunto);
		conjunto = conjuntoService.carregar(conjunto.getIdConjunto());
		assertEquals("testa atualizacao", conjunto, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setIdConjunto(-1);
		copia.setNumeroConjunto(-1);
		copia.setIdEmpresa(-1);
		conjuntoService.delete(id);
		conjunto = conjuntoService.carregar(id);
		assertEquals("testa exclusao", conjunto, copia);
	}
}
