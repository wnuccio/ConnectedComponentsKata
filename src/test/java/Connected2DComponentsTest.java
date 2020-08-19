import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Connected2DComponentsTest {
    @Test
    void return_one_for_one_symbol() {
        assertEquals(1, new Connected2DComponents(new int[][]{
                {0, 0},
                {0, 0}
        }).componentsNumber());
    }

    @Test
    void return_two_for_two_symbols() {
        assertEquals(2, new Connected2DComponents(new int[][]{
                {0, 0},
                {0, 1}
        }).componentsNumber());
    }

//    @Test
//    void return_four_with_two_symbols_all_separated() {
//        assertEquals(4, new Connected2DComponents(new int[][]{
//                {1, 0},
//                {0, 1}
//        }).componentsNumber());
//    }
}
