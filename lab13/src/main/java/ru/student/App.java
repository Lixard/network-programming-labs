package ru.student;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private final boolean isServer = false;

    private final TextArea messages = new TextArea();
    private final NetworkConnection connection = isServer ? createServer() : createClient();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        connection.start();
    }

    @Override
    public void stop() throws Exception {
        connection.close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    private Parent createContent() {
        messages.setPrefHeight(550);
        final var input = new TextField();
        input.setOnAction(event -> {
            var message = isServer ? "server says: " : "client says: ";
            message += input.getText();
            input.clear();

            messages.appendText(message + "\n");
            try {
                connection.send(message);
            } catch (IOException e) {
                messages.appendText("Message failed to send\n");
            }
        });
        final var root = new VBox(20, messages, input);
        root.setPrefSize(600, 600);
        return root;
    }

    private Server createServer() {
        return new Server(8080, data -> Platform.runLater(() -> messages.appendText(data.toString() + "\n")));
    }

    private Client createClient() {
        return new Client("localhost", 8080, data ->
                Platform.runLater(() -> messages.appendText(data.toString() + "\n")));
    }
}
