package effectsample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BlendSample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HBox root = new HBox();
        root.setPadding(new Insets(10));
        root.setSpacing(8);
        // Blending
        Node node1 = getBlendMode(BlendMode.MULTIPLY, Color.BLUE);
        Node node2 = getBlendMode(BlendMode.SRC_ATOP, Color.ORANGE);
        Node node3 = getBlendMode(BlendMode.SRC_OVER, Color.AQUA);
        root.getChildren().addAll(node1, node2, node3);
        stage.setScene(new Scene(root, 500, 300));
        stage.show();
    }

    static Node getBlendMode(BlendMode mode, Color color) {
        Rectangle r = new Rectangle();
        r.setX(590);
        r.setY(50);
        r.setWidth(50);
        r.setHeight(50);
        r.setFill(color);

        Circle c = new Circle();
        c.setFill(Color.rgb(255, 0, 0, 0.5f));
        c.setCenterX(590);
        c.setCenterY(50);
        c.setRadius(25);

        Group g = new Group();
        g.setBlendMode(mode);
        g.getChildren().add(r);
        g.getChildren().add(c);
        return g;
    }

    public static void main(String... args) {
        launch(args);
    }
}
