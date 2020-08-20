import java.util.LinkedList;
import java.util.List;

public class Connected2DComponents {
    private final int[][] grid;
    private final int iMax;
    private final int jMax;

    public Connected2DComponents(int[][] grid) {
        this.grid = grid;
        this.iMax = grid.length - 1;
        this.jMax = grid.length > 0 ? grid[0].length - 1 : -1;
    }

    private void extendConnectionInAllDirections(Connection currentConnection, Point currentPoint, List<Connection> foundConnections) {
        for (Direction d: Direction.values()) {
            extendConnection(currentConnection, currentPoint, d, foundConnections);
        }
    }

    private void extendConnection(Connection currentConnection, Point currentPoint, Direction d, List<Connection> foundConnections) {
        Point adjacentPoint = d.adjacentPoint(currentPoint, this).orElse(null);

        if (adjacentPoint == null) return;
        if (currentConnection.contains(adjacentPoint)) return;
        if (anyContains(foundConnections, adjacentPoint)) return;
        if (currentPoint.symbol != adjacentPoint.symbol) return;

        currentConnection.add(adjacentPoint);
        extendConnectionInAllDirections(currentConnection, adjacentPoint, foundConnections);
    }

    boolean areValid(int i, int j) {
        return (i >= 0 && i<=iMax && j>=0 && j<=jMax);
    }

    public int componentsNumber() {
        List<Connection> foundConnections = new LinkedList<>();

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; j++) {
                int symbol = symbolAt(i, j);
                Point currentPoint = new Point(i, j, symbol);
                if (!anyContains(foundConnections, currentPoint)) {
                    Connection newConnection = Connection.empty();
                    newConnection.add(currentPoint);
                    extendConnectionInAllDirections(newConnection, currentPoint, foundConnections);
                    foundConnections.add(newConnection);
                }
            }
        }
        return foundConnections.size();
    }

    int symbolAt(int i, int j) {
        return grid[i][j];
    }

    private boolean anyContains(List<Connection> connections, Point point) {
        return connections
                .stream()
                .anyMatch(conn -> conn.contains(point));
    }

}
