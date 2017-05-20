package br.usjt.arqdesis.sistemaPredial.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.sistemaPredial.model.Conjunto;
import br.usjt.arqdesis.sistemaPredial.service.ConjuntoService;

/**
 * Classe command para abrir a tela de cadastro
 * @author Hugo
 *
 */
public class CadastrarEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ConjuntoService cs = new ConjuntoService();
		
		List<Conjunto> conjuntosVagos = cs.carregarConjuntosVagos();
		
		request.setAttribute("conjuntosVagos", conjuntosVagos);

		RequestDispatcher view = request.getRequestDispatcher("CriarEmpresa.jsp");
		view.forward(request, response);
	}

}
