package effectsample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GaussianBlurSample extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(8);
        // BoxBlur
        Node node1 = getGaussianBlur();
        root.getChildren().addAll(node1);
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }

    private Node getGaussianBlur() {
        Text t = new Text();
        t.setX(10.0f);
        t.setY(140.0f);
        t.setCache(true);
        t.setText("Gaussian Blur");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 36));
        
        t.setEffect(new GaussianBlur());
        return t;
    }

    public static void main(String... args) {
        launch(args);
    }
}
