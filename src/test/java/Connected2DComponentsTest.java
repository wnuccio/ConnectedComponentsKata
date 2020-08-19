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

    @Test
    void return_four_with_two_symbols_all_separated() {
        assertEquals(4, new Connected2DComponents(new int[][]{
                {1, 0},
                {0, 1}
        }).componentsNumber());
    }

    @Test
    void return_three_areas() {
        assertEquals(3, new Connected2DComponents(new int[][]{
                {1, 1, 0},
                {0, 1, 0}
        }).componentsNumber());
    }

    @Test
    void return_five_areas() {
        assertEquals(5, new Connected2DComponents(new int[][]{
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {0, 1, 0, 1}
        }).componentsNumber());
    }

    @Test
    void return_ten_areas() {
        assertEquals(10, new Connected2DComponents(new int[][]{
                {7, 1, 2, 2, 2, 3},
                {8, 1, 1, 4, 4, 3},
                {8, 0, 1, 4, 3, 3},
                {9, 0, 1, 5, 3, 6}
        }).componentsNumber());
    }
}
