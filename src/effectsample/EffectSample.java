/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package effectsample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author tomo
 */
public class EffectSample extends Application {
    
    @Override
    public void start(Stage stage) {
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5,0,5,0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(170);
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(5,5,5,5));
        vBox.setSpacing(10);
        // Blending
        Node node1 = getBlendMode(BlendMode.MULTIPLY, Color.BLUE);
        Node node2 = getBlendMode(BlendMode.SRC_ATOP, Color.ORANGE);
        Node node3 = getBlendMode(BlendMode.SRC_OVER, Color.AQUA);
        // Bloom
        Node node4 = getBloom(0, Color.DARKBLUE);
        Node node5 = getBloom(1.0, Color.DARKGREEN);
        // Blur
        Scene scene = new Scene(vBox, 800, 500);
        
        stage.setTitle("Hello World!");
        stage.setScene(scene);
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
        g.setTranslateX(200);
        return g;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
