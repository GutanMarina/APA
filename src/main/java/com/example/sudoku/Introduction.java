package com.example.sudoku;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;

public class Introduction extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Imaginea de fundal

        Image backgroundImage = new Image(getClass().getResource("/com/example/sudoku/begin.png").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(720);
        backgroundImageView.setFitHeight(640);

        // Butonul Play
        Image imageButtonPlay = new Image(getClass().getResource("/com/example/sudoku/buton.png").toExternalForm());
        ImageView imageViewButton = new ImageView(imageButtonPlay);

        Button playButton = new Button();
        playButton.setGraphic(imageViewButton);
        playButton.setStyle("-fx-background-color: transparent; -fx-padding: 0;");

        playButton.setOnAction(event -> {
            Selection selection = new Selection();
            selection.start(primaryStage);
        });


        // Evenimente: hover, apăsare, eliberare
        playButton.setOnMouseEntered(event -> imageViewButton.setOpacity(0.8));
        playButton.setOnMouseExited(event -> imageViewButton.setOpacity(1.0));
        playButton.setOnMousePressed(event -> {
            imageViewButton.setScaleX(0.95);
            imageViewButton.setScaleY(0.95);
        });
        playButton.setOnMouseReleased(event -> {
            imageViewButton.setScaleX(1.0);
            imageViewButton.setScaleY(1.0);

            // Navighează la altă scenă sau logică
            System.out.println("Play button clicked!");
        });

        // Layout principal
        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundImageView, playButton);
        playButton.setTranslateY(240);

        // Scena
        Scene scene = new Scene(root, 720, 640);
        //primaryStage.setScene(scene);
        //scene.getStylesheets().add(getClass().getResource("/sudoku/sudoku_game/Style.css").toExternalForm());
        // primaryStage.setTitle("Zenudoku");
        //primaryStage.show();
        Stage stage = new Stage();
        stage.setTitle("Zenudoku");
        Image icon = new Image(getClass().getResourceAsStream("/com/example/sudoku/icon.png"));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
