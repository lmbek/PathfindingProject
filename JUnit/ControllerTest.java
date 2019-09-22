import Files.Controller;
import Files.Views.Elements.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

public class ControllerTest {
    private Controller controller;

    ControllerTest(){
        controller = new Controller();
    }

    @Test
    public void TestingConstructor(){
        controller.addEventListener(new Button());

        //assertEquals(3, result);
        //assertEquals("A guy with a brain","Lars Morten Bek");
    }
    @Test
    public void TestingConstructor2(){


        //assertEquals(3, result);
        //assertEquals("A guy with a brain","Lars Morten Bek");
    }

}
