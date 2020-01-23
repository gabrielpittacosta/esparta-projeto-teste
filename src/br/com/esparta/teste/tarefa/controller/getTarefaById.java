package br.com.esparta.teste.tarefa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.esparta.teste.tarefa.models.SimuladorBD;
import br.com.esparta.teste.tarefa.models.Tarefa;

public class getTarefaById implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        
        SimuladorBD bd = new SimuladorBD();
        Tarefa tarefa = bd.getTarefaById(id);
        
        request.setAttribute("tarefa", tarefa);

        return "forward:formAlteraTarefa.jsp";
        
	}
}
