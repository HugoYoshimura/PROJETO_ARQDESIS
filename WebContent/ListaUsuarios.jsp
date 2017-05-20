<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visualizar Usuários</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<c:import url="Menu.jsp"/>
	<h3 class="page-header">Lista de Usuários</h3>
	<form action="ManterUsuario" method="post">
	<table>
	
		<c:forEach var="usuario" items="${lista}">
			<tr>
				<td>${usuario.idUsuario}</td>
				<td>${usuario.cpf}</td>
				<td>${usuario.nome}</td>
				<td>${usuario.login}</td>
			</tr>
			<tr>
				<td>${usuario.sexo}</td>
				<td>${usuario.dataNascimento}</td>
				<td>${usuario.endereco}</td>
				<td>${usuario.cep}</td>
			</tr>
			<tr>
				<td>${usuario.telefone}</td>
				<td>${usuario.email}</td>
				<td>${usuario.conta}</td>
				<td>${usuario.acesso}</td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit" class="btn btn-primary btn-sm" name="action" value="select-${usuario.idUsuario}">Alterar</button></td>
				<td><button type="submit" class="btn btn-danger btn-sm" name="action" value="delete-${usuario.idUsuario}">Excluir</button></td>
				<td></td>
			</tr>
		</c:forEach>
	</table>
	<div id="actions" class="row">
		<div class="col-md-12">
			<a href="index.jsp" class="btn btn-default">Voltar</a>
		</div>
	</div>
	</form>
</body>
</html>