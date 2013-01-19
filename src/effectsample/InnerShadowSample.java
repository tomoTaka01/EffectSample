package effectsample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InnerShadowSample extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(8);
        Node node1 = getInnerShadow();
        root.getChildren().addAll(node1);
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }

    private Node getInnerShadow() {
        InnerShadow is = new InnerShadow();
        is.setOffsetX(2.0f);
        is.setOffsetY(2.0f);
                
        Text t = new Text();
        t.setEffect(is);
        t.setX(20);
        t.setY(100);
        t.setText("Inner Shadow");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 80));
        
        t.setTranslateX(300);
        t.setTranslateY(300);
        return t;
    }

    public static void main(String... args) {
        launch(args);
    }
}
