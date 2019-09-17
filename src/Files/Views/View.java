package Files.Views;

import javafx.scene.Group;
import javafx.scene.Scene;
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
        this.stage.setMaximized(true);
        this.stage.show();
    }
}
