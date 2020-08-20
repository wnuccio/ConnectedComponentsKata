import java.util.HashSet;
import java.util.Set;

public class Connection {
    private Set<Point> points = new HashSet<>();

    public static Connection from(Point point) {
        Connection result = new Connection();
        result.add(point);
        return result;
    }

    public void add(Point point) {
        points.add(point);
    }

    public boolean contains(Point point) {
        return points.contains(point);
    }
}
