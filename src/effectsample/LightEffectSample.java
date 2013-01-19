package effectsample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LightEffectSample extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
        Scene scene = new Scene(new Group());
        ObservableList<Node> content = ((Group)scene.getRoot()).getChildren();
        content.add(lighting());
        stage.setScene(scene);
    }
    static Node lighting() {
        Distant light = new Distant();
        light.setAzimuth(-135);
        Lighting l = new Lighting();
        l.setLight(light);
        l.setSurfaceScale(5);
        Text t = new Text();
        t.setText("JavaFX" + System.getProperty("line.separator") + "Lighting!");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 70));
        t.setX(10);
        t.setY(10);
        t.setTextOrigin(VPos.TOP);
        t.setEffect(l);
        t.setTranslateX(0);
        t.setTranslateY(30);
        return t;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
