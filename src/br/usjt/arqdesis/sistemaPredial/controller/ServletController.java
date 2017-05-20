package br.usjt.arqdesis.sistemaPredial.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.sistemaPredial.command.Command;

@WebServlet("/controller.do")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request, response);
	}
	
	protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			Command comando = (Command)Class.forName("br.usjt.arqdesis.sistemaPredial.command." + request.getParameter("command")).newInstance();
			comando.executar(request, response);
		} catch(InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
