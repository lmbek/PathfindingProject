package Files.Controllers;

import Files.Models.Model;
import Files.Views.View;
import javafx.stage.Stage;

public class Controller {

    private View view;
    private Model model;

    public Controller(Stage stage){
        model = new Model();

        view = new View(stage);
        view.show();


    }

}
