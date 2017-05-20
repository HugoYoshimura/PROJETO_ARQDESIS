<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cadastro Usuário</title>

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$(".data").datepicker(
						{
							dateFormat : 'dd/mm/yy',
							dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado',
									'Domingo' ],
							dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
							dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb', 'Dom' ],
							monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho',
									'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro' ],
							monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out',
									'Nov', 'Dez' ],
							nextText : 'Próximo',
							prevText : 'Anterior'
						});
			});
</script>

</head>

<body>
	<c:import url="Menu.jsp"/>
	<div id="main" class="container">
		<h3 class="page-header">Cadastrar Usuário</h3>
		<!-- Formulario para inclusao de clientes -->
		<form action="ManterUsuario" method="post">
			<div class="row">
				<div class="form-group col-md-8">
					<label for="nome">Nome</label> <input type="text"
						class="form-control" name="nome" id="nome" maxlength="45"
						placeholder="Digite o nome completo" required>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-4">
					<label for="login">Login</label> <input type="text"
						class="form-control" name="login" id="login" maxlength="45"
						placeholder="Digite o login" required>
				</div>

				<div class="form-group col-md-4">
					<label for="senha">Senha</label> <input type="password"
						class="form-control" name="senha" id="senha" maxlength="10"
						pattern="[a-zA-Z0-9!@#$%&*-_+= .;,?/ãâáàÁÀéèêÉÈÊíìÍÌõóòÕÓÒúùÚÙçÇ]{6,10}" placeholder="Digite a senha. De 6 a 10 caracteres." required>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-3">
					<label for="cpf">CPF</label> <input type="text"
						class="form-control" name="cpf" id="cpf" required maxlength="11"
						pattern="\d{11}" placeholder="CPF, apenas números.">
				</div>

				<div class="form-group col-md-3">
					<label for="data">Data de Nascimento</label> <input type="date" name="data" id="data"
						data-provide="datepicker" class="form-control data" required>

				</div>


				<div class="form-group col-md-2">
					<label for="sexo">Sexo</label> <select id="sexo" name="sexo">
						<option value="feminino">Feminino</option>
						<option value="masculino">Masculino</option>
					</select>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-3">
					<label for="enderecoLb">Endereço</label> <input type="text"
						class="form-control" name="endereco" id="endereco" maxlength="60"
						placeholder="Endereço completo" required>
				</div>

				<div class="form-group col-md-3">
					<label for="cep">CEP</label> <input type="text"
						class="form-control" name="cep" id="cep" required maxlength="8"
						pattern="\d{8}" placeholder="CEP, apenas numeros">
				</div>

				<div class="form-group col-md-3">
					<label for="telefoneLb">Celular</label> <input type="tel"
						class="form-control" name="telefone" id="telefone" maxlength="12"
						pattern="\d{12}"
						placeholder="formato DDD987654321" required>
				</div>

				<div class="form-group col-md-3">
					<label for="email">E-Mail</label> <input type="email"
						class="form-control" name="email" id="email" required
						maxlength="60" placeholder="email obrigatório">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-3">
					<label for="conta">Tipo de Conta</label> <select id="conta" name="conta">
						<option value="funcionario">Funcionário</option>
						<option value="atendente">Atendente</option>
						<option value="sindico">Sindico</option>
					</select>
				</div>

				<div class="form-group col-md-3">
					<label for="acesso">Tipo de Acesso</label> <select id="acesso" name="acesso">
						<option value="restrito">Restrito</option>
						<option value="livre">Livre</option>
					</select>
				</div>
			</div>

			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="action" value="insert">Salvar</button>
					<a href="index.jsp" class="btn btn-danger">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
</body>

</html>