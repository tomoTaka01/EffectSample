package effectsample;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BindDemo extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button();
        btn.setText("Do test");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SimpleIntegerProperty x = new SimpleIntegerProperty(0);
                SimpleIntegerProperty y = new SimpleIntegerProperty();
                y.bind(x);
                y.addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable o) {
                        System.out.println("Invalidate:" + o);
                    }
                });
                System.out.println(y.get());
                x.set(10);
                x.set(20);
                System.out.println(y.get());
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Test for InvalidationListener");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
