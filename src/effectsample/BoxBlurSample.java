package effectsample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BoxBlurSample extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(8);
        // BoxBlur
        Node node1 = getBoxBlur(5, 5);
        Node node2 = getBoxBlur(10, 10);
        root.getChildren().addAll(node1, node2);
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }

    private Node getBoxBlur(double width, double heigth) {
        Text t = new Text();
        t.setText("Blurry Text!");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 36));
        t.setX(10);
        t.setY(40);
        BoxBlur bb = new BoxBlur();
        bb.setWidth(width);
        bb.setHeight(heigth);
        bb.setIterations(3);
        t.setEffect(bb);
        t.setTranslateX(300);
        t.setTranslateY(100);
        return t;
    }

    public static void main(String... args) {
        launch(args);
    }
}
