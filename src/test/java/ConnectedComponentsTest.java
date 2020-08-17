import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ConnectedComponentsTest {

    @Test
    public void return_one_for_one_character_string() {
        assertEquals(1, new ConnectedComponents("I").componentsNumber());
    }

}
