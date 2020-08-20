import java.util.Objects;
import java.util.Optional;

class Point {
    private final int i;
    private final int j;
    private final int symbol;

    Point(int i, int j, int symbol) {
        this.i = i;
        this.j = j;
        this.symbol = symbol;
    }

    Optional<Point> adjacentPoint(Direction d, Grid grid) {
        int _i, _j;
        switch (d) {
            case UP:
                _i = i - 1;
                _j = j;
                break;
            case DOWN:
                _i = i + 1;
                _j = j;
                break;
            case RIGHT:
                _i = i;
                _j = j - 1;
                break;
            case LEFT:
                _i = i;
                _j = j + 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + this);
        }

        Point adjacentPoint = grid.areValidCoordinates(_i, _j) ? grid.pointAt(_i, _j) : null;
        return Optional.ofNullable(adjacentPoint);
    }

    public boolean hasDifferentSymbol(Point other) {
        return this.symbol != other.symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return i == point.i &&
                j == point.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }

    @Override
    public String toString() {
        return "Point{" +
                "i=" + i +
                ", j=" + j +
                ", symbol=" + symbol +
                '}';
    }

}
