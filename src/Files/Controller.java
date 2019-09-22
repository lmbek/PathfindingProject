package Files;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;

public class Controller {
    private Model model;
    private View view;

    private boolean fullScreen;

    protected Controller(Model model, View view){
        this.model = model;
        this.view = view;

        addEventListener(view.UI.generatorButton);
        addKeyListener(view.UI.generatorButton);
    }

    private void addEventListener(Node node){
        node.setOnMouseClicked( event-> {
            System.out.println("fullscreen "+fullScreen);
            fullScreen = !fullScreen;
            this.view.setMaximized(fullScreen);
        });
    }

    private void addKeyListener(Node node){
        node.setOnKeyPressed(event -> {
            System.out.println(event.getCode());
            if(event.getCode().equals(KeyCode.ENTER)) {
                // do something
                System.out.println("You Pressed Enter");
            }
        });
    }
}
