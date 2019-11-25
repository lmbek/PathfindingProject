package files;

import files.views.UserInterface;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// View manages the graphics
// This is the Root node of Application
public class View {
    private static boolean created = false; // if created
    private Stage stage;

    // Settings
    private int sceneWidth = 1280;
    private int sceneHeight = 720;
    private String viewFXMLLink = "views/view.fxml";
    private UserInterface UI;

    View(Stage stage){
        this.onlyOneInstance(); // Limit to only 1 instance of the Model class
        this.stage = stage;
        Node fxml = this.loadFXML();
        this.setScene((Parent)fxml);
        this.UI = new UserInterface(fxml);
    }

    private void onlyOneInstance (){
        if (created) {
            System.err.println("You can only create one instance of the View class");
            System.exit(0);
        } else {
            created = true;
            System.out.println("View Created");
        }
    }

    private Node loadFXML(){
        try {
            return FXMLLoader.load(getClass().getResource(this.viewFXMLLink));
        } catch (Exception exception){
            System.err.println("FXML couldnt load..."); // dont care about the exception message, just tell us fxml didnt load
            System.exit(0);
            return null;
        }
    }

    private void setScene(Parent fxml){
        this.stage.setScene(new Scene(fxml, sceneWidth, sceneHeight)); // Scene with ScrollPane
    }

    public UserInterface getUI(){
        return UI;
    }

    public void setMaximized(Boolean bool){
        this.stage.setMaximized(bool);
    }
}
