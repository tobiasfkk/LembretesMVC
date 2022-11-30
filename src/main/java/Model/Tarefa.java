package Model;

import Exception.CampoVazioException;

public class Tarefa extends Atividade {
    
    private String anexo; 
    private Categoria categoria;
   
    public Tarefa(int numerotarefa, String datahoracriacao, String titulo, String dataconclusao, String prioridade, String status, String descricao, Categoria categoria) {
        super(numerotarefa,datahoracriacao,titulo,dataconclusao,prioridade,status,descricao);
        this.categoria = categoria;
    }
             
    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }    

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return numeroatividade + " - " + titulo + " - "+ datahoracriacao + " - " + prioridade + " - "  + status + " - " + descricao;
    }
    
}