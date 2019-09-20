package Files.Views;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// View manages the graphics
public class View {
    private Stage stage;


    public View(Stage stage){
        this.stage = stage;
    }

    public void show(){
        this.stage.setTitle("Pathfinding Project");
        Group group = new Group();
        this.stage.setScene(new Scene(group,400,300));
        Text text = new Text();
        text.setText("Test");
        Button button = new Button();
        button.setText("Klik mig");
        group.getChildren().add(button);
        group.getChildren().add(text);
        MyCanvas canvas = new MyCanvas();

        this.stage.setMaximized(true);
        this.stage.show();
    }
}
