package com.example.sudoku;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Hard extends Application {

    @Override
    public void start(Stage stage) {
        try {
            // Încarcă fișierul FXML specific pentru nivelul "Hard"
            FXMLLoader fxmlLoader = new FXMLLoader(Hard.class.getResource("View2.fxml"));
            Pane root = fxmlLoader.load(); // Obține root layout din FXML

            // Creează scena pentru nivelul "Hard"
            Scene scene = new Scene(root, 720, 640);
            scene.getStylesheets().add(getClass().getResource("/com/example/sudoku/Style.css").toExternalForm());

            // Setează titlul, iconița și scena
            stage.setTitle("Zenudoku");
            Image icon = new Image(getClass().getResourceAsStream("/com/example/sudoku/icon.png"));
            stage.getIcons().add(icon);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

            // Creare buton "Back"
            Image imageButtonBack = new Image(getClass().getResource("/com/example/sudoku/image.png").toExternalForm());
            ImageView imageViewButtonBack = new ImageView(imageButtonBack);
            imageViewButtonBack.setFitWidth(40);
            imageViewButtonBack.setFitHeight(40);
            Button playButtonBack = new Button();
            playButtonBack.setGraphic(imageViewButtonBack);
            playButtonBack.setStyle("-fx-background-color: transparent; -fx-padding: 0;");

            // Setare poziție buton
            playButtonBack.setLayoutX(638); // Poziția X
            playButtonBack.setLayoutY(15); // Poziția Y

            // Evenimente: hover, apăsare, eliberare
            playButtonBack.setOnMouseEntered(event -> imageViewButtonBack.setOpacity(0.8));
            playButtonBack.setOnMouseExited(event -> imageViewButtonBack.setOpacity(1.0));
            playButtonBack.setOnMousePressed(event -> {
                imageViewButtonBack.setScaleX(0.95);
                imageViewButtonBack.setScaleY(0.95);
            });
            playButtonBack.setOnMouseReleased(event -> {
                imageViewButtonBack.setScaleX(1.0);
                imageViewButtonBack.setScaleY(1.0);
            });

            // Adăugare buton "Back" pe scena curentă
            root.getChildren().add(playButtonBack);

            // Eveniment pentru butonul "Back"
            playButtonBack.setOnAction(event -> {
                // Încarcă scena pentru pagina Selection
                Selection selection = new Selection();
                try {
                    selection.start(stage);  // Folosește același primaryStage
                } catch (Exception e) {
                    e.printStackTrace();  // În cazul în care apar erori la încărcarea scenei
                }
            });

        } catch (IOException e) {
            e.printStackTrace();  // Tratarea erorilor la încărcarea fișierului FXML
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
