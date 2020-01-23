<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/tarefa" var="linkEntradaServlet" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar nova tarefa</title>
</head>
<body>
	<form action="${linkEntradaServlet}" method="post">
		<div>
			<label>Nome da tarefa: </label>
			<input type="text" name="nome" /> 
		</div>
		<div>
        	<label>Descrição da tarefa: </label>
        	<textarea rows="5" cols="17" name="descricao"></textarea>
    	</div>
		<input type="hidden" name="acao" value="postTarefa" /> 
		<input type="submit" />
		<br></br>
		<a href="/esparta-projeto-teste/tarefa?acao=listaTarefas">Voltar para a lista de tarefas</a>
	</form>
</body>
</html>