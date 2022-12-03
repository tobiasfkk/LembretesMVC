package DAO;

import Model.Categoria;
import interfaces.CategoriaInterface;
import java.util.HashSet;
import java.util.Set;

public class CategoriaDAO implements CategoriaInterface{
    
    private static Set<Categoria>categorias;

    public CategoriaDAO(){
        if(categorias == null)
           categorias = new HashSet<>();
    }

    @Override
    public void gravar(Categoria categoria) {
        categorias.add(categoria);
    }

    @Override
    public Categoria buscar(int numeroCategoria) {
        for(Categoria categoria1 : categorias){
             if (categoria1.getNumeroCategoria()== numeroCategoria)
                 return categoria1;
         }
         return null;
    }

    @Override
    public Set<Categoria> buscarTodosCategorias() {
        return categorias;
    }

    @Override
    public void remover(Categoria categoria) {
        categorias.remove(categoria);
    }

    @Override
    public void editar(int numerocategoria, String nomecategoria, String descricaocategoria, String status) {
        for(Categoria categoria1 : categorias){
             if (categoria1.getNumeroCategoria()== numerocategoria){
                 categoria1.setNomeCategoria(nomecategoria);
                 categoria1.setDescricaoCategoria(descricaocategoria);
                 categoria1.setStatus(status);
             }
         }
    }
}




/*
package DAO;

import Models.Modulo;
import interfaces.ModuloInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModuloDAO implements ModuloInterface{
    
    private static Set<Modulo> modulos;

    public ModuloDAO(){
        if(modulos == null)
           modulos = new HashSet<>();
    }

    @Override
    public void gravar(Modulo modulo) {
        modulos.add(modulo);
    }

    @Override
    public Modulo buscar(int numero) {
        for(Modulo modulo : modulos){
             if (modulo.getNumeromodulo() == numero)
                 return modulo;
         }
         return null;
    }

    @Override
    public Modulo buscarTodosModulos() {
        for (Modulo modulo : modulos) {
            return modulo;
        } 
        return null;
    }
    
      //  @Override
   // public List<Tarefa> editarTarefa() {
   //     return tarefas;
    //}

}
*/