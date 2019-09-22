package Files;

import Files.Views.Elements.Nodes.Group;
import Files.Views.UserInterface;
import javafx.scene.Scene;
import javafx.stage.Stage;

// View manages the graphics
// This is the Root node of Application
public class View extends Group {
    private Stage stage;

    protected UserInterface UI;

    protected View(Stage stage){
        this.stage = stage;
        this.show();
    }


    private void show(){
        this.stage.setTitle("Pathfinding Project"); // Add Title

        UI = new UserInterface(this);
        this.addChildren(UI);
        this.stage.setScene(new Scene(this,400,300)); // Setup Scene
        addUI();
    }

    private void addUI(){

    }

    protected void setMaximized(Boolean bool){
        this.stage.setMaximized(bool);
    }
}
