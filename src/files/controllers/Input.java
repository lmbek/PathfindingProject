package files.controllers;

import files.Controller;
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
    private final Model model;
    private final View view;
    private final Controller controller;

    public Input(Model model, View view, Controller controller){
        this.model = model;
        this.view = view;
        this.controller = controller;

        addEventListeners(view.getUI().getEventNodes());
    }

    private void addEventListeners(ArrayList<Node> nodes){
        nodes.forEach((node)->{
            String nodeName = node.getId();

            switch(nodeName){
                case "showNodes":
                    CheckBox showNodes = (CheckBox) node;
                    view.getUI().getGraphic().showNodes = showNodes.isSelected();
                    showNodes.setOnAction(event -> {
                        boolean bool = showNodes.isSelected();
                        view.getUI().getGraphic().showNodes = bool;
                        view.getUI().getGraphic().draw();
                    });

                    break;
                case "showEdges":
                    CheckBox showEdges = (CheckBox) node;
                    view.getUI().getGraphic().showEdges = showEdges.isSelected();
                    showEdges.setOnAction(event -> {
                        boolean bool = showEdges.isSelected();
                        view.getUI().getGraphic().showEdges = bool;
                        view.getUI().getGraphic().draw();
                    });
                    break;
                case "selectField1":
                    ComboBox selectGraph = (ComboBox) node;
                    selectGraph.getItems().addAll(
                            "NavMesh",
                            "WayPoint"
                    );
                    selectGraph.setValue("NavMesh");
                    model.setGraphEnvironment((String) selectGraph.getValue());
                    selectGraph.setOnAction(event -> {
                        model.setGraphEnvironment((String) selectGraph.getValue());
                        controller.update();
                    });

                    break;
                case "selectField2":
                    ComboBox selectPathfinding = (ComboBox) node;
                    selectPathfinding.getItems().addAll(
                      "A*",
                      "Dijkstra"
                    );
                    selectPathfinding.setValue("A*");
                    model.setPathfinding((String) selectPathfinding.getValue());
                    selectPathfinding.setOnAction(event -> {
                        model.setPathfinding((String) selectPathfinding.getValue());
                        controller.updatePath();
                    });
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
                        controller.update();

                    });
                    break;
                default:
                    break;
            }
        });
    }
}
