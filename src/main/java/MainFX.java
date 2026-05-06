import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainFX extends Application {

    GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();

    @Override
    public void start(Stage stage) {

        TextField input = new TextField();
        input.setPromptText("Digite uma nova tarefa...");

        Button adicionarBtn = new Button("Adicionar");
        ListView<Tarefa> lista = new ListView<>();
        lista.setStyle("-fx-font-family: 'Segoe UI Emoji';");
        Button removerBtn = new Button("Remover");

        //titulo
        Label titulo = new Label("Task manager");
        titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");



        //atualiza a tela
        Runnable atualizar = () -> {
            lista.getItems().clear();

            for (Tarefa t : gerenciadorTarefas.tarefas) {
                lista.getItems().add(t);

            }
        };



        //adicionar tarefa
        adicionarBtn.setOnAction(e ->{
            String texto = input.getText();

            if (!texto.isEmpty()) {
                gerenciadorTarefas.adicionar(texto);
                input.clear();
                atualizar.run();
            }
        });

        lista.setOnMouseClicked(e -> {
            int index = lista.getSelectionModel().getSelectedIndex();

            if (index >= 0){
                gerenciadorTarefas.concluir(index);
                atualizar.run();
            }
        });


        //remove tarefa
        removerBtn.setOnAction(e ->{
            int index = lista.getSelectionModel().getSelectedIndex();
            if (index >= 0){
                gerenciadorTarefas.remover(index);
                atualizar.run();
            }
        });


        atualizar.run();

        VBox layout = new VBox(10);

        layout.setStyle("-fx-padding: 15;");

        layout.getChildren().addAll(
                titulo,
                input,
                adicionarBtn,
                removerBtn,
                lista
        );


        Scene scene = new Scene(layout, 300, 400);

        stage.setTitle("Task Manager");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}