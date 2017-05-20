<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.usjt.arqdesis.sistemaPredial.model.Empresa"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visualizar Usuário</title>

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
							dayNames : [ 'Domingo', 'Segunda', 'Terça',
									'Quarta', 'Quinta', 'Sexta', 'Sábado',
									'Domingo' ],
							dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S',
									'D' ],
							dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua',
									'Qui', 'Sex', 'Sáb', 'Dom' ],
							monthNames : [ 'Janeiro', 'Fevereiro', 'Março',
									'Abril', 'Maio', 'Junho', 'Julho',
									'Agosto', 'Setembro', 'Outubro',
									'Novembro', 'Dezembro' ],
							monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr',
									'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out',
									'Nov', 'Dez' ],
							nextText : 'Próximo',
							prevText : 'Anterior'
						});
			});
</script>
<body>
	<c:import url="Menu.jsp" />
	<%
		Empresa emp = (Empresa) request.getAttribute("empresa");
	%>
	<div id="main" class="container">
		<h3 class="page-header">Dados da Empresa</h3>
		<form action="ManterEmpresa" method="post">
			<div class="row">
				<div class="form-group col-md-2">
					<label for="idLb">ID</label> <input type="text"
						class="form-control" readonly="readonly" name="idEmpresa"
						id="idEmpresa" value="<%=emp.getIdEmpresa()%>" />
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-8">
					<label for="razaoSocial">Razão Social</label> <input type="text"
						class="form-control" name="razaoSocial" id="razaoSocial"
						maxlength="45" value="<%=emp.getCnpj()%>" required>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-8">
					<label for="nomeFantasia">Nome Fantasia</label> <input type="text"
						class="form-control" name="nomeFantasia" id="nomeFantasia"
						maxlength="45" value="<%=emp.getNomeFantasia()%>">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-3">
					<label for="cnpj">CNPJ</label> <input type="text"
						class="form-control" name="cnpj" id="cnpj" required maxlength="14"
						pattern="\d{14}" value="<%=emp.getCnpj()%>" required>
				</div>

				<div class="form-group col-md-3">
					<label for="temperatura">Temperatura</label>

					<%!
						int temp;
						int[] temps;
						int cont = 0;
					%>

					<%
						temp = emp.getTemperatura();
						for (int i = 10; i < 31; i++) {
							if (i != temp) {
								temps[cont] = i;
								cont++;
							}
						}
					%>
					<select class="form-control" type="text" name="temperatura"
						id="temperatura" required>

						<option value="<%=emp.getTemperatura()%>"><%=emp.getTemperatura()%>°C</option>
						<option value="<%=temps[0]%>"><%=temps[0]%>°C</option>
						<option value="<%=temps[1]%>"><%=temps[1]%>°C</option>
						<option value="<%=temps[2]%>"><%=temps[2]%>°C</option>
						<option value="<%=temps[3]%>"><%=temps[3]%>°C</option>
						<option value="<%=temps[4]%>"><%=temps[4]%>°C</option>
						<option value="<%=temps[5]%>"><%=temps[5]%>°C</option>
						<option value="<%=temps[6]%>"><%=temps[6]%>°C</option>
						<option value="<%=temps[7]%>"><%=temps[7]%>°C</option>
						<option value="<%=temps[8]%>"><%=temps[8]%>°C</option>
						<option value="<%=temps[9]%>"><%=temps[9]%>°C</option>
						<option value="<%=temps[10]%>"><%=temps[10]%>°C</option>
						<option value="<%=temps[11]%>"><%=temps[11]%>°C</option>
						<option value="<%=temps[12]%>"><%=temps[12]%>°C</option>
						<option value="<%=temps[13]%>"><%=temps[13]%>°C</option>
						<option value="<%=temps[14]%>"><%=temps[14]%>°C</option>
						<option value="<%=temps[15]%>"><%=temps[15]%>°C</option>
						<option value="<%=temps[16]%>"><%=temps[16]%>°C</option>
						<option value="<%=temps[17]%>"><%=temps[17]%>°C</option>
						<option value="<%=temps[18]%>"><%=temps[18]%>°C</option>
						<option value="<%=temps[19]%>"><%=temps[19]%>°C</option>
					</select>
				</div>

			</div>
			<!-- horarioInicio, horarioFim, temperatura, horLigarAC, horDesligarAC -->
			<div class="row">
				<div class="form-group col-md-3">
					<label for="horarioInicio">Horário de Inicio</label>

					<%!
						String horarioS;
						String[] hms, horariosS;
						int horaS, chs = 0;
					%>

					<%
						horarioS = emp.getHorarioInicio();
						hms = horarioS.split(":");
						horaS = Integer.parseInt(hms[0]);
						
						for(int i = 0; i < 24; i++) {
							if(i != horaS) {
								if(i < 10) {
									horariosS[chs] = "0" + i + ":00";
								} else {
									horariosS[chs] = i + ":00";
								}
								chs++;
							}
						}
					%>

					<select class="form-control" type="text" name="horarioInicio"
						id="horarioInicio" required>
						<option value="<%=emp.getHorarioInicio()%>"><%=emp.getHorarioInicio()%></option>
						<option value="<%=horariosS[0]%>"><%=horariosS[0]%></option>
						<option value="<%=horariosS[1]%>"><%=horariosS[1]%></option>
						<option value="<%=horariosS[2]%>"><%=horariosS[2]%></option>
						<option value="<%=horariosS[3]%>"><%=horariosS[3]%></option>
						<option value="<%=horariosS[4]%>"><%=horariosS[4]%></option>
						<option value="<%=horariosS[5]%>"><%=horariosS[5]%></option>
						<option value="<%=horariosS[6]%>"><%=horariosS[6]%></option>
						<option value="<%=horariosS[7]%>"><%=horariosS[7]%></option>
						<option value="<%=horariosS[8]%>"><%=horariosS[8]%></option>
						<option value="<%=horariosS[9]%>"><%=horariosS[9]%></option>
						<option value="<%=horariosS[10]%>"><%=horariosS[10]%></option>
						<option value="<%=horariosS[11]%>"><%=horariosS[11]%></option>
						<option value="<%=horariosS[12]%>"><%=horariosS[12]%></option>
						<option value="<%=horariosS[13]%>"><%=horariosS[13]%></option>
						<option value="<%=horariosS[14]%>"><%=horariosS[14]%></option>
						<option value="<%=horariosS[15]%>"><%=horariosS[15]%></option>
						<option value="<%=horariosS[16]%>"><%=horariosS[16]%></option>
						<option value="<%=horariosS[17]%>"><%=horariosS[17]%></option>
						<option value="<%=horariosS[18]%>"><%=horariosS[18]%></option>
						<option value="<%=horariosS[19]%>"><%=horariosS[19]%></option>
						<option value="<%=horariosS[20]%>"><%=horariosS[20]%></option>
						<option value="<%=horariosS[21]%>"><%=horariosS[21]%></option>
						<option value="<%=horariosS[22]%>"><%=horariosS[22]%></option>
					</select>
					</div>

				<div class="form-group col-md-3">
					<label for="horarioFim">Horário de Saída</label> <select
						class="form-control" type="text" name="horarioFim" id="horarioFim"
						required>
						
					<%!
						String horarioF;
						String[] hmf, horariosF;
						int horaF, chf = 0;
					%>

					<%
						horarioF = emp.getHorarioFim();
						hmf = horarioF.split(":");
						horaF = Integer.parseInt(hmf[0]);
						
						for(int i = 0; i < 24; i++) {
							if(i != horaF) {
								if(i < 10) {
									horariosF[chf] = "0" + i + ":00";
								} else {
									horariosF[chf] = i + ":00";
								}
								chf++;
							}
						}
					%>
						
						<option value="<%=emp.getHorarioFim()%>"><%=emp.getHorarioFim()%></option>
						<option value="<%=horariosF[0]%>"><%=horariosF[0]%></option>
						<option value="<%=horariosF[1]%>"><%=horariosF[1]%></option>
						<option value="<%=horariosF[2]%>"><%=horariosF[2]%></option>
						<option value="<%=horariosF[3]%>"><%=horariosF[3]%></option>
						<option value="<%=horariosF[4]%>"><%=horariosF[4]%></option>
						<option value="<%=horariosF[5]%>"><%=horariosF[5]%></option>
						<option value="<%=horariosF[6]%>"><%=horariosF[6]%></option>
						<option value="<%=horariosF[7]%>"><%=horariosF[7]%></option>
						<option value="<%=horariosF[8]%>"><%=horariosF[8]%></option>
						<option value="<%=horariosF[9]%>"><%=horariosF[9]%></option>
						<option value="<%=horariosF[10]%>"><%=horariosF[10]%></option>
						<option value="<%=horariosF[11]%>"><%=horariosF[11]%></option>
						<option value="<%=horariosF[12]%>"><%=horariosF[12]%></option>
						<option value="<%=horariosF[13]%>"><%=horariosF[13]%></option>
						<option value="<%=horariosF[14]%>"><%=horariosF[14]%></option>
						<option value="<%=horariosF[15]%>"><%=horariosF[15]%></option>
						<option value="<%=horariosF[16]%>"><%=horariosF[16]%></option>
						<option value="<%=horariosF[17]%>"><%=horariosF[17]%></option>
						<option value="<%=horariosF[18]%>"><%=horariosF[18]%></option>
						<option value="<%=horariosF[19]%>"><%=horariosF[19]%></option>
						<option value="<%=horariosF[20]%>"><%=horariosF[20]%></option>
						<option value="<%=horariosF[21]%>"><%=horariosF[21]%></option>
						<option value="<%=horariosF[22]%>"><%=horariosF[22]%></option>

					</select>
				</div>

				<div class="form-group col-md-3">
					<label for="horLigarAC">Ligar Ar</label> <select type="text"
						class="form-control" name="horLigarAC" id="horLigarAC" required>

					<%!
						String horarioL;
						String[] hml, horariosL;
						int horaL, chl = 0;
					%>

					<%
						horarioL = emp.getHorarioInicio();
						hml = horarioL.split(":");
						horaL = Integer.parseInt(hml[0]);
						
						for(int i = 0; i < 24; i++) {
							if(i != horaL) {
								if(i < 10) {
									horariosL[chl] = "0" + i + ":00";
								} else {
									horariosL[chl] = i + ":00";
								}
								chl++;
							}
						}
					%>
				
						<option value="<%=emp.getHorLigarAC()%>"><%=emp.getHorLigarAC()%></option>
						<option value="<%=horariosL[0]%>"><%=horariosL[0]%></option>
						<option value="<%=horariosL[1]%>"><%=horariosL[1]%></option>
						<option value="<%=horariosL[2]%>"><%=horariosL[2]%></option>
						<option value="<%=horariosL[3]%>"><%=horariosL[3]%></option>
						<option value="<%=horariosL[4]%>"><%=horariosL[4]%></option>
						<option value="<%=horariosL[5]%>"><%=horariosL[5]%></option>
						<option value="<%=horariosL[6]%>"><%=horariosL[6]%></option>
						<option value="<%=horariosL[7]%>"><%=horariosL[7]%></option>
						<option value="<%=horariosL[8]%>"><%=horariosL[8]%></option>
						<option value="<%=horariosL[9]%>"><%=horariosL[9]%></option>
						<option value="<%=horariosL[10]%>"><%=horariosL[10]%></option>
						<option value="<%=horariosL[11]%>"><%=horariosL[11]%></option>
						<option value="<%=horariosL[12]%>"><%=horariosL[12]%></option>
						<option value="<%=horariosL[13]%>"><%=horariosL[13]%></option>
						<option value="<%=horariosL[14]%>"><%=horariosL[14]%></option>
						<option value="<%=horariosL[15]%>"><%=horariosL[15]%></option>
						<option value="<%=horariosL[16]%>"><%=horariosL[16]%></option>
						<option value="<%=horariosL[17]%>"><%=horariosL[17]%></option>
						<option value="<%=horariosL[18]%>"><%=horariosL[18]%></option>
						<option value="<%=horariosL[19]%>"><%=horariosL[19]%></option>
						<option value="<%=horariosL[20]%>"><%=horariosL[20]%></option>
						<option value="<%=horariosL[21]%>"><%=horariosL[21]%></option>
						<option value="<%=horariosL[22]%>"><%=horariosL[22]%></option>

					</select>
				</div>

				<div class="form-group col-md-3">
					<label for="horDesligarAC">Desligar Ar</label> <select type="text"
						class="form-control" name="horDesligarAC" id="horDesligarAC"
						required>
					
					<%!
						String horarioD;
						String[] hmd, horariosD;
						int horaD, chd = 0;
					%>

					<%
						horarioD = emp.getHorarioInicio();
						hmd = horarioD.split(":");
						horaD = Integer.parseInt(hmd[0]);
						
						for(int i = 0; i < 24; i++) {
							if(i != horaD) {
								if(i < 10) {
									horariosD[chd] = "0" + i + ":00";
								} else {
									horariosD[chd] = i + ":00";
								}
								chd++;
							}
						}
					%>
					
						<option value="<%=emp.getHorDesligarAC()%>"><%=emp.getHorDesligarAC()%></option>
						<option value="<%=horariosD[0]%>"><%=horariosD[0]%></option>
						<option value="<%=horariosD[1]%>"><%=horariosD[1]%></option>
						<option value="<%=horariosD[2]%>"><%=horariosD[2]%></option>
						<option value="<%=horariosD[3]%>"><%=horariosD[3]%></option>
						<option value="<%=horariosD[4]%>"><%=horariosD[4]%></option>
						<option value="<%=horariosD[5]%>"><%=horariosD[5]%></option>
						<option value="<%=horariosD[6]%>"><%=horariosD[6]%></option>
						<option value="<%=horariosD[7]%>"><%=horariosD[7]%></option>
						<option value="<%=horariosD[8]%>"><%=horariosD[8]%></option>
						<option value="<%=horariosD[9]%>"><%=horariosD[9]%></option>
						<option value="<%=horariosD[10]%>"><%=horariosD[10]%></option>
						<option value="<%=horariosD[11]%>"><%=horariosD[11]%></option>
						<option value="<%=horariosD[12]%>"><%=horariosD[12]%></option>
						<option value="<%=horariosD[13]%>"><%=horariosD[13]%></option>
						<option value="<%=horariosD[14]%>"><%=horariosD[14]%></option>
						<option value="<%=horariosD[15]%>"><%=horariosD[15]%></option>
						<option value="<%=horariosD[16]%>"><%=horariosD[16]%></option>
						<option value="<%=horariosD[17]%>"><%=horariosD[17]%></option>
						<option value="<%=horariosD[18]%>"><%=horariosD[18]%></option>
						<option value="<%=horariosD[19]%>"><%=horariosD[19]%></option>
						<option value="<%=horariosD[20]%>"><%=horariosD[20]%></option>
						<option value="<%=horariosD[21]%>"><%=horariosD[21]%></option>
						<option value="<%=horariosD[22]%>"><%=horariosD[22]%></option>

					</select>
				</div>
			</div>
	</div>
	</form>

</body>
</html>