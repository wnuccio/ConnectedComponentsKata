import java.util.HashSet;
import java.util.Set;

public class Connection {
    private Set<Point> points;

    public Connection(Set<Point> points) {
        this.points = points;
    }

    public static Connection empty() {
        return new Connection(new HashSet<>());
    }

    public void addAll(Connection connection) {
        points.addAll(connection.points);
    }

    public void add(Point point) {
        points.add(point);
    }

    public boolean contains(Point point) {
        return points.contains(point);
    }
}
