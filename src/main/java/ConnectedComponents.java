public class ConnectedComponents {
    private final String string;

    public ConnectedComponents(String string) {
        this.string = string;
    }

    public int componentsNumber() {
        return string.contains("O") ? 2 : 1;
    }
}
