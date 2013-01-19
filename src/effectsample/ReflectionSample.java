package effectsample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReflectionSample extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
        Scene scene = new Scene(new Group(), 840,680);
        ObservableList<Node> content = ((Group)scene.getRoot()).getChildren();
        content.add(reflection());
        stage.setScene(scene);
    }
    static Node reflection() {
        Text t = new Text();
        t.setX(10);
        t.setY(50);
        t.setCache(true);
        t.setText("Reflection in JavaFX");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 30));
        Reflection r = new Reflection();
        r.setFraction(0.9);
        t.setEffect(r);
        return t;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
