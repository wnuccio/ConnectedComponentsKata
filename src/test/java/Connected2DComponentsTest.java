import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Connected2DComponentsTest {
    @Test
    void return_one_for_one_char() {
        assertEquals(1, new Connected2DComponents(
                "OO",
                "OO"
        ).componentsNumber());
    }
}
