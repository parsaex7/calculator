package org.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Calculator extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Calculator.class.getResource("Calculator-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Calculator");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("use wrongly");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}