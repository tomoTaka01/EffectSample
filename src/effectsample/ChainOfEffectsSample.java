package effectsample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChainOfEffectsSample extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
        Scene scene = new Scene(new Group());
        ObservableList<Node> content = ((Group)scene.getRoot()).getChildren();
//        content.addAll(chainEffects(true), chainEffects(false));
        content.add(chainEffects(true));                
        stage.setScene(scene);
                
    }
    static Node chainEffects(boolean dropShadow) {
        Rectangle r = new Rectangle();
        r.setFill(Color.RED);
        r.setWidth(200);
        r.setHeight(100);
        r.setX(20);
        r.setY(20);
        DropShadow ds = new DropShadow();
        ds.setOffsetY(5);
        ds.setOffsetX(5);
        ds.setColor(Color.GRAY);
        Reflection reflection = new Reflection();
        if (dropShadow) {
            ds.setInput(reflection);
            r.setEffect(ds);
        } else {
            reflection.setInput(ds);
            r.setEffect(reflection);
        }
        return r;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
