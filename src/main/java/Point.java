import java.util.Objects;

class Point {
    final int i;
    final int j;
    final int symbol;

    public Point(int i, int j, int symbol) {
        this.i = i;
        this.j = j;
        this.symbol = symbol;
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
