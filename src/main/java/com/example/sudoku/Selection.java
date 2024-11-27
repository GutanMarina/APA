package com.example.sudoku;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Selection extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Imaginea de fundal
        Image backgroundImage = new Image(getClass().getResource("/com/example/sudoku/imagine buna.png").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(720);
        backgroundImageView.setFitHeight(640);

        // Butonul Easy
        Image imageButtonEasy = new Image(getClass().getResource("/com/example/sudoku/easybuton.png").toExternalForm());
        ImageView imageViewButton1 = new ImageView(imageButtonEasy);
        Button playButton1 = new Button();
        playButton1.setGraphic(imageViewButton1);
        playButton1.setStyle("-fx-background-color: transparent; -fx-padding: 0;");

        // Evenimente: hover, apăsare, eliberare
        playButton1.setOnMouseEntered(event -> imageViewButton1.setOpacity(0.8));
        playButton1.setOnMouseExited(event -> imageViewButton1.setOpacity(1.0));
        playButton1.setOnMousePressed(event -> {
            imageViewButton1.setScaleX(0.95);
            imageViewButton1.setScaleY(0.95);
        });
        playButton1.setOnMouseReleased(event -> {
            imageViewButton1.setScaleX(1.0);
            imageViewButton1.setScaleY(1.0);

            // Navighează la scena Easy
            System.out.println("Easy button clicked!");
        });
        playButton1.setOnAction(event -> {
            com.example.sudoku.Easy easy = new com.example.sudoku.Easy();
            easy.start(primaryStage);  // Deschide scena pentru nivelul Easy
        });

        // Butonul Medium
        Image imageButtonMedium = new Image(getClass().getResource("/com/example/sudoku/mediumbuton.png").toExternalForm());
        ImageView imageViewButton2 = new ImageView(imageButtonMedium);
        Button playButton2 = new Button();
        playButton2.setGraphic(imageViewButton2);
        playButton2.setStyle("-fx-background-color: transparent; -fx-padding: 0;");

        // Evenimente: hover, apăsare, eliberare
        playButton2.setOnMouseEntered(event -> imageViewButton2.setOpacity(0.8));
        playButton2.setOnMouseExited(event -> imageViewButton2.setOpacity(1.0));
        playButton2.setOnMousePressed(event -> {
            imageViewButton2.setScaleX(0.95);
            imageViewButton2.setScaleY(0.95);
        });
        playButton2.setOnMouseReleased(event -> {
            imageViewButton2.setScaleX(1.0);
            imageViewButton2.setScaleY(1.0);
        });
        playButton2.setOnAction(event -> {
            Medium medium = new Medium();
            try {
                medium.start(primaryStage);  // Deschide scena pentru nivelul Medium
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Butonul Hard
        Image imageButtonHard = new Image(getClass().getResource("/com/example/sudoku/hardbuton.png").toExternalForm());
        ImageView imageViewButton3 = new ImageView(imageButtonHard);
        Button playButton3 = new Button();
        playButton3.setGraphic(imageViewButton3);
        playButton3.setStyle("-fx-background-color: transparent; -fx-padding: 0;");

        // Evenimente: hover, apăsare, eliberare
        playButton3.setOnMouseEntered(event -> imageViewButton3.setOpacity(0.8));
        playButton3.setOnMouseExited(event -> imageViewButton3.setOpacity(1.0));
        playButton3.setOnMousePressed(event -> {
            imageViewButton3.setScaleX(0.95);
            imageViewButton3.setScaleY(0.95);
        });
        playButton3.setOnMouseReleased(event -> {
            imageViewButton3.setScaleX(1.0);
            imageViewButton3.setScaleY(1.0);
        });
        playButton3.setOnAction(event -> {
            Hard hard = new Hard();
            try {
                hard.start(primaryStage);  // Deschide scena pentru nivelul Hard
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // Layout principal
        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundImageView, playButton1, playButton2, playButton3);
        playButton1.setTranslateY(-80);
        playButton2.setTranslateY(20);
        playButton3.setTranslateY(120);

        // Scena
        Scene scene = new Scene(root, 720, 640);
        // Stiluri CSS
        // scene.getStylesheets().add(getClass().getResource("/sudoku/sudoku_game/Style.css").toExternalForm());

        primaryStage.setTitle("Zenudoku");
        Image icon = new Image(getClass().getResourceAsStream("/com/example/sudoku/icon.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
