package files;

import files.views.UserInterface;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

// View manages the graphics
// This is the Root node of Application
public class View extends Group {
    private final Stage stage;

    private UserInterface UI;

    View(Stage stage){
        this.stage = stage;
        this.show();
    }


    @SuppressWarnings("SpellCheckingInspection")
    private void show(){
        this.stage.setTitle("Pathfinding Project"); // Add Title

        UI = new UserInterface(this);
        this.getChildren().add(UI);
        this.stage.setScene(new Scene(this,400,300)); // Setup Scene
        addUI();
    }

    public UserInterface getUI(){
        return UI;
    }

    private void addUI(){

    }

    public void setMaximized(Boolean bool){
        this.stage.setMaximized(bool);
    }
}
