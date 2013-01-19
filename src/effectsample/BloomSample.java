package effectsample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BloomSample extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        HBox root = new HBox();
        root.setPadding(new Insets(10));
        root.setSpacing(8);
        // Bloom
        Node node1 = getBloom(0, Color.DARKBLUE);
        Node node2 = getBloom(1.0, Color.DARKGREEN);
        root.getChildren().addAll(node1, node2);
        stage.setScene(new Scene(root, 500, 300));
        stage.show();
    }

    static Node getBloom(double val, Color fillColor) {
        Group g = new Group();
        Rectangle r = new Rectangle();
        r.setX(10);
        r.setY(10);
        r.setWidth(160);
        r.setHeight(80);
        r.setFill(fillColor);

        Text t = new Text();
        t.setText("Bloom!");
        t.setFill(Color.YELLOW);
        t.setFont(Font.font("null", FontWeight.BOLD, 36));
        t.setX(25);
        t.setY(65);

        g.setCache(true);
        Bloom bloom = new Bloom();
        bloom.setThreshold(val);
        g.setEffect(bloom);
        g.getChildren().add(r);
        g.getChildren().add(t);
        g.setTranslateX(100);
        return g;
    }

    public static void main(String... args) {
        launch(args);
    }
}
