import java.util.*;

public class Connected2DComponents {
    private final int[][] grid;
    private final int iMax;
    private final int jMax;

    public Connected2DComponents(int[][] grid) {
        this.grid = grid;
        this.iMax = grid.length - 1;
        this.jMax = grid[0].length - 1;
    }

    private Connection findConnectionAround(Point point) {
        int currentSymbol = grid[point.i][point.j];

        boolean thereArePointsAtRight = point.i < iMax;
        boolean pointAtRightHasSameSymbol = thereArePointsAtRight && grid[point.i + 1][point.j] == currentSymbol;
        Connection connectionAtRight = Connection.empty();
        if (pointAtRightHasSameSymbol) {
            connectionAtRight = findConnectionAround(new Point(point.i + 1, point.j));
        }

        boolean thereArePointsBelow = point.j < jMax;
        boolean pointBelowHasSameSymbol = thereArePointsBelow && grid[point.i][point.j + 1] == currentSymbol;
        Connection connectionBelow = Connection.empty();
        if (pointBelowHasSameSymbol) {
            connectionBelow = findConnectionAround(new Point(point.i, point.j + 1));
        }

        Connection result = Connection.empty();
        result.add(point);
        result.addAll(connectionAtRight);
        result.addAll(connectionBelow);
        return result;
    }

    public int componentsNumber() {
        List<Connection> foundConnections = new LinkedList<>();

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; j++) {
                Point currentPoint = new Point(i, j);
                if ( ! inAnyConnection(currentPoint, foundConnections)) {
                    Connection newConnection = findConnectionAround(currentPoint);
                    foundConnections.add(newConnection);
                }
            }
        }
        return foundConnections.size();
    }

    private boolean inAnyConnection(Point currentPoint, List<Connection> allConnections) {
        for (Connection connection: allConnections) {
            if (connection.contains(currentPoint))
                return true;
        }

        return false;
    }
}
