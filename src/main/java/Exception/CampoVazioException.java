/*essa classe retorna um erro quando é chamada*/
/*é chamada na criacao da tarefa quando o usuário deixar o campo vazio*/
package Exception;

public class CampoVazioException extends Exception {
    
    public CampoVazioException() {
        super("O campo está em branco");
    }
}
