package files.controllers;

import files.Model;
import files.View;
import files.models.Environment;
import files.models.Shape;
import files.models.graph.Vertex;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class Input {

    private boolean fullScreen;
    private final Model model;
    private final View view;

    public Input(Model model, View view){
        this.model = model;
        this.view = view;

        addEventListeners(view.getUI().getEventNodes());
    }

    private void addEventListeners(ArrayList<Node> nodes){
        nodes.forEach((node)->{
            String nodeName = node.getClass().getSimpleName().toLowerCase();

            switch(nodeName){
                case "button":
                    node.setOnMouseClicked(event -> {
                        model.getEnvironment().generateEnvironment();
                        model.getGraph().recalculate(model.getEnvironment());
                        model.getPathfinding().run(model.getGraph());
                        ArrayList<Vertex> resultPath = model.getPathfinding().getResult();

                        ArrayList<Shape> shape = model.getEnvironment().getShapes();
                        view.getUI().getGraphic().setEnvironment(shape);
                        view.getUI().getGraphic().setResultPath(resultPath);
                        view.getUI().getGraphic().draw();

                    });
/*
                    node.setOnKeyPressed(event -> {
                        System.out.println(event.getCode());
                        if(event.getCode().equals(KeyCode.ENTER)) {
                            // do something
                            System.out.println("You Pressed Enter");
                        }
                    });
*/
                    break;
                default:
                    break;
            }
        });
    }
}
