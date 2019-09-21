package Files.Views.Elements.Nodes;

import Files.Views.Nodes;
import javafx.scene.Node;


public class GridPane extends javafx.scene.layout.GridPane implements Nodes {
    public void addChildren(Node child){
        this.getChildren().add(child);
    }

    public void removeChildren(Node child){
        this.getChildren().remove(child);
    }
}
