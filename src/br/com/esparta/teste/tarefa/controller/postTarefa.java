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

public class postTarefa implements Acao {
    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException   {
        
        String nomeTarefa = request.getParameter("nome");
        String descricaoTarefa = request.getParameter("descricao");

        Tarefa tarefa = new Tarefa();
        tarefa.setNome(nomeTarefa);
        tarefa.setDescricao(descricaoTarefa);
    
        
        SimuladorBD bd = new SimuladorBD();
        bd.postTarefa(tarefa);
        
        request.setAttribute("tarefa", tarefa.getNome());
        
        return "redirect:tarefa?acao=listaTarefas";
        
    }
}
