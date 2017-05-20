<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visualizar Empresa</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

        <body>
                <!-- Modal -->
                <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title" id="modalLabel">Excluir Empresa</h4>
                            </div>
                            <div class="modal-body">
                                Deseja realmente excluir esta empresa?
                            </div>
                            <div class="modal-footer">
                                <form action="controller.do" method="post">
                                    <input type="hidden" name="id" value="${empresa.id }" />
                                    <button type="submit" class="btn btn-primary" name="command" value="ExcluirEmpresa">Sim</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal -->
                <!-- Barra superior com os menus de navegação -->
				<c:import url="Menu.jsp"/>
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Visualizar Empresa #${empesa.id }</h3>
                    <div class="row">
                        <div class="col-md-12">
                            <p><strong>Razão Social</strong>
                            </p>
                            <p>
                                ${empresa.razaoSocial }
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <p><strong>Nome Fantasia</strong>
                            </p>
                            <p>
                                ${empresa.nomeFantasia }
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <p><strong>Conjunto</strong>
                            </p>
                            <c:forEach var="empresa" items="${empresa.conjunto }">
                                ${empresa.conjunto } 
                            </c:forEach>                            
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <p><strong>Horário Início</strong>
                            </p>
                            <p>
                                ${empresa.horarioInicio }
                            </p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>Horário Fim</strong>
                            </p>
                            <p>
                                ${empresa.horarioFim }
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <p><strong>Temperatura</strong>
                            </p>
                            <p>
                                ${empresa.temperatura }
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <p><strong>Horário Ligar AC</strong>
                            </p>
                            <p>
                                ${empresa.horLigarAC }
                            </p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>Horário Desligar AC</strong>
                            </p>
                            <p>
                                ${empresa.horDesligarAC }
                            </p>
                        </div>
                    </div>
                    
                    <hr />
                    <div id="actions" class="row">
                        <div class="col-md-12">
                            <a href="controller.do?command=EditarEmpresa&id=${empresa.id }" class="btn btn-primary">Editar</a>
                            <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a>
                            <a href="ListarEmpresa.jsp" class="btn btn-default">Voltar</a>
                        </div>
                    </div>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>