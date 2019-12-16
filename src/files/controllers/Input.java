package files.controllers;

import files.Model;
import files.View;
import files.models.Environment;
import files.models.Shape;
import files.models.graph.Vertex;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

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
            String nodeName = node.getId();

            switch(nodeName){
                case "showNodes":
                    CheckBox showNodes = (CheckBox) node;
                    showNodes.setOnAction(event -> {
                        System.out.println("yeeyeye");

                    });

                    break;
                case "showEdges":
                    CheckBox showEdges = (CheckBox) node;
                    showEdges.setOnAction(event -> {
                        System.out.println("yeeyeye2");
                    });
                    break;
                case "selectField1":
                    ComboBox selectGraph = (ComboBox) node;
                    selectGraph.getItems().addAll(
                            "NavMesh",
                            "WayPoint"
                    );
                    selectGraph.setValue("NavMesh");

                    break;
                case "selectField2":
                    ComboBox selectPathfinding = (ComboBox) node;
                    selectPathfinding.getItems().addAll(
                      "A*",
                      "Dijkstra"
                    );
                    selectPathfinding.setValue("A*");

                    break;
                case "canvas":
                    Canvas canvas = (Canvas) node;
                    canvas.setOnMouseClicked(event -> {
                        double x = event.getX();
                        double y = event.getY();
                        System.out.println("x:"+x+",y:"+y);
                    });
                    break;
                case "button":
                    Button button = (Button) node;
                    button.setOnAction(event -> {
                        model.getEnvironment().generateEnvironment();
                        model.getGraph().recalculate(model.getEnvironment());
                        model.getPathfinding().run(model.getGraph());
                        ArrayList<Vertex> resultPath = model.getPathfinding().getResult();

                        ArrayList<Shape> shape = model.getEnvironment().getShapes();
                        view.getUI().getGraphic().setEnvironment(shape);
                        view.getUI().getGraphic().setResultPath(resultPath);
                        view.getUI().getGraphic().draw();

                    });
                    break;
                default:
                    break;
            }
        });
    }
}
