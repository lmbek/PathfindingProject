package Files.Views;

import Files.View;
import Files.Views.Elements.Nodes.GridPane;
import Files.Views.Elements.Nodes.Group;
import Files.Views.Elements.Nodes.HBox;
import Files.Views.Elements.Nodes.VBox;
import Files.Views.UI.GeneratorButton;
import Files.Views.UI.Graphics;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class UserInterface extends Group {
    private View view;
    public GeneratorButton generatorButton;
    public Graphics graphics;

    public UserInterface(View view) {
        this.view = view;


        HBox hbox = new HBox();
        //GridPane gridPane = new GridPane();
        hbox.setStyle("-fx-background-color: lightgreen;");
        //gridPane.setStyle("-fx-padding: 20px;");


        view.addChildren(hbox);


        Text text = new Text(100,120,"Hello");
        text.setFont(Font.font("Verdana", 42));

        graphics = new Graphics();
        generatorButton = new GeneratorButton();
        generatorButton.setText("Toggle Fullscreen");


        hbox.addChildren(generatorButton);
        hbox.addChildren(text);

    }



    public void addButton() {

    }

}
