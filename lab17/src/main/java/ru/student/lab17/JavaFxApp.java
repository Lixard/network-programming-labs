package ru.student.lab17;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import ru.student.lab17.controller.MainPageController;

public class JavaFxApp extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        ApplicationContextInitializer<GenericApplicationContext> initializer =
                context -> context.registerBean(Application.class, () -> JavaFxApp.this);
        this.applicationContext = new SpringApplicationBuilder()
                .sources(App.class)
                .initializers(initializer)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }

    @Override
    public void start(Stage primaryStage) {
        final var fxWeaver = applicationContext.getBean(FxWeaver.class);
        final var scene = new Scene(fxWeaver.loadView(MainPageController.class));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
