import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Connected2DComponents {
    private final int[][] grid;
    private final int iMax;
    private final int jMax;

    public Connected2DComponents(int[][] grid) {
        this.grid = grid;
        this.iMax = grid.length - 1;
        this.jMax = grid[0].length - 1;
    }

    private void findConnectionAround(Point point, Connection currentConnection, List<Connection> foundConnections) {
        for (Direction d: Direction.values()) {
            connectionExtension(point, d, currentConnection, foundConnections);
        }
    }

    private void connectionExtension(Point point, Direction d, Connection currentConnection, List<Connection> foundConnections) {
        Point adjacentPoint = null;

        switch (d) {
            case UP:
                adjacentPoint = point.i != 0 ? new Point(point.i-1, point.j, point.symbol) : null;
                break;
            case DOWN:
                adjacentPoint = point.i != iMax ? new Point(point.i+1, point.j, point.symbol) : null;
                break;
            case RIGHT:
                adjacentPoint = point.j != 0 ? new Point(point.i, point.j-1, point.symbol) : null;
                break;
            case LEFT:
                adjacentPoint = point.j != jMax ? new Point(point.i, point.j+1, point.symbol) : null;
                break;
        }

        if (adjacentPoint == null) return;

        if (currentConnection.contains(adjacentPoint)) return;

        Point finalAdjacentPoint = adjacentPoint;
        if (foundConnections.stream().anyMatch(conn -> conn.contains(finalAdjacentPoint))) return;

        if (point.symbol != grid[adjacentPoint.i][adjacentPoint.j]) return;

        currentConnection.add(adjacentPoint);
        findConnectionAround(adjacentPoint, currentConnection, foundConnections);
    }

    public int componentsNumber() {
        List<Connection> foundConnections = new LinkedList<>();

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; j++) {
                Point currentPoint = new Point(i, j, grid[i][j]);
                if (!inAnyConnection(currentPoint, foundConnections)) {
                    Connection newConnection = Connection.empty();
                    newConnection.add(currentPoint);
                    findConnectionAround(currentPoint, newConnection, foundConnections);
                    foundConnections.add(newConnection);
                }
            }
        }
        return foundConnections.size();
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
