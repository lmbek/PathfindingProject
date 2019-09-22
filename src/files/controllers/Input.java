package files.controllers;

import files.Model;
import files.View;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import java.util.ArrayList;

public abstract class Input {

    private boolean fullScreen;
    protected final Model model;
    protected final View view;

    protected Input(Model model, View view){
        this.model = model;
        this.view = view;

        addEventListeners(view.getUI().getEventNodes());
    }

    private void addEventListeners(ArrayList<Node> nodes){
        nodes.forEach((node)->{
            String nodeName = node.getClass().getSimpleName();

            switch(nodeName){
                case "GeneratorButton":
                    node.setOnMouseClicked(event -> {
                        System.out.println("fullscreen "+fullScreen);
                        fullScreen = !fullScreen;
                        view.setMaximized(fullScreen);
                    });

                    node.setOnKeyPressed(event -> {
                        System.out.println(event.getCode());
                        if(event.getCode().equals(KeyCode.ENTER)) {
                            // do something
                            System.out.println("You Pressed Enter");
                        }
                    });
                    break;
                default:
                    break;
            }
        });
    }
}
