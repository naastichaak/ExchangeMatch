public class ExchangeProgram {
    private String name;
    private int[] preferences;

    public ExchangeProgram(String name, int[] preferences) {
        this.name = name;
        this.preferences = preferences;
    }

    public String getName() {
        return name;
    }

    public int[] getPreferences() {
        return preferences;
    }
}
