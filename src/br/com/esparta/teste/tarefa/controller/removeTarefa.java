package br.com.esparta.teste.tarefa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.esparta.teste.tarefa.models.SimuladorBD;

public class removeTarefa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		SimuladorBD bd = new SimuladorBD();
		bd.removeTarefa(id);

		return "redirect:tarefa?acao=listaTarefas";
	}
}
