package DAO;

import Exception.CampoVazioException;
import Model.Categoria;
import Model.Tarefa;
import interfaces.TarefaInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TarefaDAO implements TarefaInterface{
    
    private static List<Tarefa>tarefas;

    public TarefaDAO(){
        if(tarefas == null)
           tarefas = new ArrayList<>();
    }
    
   
    @Override
    public void gravar(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    @Override
    public Tarefa buscar(Date data) {
        for(Tarefa tarefa : tarefas){
            if (tarefa.getDatahoracriacao().equals(data))
                return tarefa;
        }
        return null;
    }
    
    @Override
    public List<Tarefa> buscarTodasTarefas() {
        return tarefas;
    }
    
    @Override
    public void editar(int numerotarefa, String titulo, String dataconclusao, String prioridade, String status, String descricao, Categoria categoria) {
         for(Tarefa tarefa : tarefas){
             if (tarefa.getNumeroTarefa() == numerotarefa){
                 try {
                     tarefa.setTitulo(titulo);
                 } catch (CampoVazioException ex) {
                     Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 try {
                     tarefa.setDataconclusao(dataconclusao);
                 } catch (CampoVazioException ex) {
                     Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 tarefa.setPrioridade(prioridade);
                 tarefa.setDescricao(descricao);
                 tarefa.setStatus(status);
                 tarefa.setCategoria(categoria);
             }
         }
    }

    @Override
    public void remover(Tarefa tarefa) {
        tarefas.remove(tarefa);
    }

}