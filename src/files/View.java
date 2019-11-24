package files;

import files.views.UserInterface;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
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
    private int sceneWidth = 640;
    private int sceneHeight = 480;
    private String viewFXMLLink = "View.fxml";
    private Node fxml;


    View(Stage stage){
        this.onlyOneInstance(); // Limit to only 1 instance of the Model class
        this.stage = stage;
        this.setScene(stage);
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
            this.fxml = FXMLLoader.load(getClass().getResource(this.viewFXMLLink));
            this.convertFXMLToNodes();
        } catch (Exception exception){
            System.err.println(exception);
            System.err.println("FXML couldnt load...");
            System.exit(0);
        }
    }

    private void convertFXMLToNodes(){
        try {
            /*
            selectFrom = (ComboBox) this.fxml.lookup("#selectFrom");
            selectTo = (ComboBox) this.fxml.lookup("#selectTo");
            selectTime = (ComboBox) this.fxml.lookup("#selectTime");
            departure = (RadioButton) this.fxml.lookup("#departure");
            arrival = (RadioButton) this.fxml.lookup("#arrival");
            button = (Button) this.fxml.lookup("#seeDepartures");
            tableView = (TableView) this.fxml.lookup("#tableView");
            message = (Label) this.fxml.lookup("#message");
            */
        } catch(Exception exception){
            System.err.println(exception);
            System.err.println("Couldnt convert FXML to Nodes. Check if Type is correct.");
            System.exit(0);
        }
    }


    private void setScene(Stage stage){
        ScrollPane scrollPane = new ScrollPane(); // ScrollPane
        scrollPane.setContent(this.fxml);
        scrollPane.setStyle("-fx-alignment: center");
        stage.setScene(new Scene(scrollPane, sceneWidth, sceneHeight)); // Scene with ScrollPane
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
