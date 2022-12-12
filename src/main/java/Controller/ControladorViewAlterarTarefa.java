/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.CategoriaDAO;
import DAO.TarefaDAO;
import Exception.CampoVazioException;
import Model.Categoria;
import Model.Tarefa;
import View.ViewAlterarCategoria;
import View.ViewAlterarTarefa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author lucas
 */
public class ControladorViewAlterarTarefa {
    private ViewAlterarTarefa ViewAlterarTarefa = new ViewAlterarTarefa();
    private TarefaDAO repositorioTarefa = new TarefaDAO();
    private CategoriaDAO repositorioCategoria = new CategoriaDAO();
    
    public ControladorViewAlterarTarefa() {
        carregarComboCategoria();
        carregarComboTarefa();
        adicionarAcao();
        abrirTela();
    }
    
    public void abrirTela(){
        ViewAlterarTarefa.exibir();
    }
    
    public void adicionarAcao(){
        ViewAlterarTarefa.adicionarAcaoBotaoSalvar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    salvar();
                } catch (CampoVazioException ex) {
                    ViewAlterarTarefa.exibirMensagem(ex.getMessage());
                }
            }
        });
        ViewAlterarTarefa.adicionarAcaoComboTarefa(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComboTarefa();
            }
        });
        ViewAlterarTarefa.adicionarAcaoBotaoDeletar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletar();
            }
        });
    }
    
    public void ComboTarefa(){
        Tarefa SelectedItem = ViewAlterarTarefa.getComboTarefa();
        ViewAlterarTarefa.setTarefaTitulo(SelectedItem.getTitulo());
        ViewAlterarTarefa.setTarefaPrioridade(SelectedItem.getPrioridade());
        ViewAlterarTarefa.setTarefaStatus(SelectedItem.getStatus());
        ViewAlterarTarefa.setTarefaDataConclusao(SelectedItem.getDataconclusao());
        ViewAlterarTarefa.setTarefaCategoria(SelectedItem.getCategoria());
        ViewAlterarTarefa.setTarefaDescricao(SelectedItem.getDescricao());
    }
    
    public void salvar() throws CampoVazioException{
        if(ViewAlterarTarefa.getTarefaTitulo().isEmpty()){
            throw new CampoVazioException("TITULO NÃO PODE ESTAR VÁZIO!");
        }else{
            Tarefa SelectedItem = (Tarefa) ViewAlterarTarefa.getComboTarefa();
            repositorioTarefa.editar(SelectedItem.getNumerotarefa(), ViewAlterarTarefa.getTarefaTitulo(), ViewAlterarTarefa.getTarefaDataConclusao(), ViewAlterarTarefa.getTarefaPrioridade(), ViewAlterarTarefa.getTarefaStatus(), ViewAlterarTarefa.getTarefaDescricao(), ViewAlterarTarefa.getComboCategoria());
            ViewAlterarTarefa.limparCampos();
            ViewAlterarTarefa.exibirMensagem("TAREFA SALVA COM SUCESSO!");
        }
    }
    
    public void deletar(){
        Tarefa SelectedItem = (Tarefa) ViewAlterarTarefa.getComboTarefa();
        repositorioTarefa.remover(SelectedItem);
        ViewAlterarTarefa.removerItemComboTarefas(SelectedItem);        
        ViewAlterarTarefa.exibirMensagem("tAREFA DELETADA COM SUCESSO!");
    }
    
    public void carregarComboCategoria(){
        for (Categoria categoria : repositorioCategoria.buscarTodosCategorias()) {
            ViewAlterarTarefa.ComboCategoria(categoria);
        }
    }
    
    public void carregarComboTarefa(){
        for (Tarefa tarefa : repositorioTarefa.buscarTodasTarefas()) {
            ViewAlterarTarefa.ComboTarefa(tarefa);
        }
    }
}
