import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectedComponentsTest {

    @Test
    public void return_one_for_one_character_string() {
        assertEquals(1, new ConnectedComponents("I").componentsNumber());
    }

    @Test
    void return_two_for_two_different_character_string() {
        assertEquals(2, new ConnectedComponents("IO").componentsNumber());
    }

    @Test
    void return_one_for_two_equals_character_string() {
        assertEquals(1, new ConnectedComponents("II").componentsNumber());
        assertEquals(1, new ConnectedComponents("OO").componentsNumber());
    }

    @Test
    void return_one_for_three_equals_character_string() {
        assertEquals(1, new ConnectedComponents("III").componentsNumber());
        assertEquals(1, new ConnectedComponents("OOO").componentsNumber());
    }

    @Test
    void return_three_for_alternate_chars() {
        assertEquals(3, new ConnectedComponents("OIO").componentsNumber());
        assertEquals(3, new ConnectedComponents("IOI").componentsNumber());
    }
}

