package effectsample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MotionBlurSample extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(8);
        // BoxBlur
        Node node1 = getMotionBlur(15, 45);
        root.getChildren().addAll(node1);
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }

    private Node getMotionBlur(double radius, double angle) {
        Text t = new Text();
        t.setX(20.0f);
        t.setY(80.0f);
        t.setText("Motion Blur");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 60));
        MotionBlur mb = new MotionBlur();
        mb.setRadius(radius);
        mb.setAngle(angle);
        
        t.setEffect(mb);
        t.setTranslateX(300);
        t.setTranslateY(150);
        return t;
    }

    public static void main(String... args) {
        launch(args);
    }
}
