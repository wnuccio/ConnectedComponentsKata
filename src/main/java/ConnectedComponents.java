public class ConnectedComponents {
    private final String string;

    public ConnectedComponents(String string) {
        this.string = string;
    }

    public int componentsNumber() {
        char[] chars = string.toCharArray();
        char lastDifferentChar = chars[0];
        int count = 1;
        for (int i=1; i<chars.length; ++i) {
            char currentChar = chars[i];
            if (currentChar != lastDifferentChar) {
                lastDifferentChar = currentChar;
                count++;
            }
        }

        return count;
    }
}
