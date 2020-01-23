<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
<%@ page import="java.util.List, br.com.esparta.teste.tarefa.models.Tarefa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Lista de tarefas</title>
	</head>
	<body>
		<a href="/esparta-projeto-teste/tarefa?acao=newTarefaForm">Nova tarefa</a>
		<br>Lista de tarefas: </br>
    	<ul>
    		<c:forEach items="${tarefas}" var="tarefa">
    			<c:if test="${tarefa.finalizado == false }">
					<li>Nome da tarefa: ${tarefa.nome} -  
						Descrição: ${tarefa.descricao}
					</li>
					<input type="hidden" name="data" value="${tarefa.dataAbertura }">
					<a href="/esparta-projeto-teste/tarefa?acao=removeTarefa&id=${tarefa.id}">Deletar tarefa</a>
					<a href="/esparta-projeto-teste/tarefa?acao=getTarefaById&id=${tarefa.id }">Alterar tarefa</a>
				</c:if>
        	</c:forEach>
    	</ul>
		<br>Tarefas finalizadas: </br>
	    <ul>
    		<c:forEach items="${tarefas}" var="tarefa">
    			<c:if test="${tarefa.finalizado == true }">
					<li>Nome da tarefa: ${tarefa.nome} -  
						Descrição: ${tarefa.descricao} - 
						Tarefa finalizada no dia: <fmt:formatDate value="${tarefa.dataAbertura}" pattern="dd/MM/yyyy" /></li>
					<a href="/esparta-projeto-teste/tarefa?acao=removeTarefa&id=${tarefa.id}">Deletar tarefa</a>
					<a href="/esparta-projeto-teste/tarefa?acao=getTarefaById&id=${tarefa.id }">Alterar tarefa</a>
				</c:if>
			</c:forEach>
    	</ul>
	</body>
</html>