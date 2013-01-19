package effectsample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DropShadowSample extends Application {    
    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
        Scene scene = new Scene(new Group(), 840, 680);
        ObservableList<Node> content = ((Group)scene.getRoot()).getChildren();
        content.add(dropShadow());
        stage.setScene(scene);
    }

    static Node dropShadow() {
        Group g = new Group();
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setOffsetX(3.0);
        ds.setColor(Color.GRAY);
        Text t = new Text();
        t.setEffect(ds);
        t.setCache(true);
        t.setX(20f);
        t.setY(70f);
        t.setFill(Color.RED);
        t.setText("JavaFX drop shadow effect");
        t.setFont(Font.font("null", FontWeight.BOLD, 32));
        DropShadow ds1 = new DropShadow();
        ds1.setOffsetY(4f);
        ds1.setOffsetY(4f);
        ds1.setColor(Color.CORAL);
        Circle c = new Circle();
        c.setEffect(ds1);
        c.setCenterX(50);
        c.setCenterY(325);
        c.setRadius(30);
        c.setFill(Color.RED);
        c.setCache(true);
        
        g.getChildren().addAll(t,c);
        return g;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
