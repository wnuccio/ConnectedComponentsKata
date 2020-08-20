import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Connected2DComponents {
    private final int[][] grid;
    private final int iMax;
    private final int jMax;

    public Connected2DComponents(int[][] grid) {
        this.grid = grid;
        this.iMax = grid.length - 1;
        this.jMax = grid[0].length - 1;
    }

    private void extendConnectionInAllDirections(Point point, Connection currentConnection, List<Connection> foundConnections) {
        for (Direction d: Direction.values()) {
            extendConnection(currentConnection, point, d, foundConnections);
        }
    }

    private void extendConnection(Connection currentConnection, Point currentPoint, Direction d, List<Connection> foundConnections) {
        Point adjacentPoint = adjacentPoint(currentPoint, d).orElse(null);

        if (adjacentPoint == null) return;
        if (currentConnection.contains(adjacentPoint)) return;
        if (foundConnections.stream().anyMatch(conn -> conn.contains(adjacentPoint))) return;
        if (currentPoint.symbol != adjacentPoint.symbol) return;

        currentConnection.add(adjacentPoint);
        extendConnectionInAllDirections(adjacentPoint, currentConnection, foundConnections);
    }

    private Optional<Point> adjacentPoint(Point point, Direction d) {
        int i, j;
        switch (d) {
            case UP:
                i = point.i-1;
                j = point.j;
                break;
            case DOWN:
                i = point.i+1;
                j = point.j;
                break;
            case RIGHT:
                i = point.i;
                j = point.j-1;
                break;
            case LEFT:
                i = point.i;
                j = point.j+1;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + d);
        }

        Point adjacentPoint = areValid(i, j) ? new Point(i, j, symbolAt(i, j)) : null;
        return Optional.ofNullable(adjacentPoint);
    }

    private boolean areValid(int i, int j) {
        return (i >= 0 && i<=iMax && j>=0 && j<=jMax);
    }

    public int componentsNumber() {
        List<Connection> foundConnections = new LinkedList<>();

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; j++) {
                int symbol = symbolAt(i, j);
                Point currentPoint = new Point(i, j, symbol);
                if (!inAnyConnection(currentPoint, foundConnections)) {
                    Connection newConnection = Connection.empty();
                    newConnection.add(currentPoint);
                    extendConnectionInAllDirections(currentPoint, newConnection, foundConnections);
                    foundConnections.add(newConnection);
                }
            }
        }
        return foundConnections.size();
    }

    private int symbolAt(int i, int j) {
        return grid[i][j];
    }

    private boolean inAnyConnection(Point currentPoint, List<Connection> allConnections) {
        for (Connection connection : allConnections) {
            if (connection.contains(currentPoint))
                return true;
        }

        return false;
    }

    private enum Direction {
        UP, DOWN, RIGHT, LEFT
    }
}
