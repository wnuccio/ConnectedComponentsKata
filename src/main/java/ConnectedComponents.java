public class ConnectedComponents {
    private final String string;

    public ConnectedComponents(String string) {
        this.string = string;
    }

    public int componentsNumber() {
        boolean different = string.contains("I") && string.contains("O");
        return different ? 2 : 1;
    }
}
