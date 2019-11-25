package files;

import files.views.UserInterface;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

// View manages the graphics
// This is the Root node of Application
public class View extends Group {
    private static boolean created = false; // if created
    private UserInterface UI;
    private Stage stage;

    // Settings
    private int sceneWidth = 1280;
    private int sceneHeight = 720;
    private String viewFXMLLink = "views/view.fxml";
    private String viewCSSLink = "views/view.css";
    private Node fxml;


    View(Stage stage){
        this.onlyOneInstance(); // Limit to only 1 instance of the Model class
        this.stage = stage;
        this.loadFXML();
        //this.loadCSS();
        UI = new UserInterface(this);
        this.getChildren().add(UI);
        addUI();
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

    private void loadFXML(){
        try {
            System.out.println("load");
            this.fxml = FXMLLoader.load(getClass().getResource(this.viewFXMLLink));
            this.setScene(stage);
            this.convertFXMLToNodes();
        } catch (Exception exception){
            System.err.println(exception);
            System.err.println("FXML couldnt load...");
            System.exit(0);
        }
    }
/*
    private void loadCSS(){
        try {
            this.css = FXMLLoader.load(getClass().getResource(this.viewCSSLink));
            this.convertFXMLToNodes();
        } catch (Exception exception){
            System.err.println(exception);
            System.err.println("CSS couldnt load...");
            System.exit(0);
        }
    }

 */

    private void convertFXMLToNodes(){
        try {
            /*
            selectFrom = (ComboBox) this.fxml.lookup("#selectFrom");
            button = (Button) this.fxml.lookup("#seeDepartures");
            tableView = (TableView) this.fxml.lookup("#tableView");
            message = (Label) this.fxml.lookup("#message");
            */
            System.out.println("test");
        } catch(Exception exception){
            System.err.println(exception);
            System.err.println("Couldnt convert FXML to Nodes. Check if Type is correct.");
            System.exit(0);
        }
    }

    private void setScene(Stage stage){
        stage.setScene(new Scene((Parent)this.fxml, sceneWidth, sceneHeight)); // Scene with ScrollPane
    }


    public UserInterface getUI(){
        return UI;
    }

    private void addUI(){ }
    public void setMaximized(Boolean bool){
        this.stage.setMaximized(bool);
    }
}
