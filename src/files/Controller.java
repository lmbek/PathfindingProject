package files;

import files.controllers.Input;
import files.models.Graph;

public class Controller {
    private static boolean created = false;
    private final Model model;
    private final View view;
    private final Input input;

    Controller(Model model, View view){
        this.onlyOneInstance();
        this.model = model;
        this.view = view;
        this.input = new Input(model,view);
        this.run();
    }

    private void onlyOneInstance (){
        if (created) {
            System.err.println("You can only create one instance of the Controller class");
            System.exit(0);
        } else {
            created = true;
            System.out.println("Controller Created");
        }
    }

    // ON Start
    private void run(){
        //Graph graph = model.getGraph();
        //view.getUI().getGraphic().setGraph(graph);
        //view.getUI().getGraphic().draw();
    }
}