package br.com.esparta.teste.tarefa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.esparta.teste.tarefa.controller.Acao;

@WebServlet("/tarefa")
public class Servlet extends HttpServlet {
	
	private static final long serialVersionUID = -7400413011520511363L;

	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String paramAcao = req.getParameter("acao");
		
		String nomeDaClasse = "br.com.esparta.teste.tarefa.controller." + paramAcao;
		
		String nome;
		try {
		    Class classe = Class.forName(nomeDaClasse); 
		    Acao acao = (Acao) classe.newInstance(); 
		    nome = acao.executa(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
		    throw new ServletException(e);
		}
		
		String[] tipoEEndereco = nome.split(":");
	    if(tipoEEndereco[0].equals("forward")) {
	        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/"+tipoEEndereco[1]);
	        rd.forward(req, resp);
	    } else {
	        resp.sendRedirect(tipoEEndereco[1]);

	    }
    }
}
