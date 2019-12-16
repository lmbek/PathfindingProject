package files.controllers;

import files.Controller;
import files.Model;
import files.View;
import files.models.Environment;
import files.models.Shape;
import files.models.graph.Edge;
import files.models.graph.Vertex;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Iterator;

public class Input {
    private final Model model;
    private final View view;
    private final Controller controller;
    private Vertex start = new Vertex("start",10,10);
    private Vertex end = new Vertex("end",500,500);

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


                        model.getGraph().getVertices().forEach(vertex -> {
                            // Iterator necessary because we need to remove from ArrayList
                            for (Iterator<Edge> iterator = vertex.edges.iterator(); iterator.hasNext(); ) {
                                Edge edge = iterator.next();
                                if(edge.getFromVertex().equals(start)||edge.getToVertex().equals(start)||edge.getFromVertex().equals(end)||edge.getToVertex().equals(end)){
                                    iterator.remove();
                                }
                            }
                        });

                        start.edges.clear();
                        end.edges.clear();
                        //model.getGraph().getStart().edges.clear();
                        //model.getGraph().getEnd().edges.clear();
                        model.getGraph().getVertices().remove(start);
                        model.getGraph().getVertices().remove(end);
                        model.getGraph().setStart(null, model.getEnvironment());
                        model.getGraph().setEnd(null, model.getEnvironment());
                        model.getPathfinding().state = "unset";


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

                        model.getGraph().getVertices().forEach(vertex -> {
                            // Iterator necessary because we need to remove from ArrayList
                            for (Iterator<Edge> iterator = vertex.edges.iterator(); iterator.hasNext(); ) {
                                Edge edge = iterator.next();
                                if(edge.getFromVertex().equals(start)||edge.getToVertex().equals(start)||edge.getFromVertex().equals(end)||edge.getToVertex().equals(end)){
                                    iterator.remove();
                                }
                            }
                        });

                        start.edges.clear();
                        end.edges.clear();
                        model.getGraph().getStart().edges.clear();
                        model.getGraph().getEnd().edges.clear();
                        model.getGraph().getVertices().remove(start);
                        model.getGraph().getVertices().remove(end);
                        model.getGraph().setStart(null, model.getEnvironment());
                        model.getGraph().setEnd(null, model.getEnvironment());
                        model.getPathfinding().state = "unset";

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
                        switch (model.getPathfinding().state){
                            case "unset":
                                start.setX(x);
                                start.setY(y);
                                end.setX(x);
                                end.setY(y);

                                model.getGraph().setStart(start,model.getEnvironment());
                                model.getGraph().setEnd(null,model.getEnvironment());
                                model.getPathfinding().setStart(start);
                                model.getPathfinding().setEnd(null);
                                model.getPathfinding().state = "halfSet";
                                controller.updatePath();
                                break;
                            case "halfSet":
                                end.setX(x);
                                end.setY(y);
                                model.getGraph().setEnd(end,model.getEnvironment());
                                model.getPathfinding().setEnd(end);
                                model.getPathfinding().state = "set";
                                controller.updatePath();
                                break;
                            case "set":

                                model.getGraph().getVertices().forEach(vertex -> {
                                    // Iterator necessary because we need to remove from ArrayList
                                    for (Iterator<Edge> iterator = vertex.edges.iterator(); iterator.hasNext(); ) {
                                        Edge edge = iterator.next();
                                        if(edge.getFromVertex().equals(start)||edge.getToVertex().equals(start)||edge.getFromVertex().equals(end)||edge.getToVertex().equals(end)){
                                            iterator.remove();
                                        }
                                    }
                                });

                                start.edges.clear();
                                end.edges.clear();
                                model.getGraph().getStart().edges.clear();
                                model.getGraph().getEnd().edges.clear();
                                model.getGraph().getVertices().remove(start);
                                model.getGraph().getVertices().remove(end);
                                model.getGraph().setStart(null, model.getEnvironment());
                                model.getGraph().setEnd(null, model.getEnvironment());

                                model.getPathfinding().state = "unset";
                                controller.updatePath();
                                break;
                            default:
                                System.err.println("Got out of addEventListener states in the input class");
                                System.exit(0);
                            ;
                        }

                        System.out.println("state:"+ model.getPathfinding().state);


                    });
                    break;
                case "button":
                    Button button = (Button) node;
                    button.setOnAction(event -> {
                        model.getEnvironment().generateEnvironment();



                        model.getGraph().getVertices().forEach(vertex -> {
                            // Iterator necessary because we need to remove from ArrayList
                            for (Iterator<Edge> iterator = vertex.edges.iterator(); iterator.hasNext(); ) {
                                Edge edge = iterator.next();
                                if(edge.getFromVertex().equals(start)||edge.getToVertex().equals(start)||edge.getFromVertex().equals(end)||edge.getToVertex().equals(end)){
                                    iterator.remove();
                                }
                            }
                        });

                        start.edges.clear();
                        end.edges.clear();
                        //model.getGraph().getStart().edges.clear();
                        //model.getGraph().getEnd().edges.clear();
                        model.getGraph().getVertices().remove(start);
                        model.getGraph().getVertices().remove(end);
                        model.getGraph().setStart(null, model.getEnvironment());
                        model.getGraph().setEnd(null, model.getEnvironment());
                        model.getPathfinding().state = "unset";


                        controller.update();

                    });
                    break;
                default:
                    break;
            }
        });
    }
}
