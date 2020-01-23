package br.com.esparta.teste.tarefa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.esparta.teste.tarefa.models.SimuladorBD;
import br.com.esparta.teste.tarefa.models.Tarefa;

public class listaTarefas implements Acao {
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
    	SimuladorBD bd = new SimuladorBD();
    	List<Tarefa> lista = bd.getTarefas();
    	
        req.setAttribute("tarefas", lista);
        
        return "forward:listaTarefas.jsp";
	}
}
