package br.com.esparta.teste.tarefa.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimuladorBD {

	private static List<Tarefa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	public void postTarefa(Tarefa tarefa) {
		tarefa.setId(SimuladorBD.chaveSequencial++);
		lista.add(tarefa);
	}
	
	public List<Tarefa> getTarefas(){
		return SimuladorBD.lista;
	}

	public void removeTarefa(Integer id) {
	    Iterator<Tarefa> it = lista.iterator();

	    while(it.hasNext()) { 
	        Tarefa emp = it.next();

	        if(emp.getId() == id ) {
	            it.remove();
	        }
	    }
		
	}

	public Tarefa getTarefaById(Integer id) {
	    for (Tarefa tarefa: lista) { 
	        if(tarefa.getId() == id)  {
	            return tarefa;
	        }

	    }
	    return null;
	}

}
