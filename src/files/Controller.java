package files;

import files.controllers.Input;

public class Controller {
    private final Model model;
    private final View view;



    Controller(Model model, View view){
        this.model = model;
        this.view = view;

        Input input = new Input(model,view);
    }


}
