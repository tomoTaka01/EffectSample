package effectsample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PerspectiveSample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HBox root = new HBox();
        root.setPadding(new Insets(10));
        root.setSpacing(8);
        Node node1 = getPerspective();
        root.getChildren().addAll(node1);
        stage.setScene(new Scene(root, 500, 300));
        stage.show();
    }

    static Node getPerspective() {
        Group g = new Group();
        PerspectiveTransform pt = new PerspectiveTransform();
        pt.setUlx(10);
        pt.setUly(10);
        pt.setUrx(210);
        pt.setUry(40);
        pt.setLrx(210);
        pt.setLry(60);
        pt.setLlx(10);
        pt.setLly(90);
        g.setEffect(pt);
        g.setCache(true);
        Rectangle r = new Rectangle();
        r.setX(10);
        r.setY(10);
        r.setWidth(280);
        r.setHeight(80);
        r.setFill(Color.DARKBLUE);
        Text t = new Text();
        t.setX(20);
        t.setY(65);
        t.setText("Perspective");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 36));
        g.getChildren().addAll(r, t);
        return g;
    }

    public static void main(String... args) {
        launch(args);
    }
}
