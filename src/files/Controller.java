package files;

import files.controllers.Input;

public class Controller {
    private final Model model;
    private final View view;
    private final Input input;

    Controller(Model model, View view){
        this.model = model;
        this.view = view;
        this.input = new Input(model,view);
    }
}