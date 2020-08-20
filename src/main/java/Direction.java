import java.util.Optional;

enum Direction {
    UP, DOWN, RIGHT, LEFT;

    Optional<Point> adjacentPoint(Point point, Grid connected2DComponents) {
        int i, j;
        switch (this) {
            case UP:
                i = point.i - 1;
                j = point.j;
                break;
            case DOWN:
                i = point.i + 1;
                j = point.j;
                break;
            case RIGHT:
                i = point.i;
                j = point.j - 1;
                break;
            case LEFT:
                i = point.i;
                j = point.j + 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + this);
        }

        Point adjacentPoint = connected2DComponents.areValid(i, j) ? new Point(i, j, connected2DComponents.symbolAt(i, j)) : null;
        return Optional.ofNullable(adjacentPoint);
    }
}
