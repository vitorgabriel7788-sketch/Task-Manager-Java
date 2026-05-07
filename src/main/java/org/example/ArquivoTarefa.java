package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArquivoTarefa {

    String arquivo = "tarefas.txt";

    //a instância do FileWriter permite escrever no arquivo,
    // enquanto o for percorre a lista de tarefas para enviar cada tarefa ao writer
    public void salvar(ArrayList<Tarefa> tarefas){

        try {

            FileWriter writer = new FileWriter(arquivo);

            for (Tarefa tarefa : tarefas){
                writer.write(tarefa.nome + ";" + tarefa.concluida + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefa");
        }
    }

    // cria uma referência para o arquivo e verifica se ele existe;
    // se não existir, retorna uma lista vazia
    public ArrayList<Tarefa> carregar(){
        ArrayList<Tarefa> tarefas = new ArrayList<>();

        try {
            File file = new File(arquivo);
            if (!file.exists()){
                return tarefas;
            }

            //lê o conteúdo do arquivo
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                //pega uma linha do arquivo
                String linha = scanner.nextLine();

                //separa o nome e o status da tarefa
                String[] partes = linha.split(";");

                // cria uma tarefa usando os dados da linha
                Tarefa tarefa = new Tarefa(partes[0]);

                tarefa.concluida = Boolean.parseBoolean(partes[1]);

                tarefas.add(tarefa);
            }
            scanner.close();
        } catch (IOException e){
            System.out.println("Erro ao carregar tarefa");
        }

        return tarefas;

    }
}
