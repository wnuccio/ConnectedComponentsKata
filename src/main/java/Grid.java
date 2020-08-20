import java.util.LinkedList;
import java.util.List;

public class Grid {
    private final int[][] grid;
    private final int iMax;
    private final int jMax;

    public Grid(int[][] grid) {
        this.grid = grid;
        this.iMax = grid.length - 1;
        this.jMax = grid.length > 0 ? grid[0].length - 1 : -1;
    }

    boolean areValidCoordinates(int i, int j) {
        return (i >= 0 && i <= iMax && j >= 0 && j <= jMax);
    }

    Point pointAt(int i, int j) {
        return new Point(i, j, grid[i][j]);
    }

    public int componentsNumber() {
        List<Connection> foundConnections = new LinkedList<>();

        for (int i = 0; i <= iMax; ++i) {
            for (int j = 0; j <= jMax; j++) {
                Point currentPoint = pointAt(i, j);
                if (!anyContains(foundConnections, currentPoint)) {
                    Connection newConnection = Connection.from(currentPoint);
                    extendConnectionInAllDirections(newConnection, currentPoint, foundConnections);
                    foundConnections.add(newConnection);
                }
            }
        }
        return foundConnections.size();
    }

    private void extendConnectionInAllDirections(Connection currentConnection, Point currentPoint, List<Connection> foundConnections) {
        for (Direction d : Direction.values()) {
            extendConnection(currentConnection, currentPoint, d, foundConnections);
        }
    }

    private void extendConnection(Connection currentConnection, Point currentPoint, Direction d, List<Connection> foundConnections) {
        Point adjacentPoint = currentPoint.adjacentPoint(d, this).orElse(null);

        if (adjacentPoint == null) return;
        if (currentConnection.contains(adjacentPoint)) return;
        if (anyContains(foundConnections, adjacentPoint)) return;
        if (currentPoint.hasDifferentSymbol(adjacentPoint)) return;

        currentConnection.add(adjacentPoint);
        extendConnectionInAllDirections(currentConnection, adjacentPoint, foundConnections);
    }

    private boolean anyContains(List<Connection> connections, Point point) {
        return connections
                .stream()
                .anyMatch(conn -> conn.contains(point));
    }

}
