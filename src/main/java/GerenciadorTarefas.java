import java.util.ArrayList;

public class GerenciadorTarefas {
    ArrayList<Tarefa> tarefas = new ArrayList<>();

    void adicionar(String nome){
        Tarefa tarefa = new Tarefa(nome);
        tarefas.add(tarefa);
    }

    void listar(){
        for (int i = 0; i < tarefas.size(); i++) {
            Tarefa tarefa = tarefas.get(i);
            System.out.println(i + " - " + tarefa.nome + " | " + (tarefa.concluida ? "✔" : "❌"));
        }
    }

    void concluir(int indice){
        if (indice >= 0 && indice < tarefas.size()){
            tarefas.get(indice).marcarComoConcluida();
            System.out.println("Tarefa concluída");
        } else {
            System.out.println("Indíce inválido");
        }
    }

    void remover(int indice){
        if ( indice >= 0 && indice < tarefas.size()){
            tarefas.remove(indice);
            System.out.println("Tarefa removida");
        } else {
            System.out.println("Indíce inválido");
        }
    }
}
