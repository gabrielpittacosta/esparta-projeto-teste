package br.com.esparta.teste.tarefa.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.esparta.teste.tarefa.models.SimuladorBD;
import br.com.esparta.teste.tarefa.models.Tarefa;

public class updateTarefa implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
        String nomeTarefa = request.getParameter("nome");
        String descricaoTarefa = request.getParameter("descricao");
        String dataTarefa = request.getParameter("data");
        boolean finalizado = request.getParameter("finalizado") != null;
 
        
        Date dataAbertura = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(dataTarefa);
        } catch (ParseException e) {
                throw new ServletException(e);
        }
        
        SimuladorBD bd = new SimuladorBD();
        Tarefa tarefa = bd.getTarefaById(id);
        tarefa.setNome(nomeTarefa);
        tarefa.setDataAbertura(dataAbertura);
        tarefa.setDescricao(descricaoTarefa);
        tarefa.setFinalizado(finalizado);
        
        return "redirect:tarefa?acao=listaTarefas";
	}
}
