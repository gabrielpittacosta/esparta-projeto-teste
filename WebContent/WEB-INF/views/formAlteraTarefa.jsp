<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/tarefa" var="linkEntradaServlet" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar tarefa</title>
</head>
<body>
		<form action="${linkEntradaServlet}" method="post">

		Nome: <input type="text" name="nome" value="${tarefa.nome }" /> 
		Descricao: <input type="text" name="descricao" value="${tarefa.descricao }" /> 
		Finalizado: <input type="checkbox" name="finalizado" value="${tarefa.finalizado }" />
		Data da finaliação: <input type="text" name="data"value="<fmt:formatDate value="${tarefa.dataAbertura}" pattern="dd/MM/yyyy"/>" />
		<input type="hidden" name="id" value="${tarefa.id }">
		<input type="hidden" name="acao" value="updateTarefa">
		<input type="submit" />
	</form>
</body>
</html>