package Controller;

import View.ViewCriarTarefa;

public class ControladorViewCriarTarefa {
    private ViewCriarTarefa viewCadastrarTarefa = new ViewCriarTarefa();

    public ControladorViewCriarTarefa() {
        abrirTela();
    }
    
    public void abrirTela(){
        viewCadastrarTarefa.exibir();
    }
    
}
