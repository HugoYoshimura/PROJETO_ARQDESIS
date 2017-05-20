<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.jsp">Sistema Controle
					Predial</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="disable"><a href="index.jsp">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Usuário<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="user.jsp">Cadastrar</a></li>
						<li><a href="usuario.html">Controle</a></li>
						<li><a href="ListarUsuario.do">Lista</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Empresa<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="controller.do?command=CadastrarEmpresa" >Cadastrar</a></li>
						<li><a href="empresa.html">Controle</a></li>
						<li><a href="controller.do?command=VisualizarEmpresa">Lista</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>