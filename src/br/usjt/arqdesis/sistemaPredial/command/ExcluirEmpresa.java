package br.usjt.arqdesis.sistemaPredial.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.sistemaPredial.model.Empresa;
import br.usjt.arqdesis.sistemaPredial.service.EmpresaService;

public class ExcluirEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EmpresaService es = new EmpresaService();
		
		es.excluir(Integer.parseInt(request.getParameter("id")));
		List<Empresa> lista = new ArrayList<Empresa>();
		lista = es.carregarTodasEmpresas();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarEmpresas.jsp");
		
		view.forward(request, response);
	}
}
