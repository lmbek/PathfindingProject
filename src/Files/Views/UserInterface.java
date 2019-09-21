package Files.Views;

import Files.View;
import Files.Views.Elements.Nodes.GridPane;
import Files.Views.Elements.Nodes.Group;
import Files.Views.UI.GeneratorButton;
import Files.Views.UI.Graphics;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class UserInterface extends Group {
    private View view;
    public GeneratorButton generatorButton;
    public Graphics graphics;

    public UserInterface(View view) {
        this.view = view;

        GridPane gridPane = new GridPane();

        gridPane.setStyle("-fx-background-color: blue");

        view.addChildren(gridPane);


        Text text = new Text(100,120,"Hello");
        text.setFont(Font.font("Verdana", 42));
        graphics = new Graphics();
        generatorButton = new GeneratorButton();
        generatorButton.setText("Klik mig");


        view.addChildren(generatorButton);
        view.addChildren(text);

    }



    public void addButton() {

    }

}
