package files;

import files.views.UserInterface;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

// View manages the graphics
// This is the Root node of Application
public class View extends Group {
    private final Stage stage;
    private final UserInterface UI;

    View(Stage stage){
        this.stage = stage;
        UI = new UserInterface(this);
        this.show();

    }


    @SuppressWarnings("SpellCheckingInspection")
    private void show(){
        this.stage.setTitle("Pathfinding Project"); // Add Title

        this.getChildren().add(UI);
        this.stage.setScene(new Scene(this,800,600)); // Setup Scene
        addUI();
    }

    public UserInterface getUI(){
        return UI;
    }

    private void addUI(){

    }

    public Stage getStage(){
        return this.stage;
    }

    public void setMaximized(Boolean bool){
        this.stage.setMaximized(bool);
    }
}
