package Files;

import Files.Views.Elements.Nodes.Group;
import Files.Views.UserInterface;
import javafx.scene.Scene;
import javafx.stage.Stage;

// View manages the graphics
// This is the Root node of Application
public class View extends Group {
    public Stage stage;

    public UserInterface UI;

    public View(Stage stage){
        this.stage = stage;
    }


    public void show(){
        this.stage.setTitle("Pathfinding Project"); // Add Title

        UI = new UserInterface(this);
        this.addChildren(UI);
        this.stage.setScene(new Scene(this,400,300)); // Setup Scene
        addUI();
    }

    public void addUI(){

    }

    public void setMaximized(Boolean bool){
        this.stage.setMaximized(bool);
    }
}
