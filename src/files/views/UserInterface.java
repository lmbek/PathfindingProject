package files.views;

import files.View;
import files.views.userInterface.GeneratorButton;
import files.views.userInterface.Graphics;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.ArrayList;


public class UserInterface extends Group {
    private GeneratorButton generatorButton;
    private final ArrayList<Node> eventNodes = new ArrayList<>();

    public UserInterface(View view) {


        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color: lightgreen;");
        hbox.setStyle("-fx-padding: 20px;");

        view.getChildren().add(hbox);

        addGeneratorButton();
        Text text = addText();

        Graphics graphics = new Graphics();


        hbox.getChildren().add(generatorButton);
        hbox.getChildren().add(text);

    }

    public ArrayList<Node> getEventNodes(){
        return eventNodes;
    }

    private void addGeneratorButton(){
        generatorButton = new GeneratorButton();
        generatorButton.setText("Toggle Fullscreen");
        eventNodes.add(generatorButton);
    }

    private Text addText(){
        Text text = new Text(100,120,"Hello");
        text.setFont(Font.font("Verdana", 42));
        return text;
    }
}
