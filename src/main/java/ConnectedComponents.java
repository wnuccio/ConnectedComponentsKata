public class ConnectedComponents {
    private final String string;
    private final String string2;

    public ConnectedComponents(String string) {
        this.string = string;
        this.string2 = null;
    }

    public ConnectedComponents(String s1, String s2) {
        this.string = s1;
        this.string2 = s2;
    }

    public int componentsNumber() {
        if (string2 != null) return 1;

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
