package files;

import files.controllers.Input;

public class Controller extends Input {
    private Model model;
    private View view;
    Controller(Model model, View view){
        super(model, view);
    }
}