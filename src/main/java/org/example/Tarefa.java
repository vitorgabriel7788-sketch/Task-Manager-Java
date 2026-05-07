package org.example;

public class Tarefa {
    String nome;
    boolean concluida;

    public Tarefa(String nome){
        this.nome = nome;
        this.concluida = false;
    }

    void marcarComoConcluida(){
        this.concluida = true;
    }

    @Override
    public String toString() {
        return nome + " | " + (concluida ? "[CONCLUIDA]" : "[PENDENTE]");
    }
}
