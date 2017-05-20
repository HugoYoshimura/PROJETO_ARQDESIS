package br.usjt.arqdesis.sistemaPredial.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.sistemaPredial.model.Conjunto;
import br.usjt.arqdesis.sistemaPredial.model.Empresa;
import br.usjt.arqdesis.sistemaPredial.service.ConjuntoService;
import br.usjt.arqdesis.sistemaPredial.service.EmpresaService;

public class EditarEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpresaService empresaService = new EmpresaService();
		Empresa empresa = new Empresa();
		
		empresa.setIdEmpresa(Integer.parseInt(request.getParameter("id")));
		empresa.setRazaoSocial(request.getParameter("razaoSocial"));
		empresa.setNomeFantasia(request.getParameter("nomeFantasia"));
		empresa.setCnpj(request.getParameter("cnpj"));
		empresa.setTemperatura(Integer.parseInt(request.getParameter("temperatura")));
		empresa.setHorarioInicio(request.getParameter("horarioInicio"));
		empresa.setHorarioFim(request.getParameter("horarioFim"));
		empresa.setHorLigarAC(request.getParameter("horLigarAC"));
		empresa.setHorDesligarAC(request.getParameter("horDesligarAC"));
		
		String pConjuntos[] = request.getParameterValues("conjuntos");
		List<Conjunto> conjuntos = new ArrayList<Conjunto>();
		Conjunto conjunto;
		
		ConjuntoService conjuntoService = new ConjuntoService();
		conjuntos = conjuntoService.carregarConjuntosVagos();
		
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.add(empresa);
		lista.add(conjuntos);
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("EditarEmpresa.jsp");
		
		view.forward(request, response);
		
	}

}
