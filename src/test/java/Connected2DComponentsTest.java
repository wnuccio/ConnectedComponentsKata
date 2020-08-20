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
    void return_five_ares_in_linear_string() {
        assertEquals(5, new Connected2DComponents(new int[][]{
                {0, 0, 0, 1, 1, 2, 2, 3, 0, 0}
        }).componentsNumber());
    }

    @Test
    void recognize_area_moving_from_a_point_in_all_directions() {
        assertEquals(2, new Connected2DComponents(new int[][]{
                {0, 1},
                {1, 1}
        }).componentsNumber());
    }

    @Test
    void recognize_linear_square_inside_square() {
        assertEquals(3, new Connected2DComponents(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        }).componentsNumber());
    }

    @Test
    void return_ten_areas() {
        assertEquals(10, new Connected2DComponents(new int[][]{
                {1, 5, 3, 3, 3, 5},
                {0, 5, 5, 4, 4, 5},
                {0, 2, 5, 4, 5, 5},
                {1, 2, 5, 1, 5, 1}
        }).componentsNumber());
    }
}
