import Files.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class CalculatorTest {
    @Test
    public void TestingAdd(){
        System.out.println("Hej");
        Calculator calc = new Calculator();
        int result = calc.add(1,2);
        assertEquals(3, result);
        //assertEquals("A guy with a brain","Lars Morten Bek");
    }

}
