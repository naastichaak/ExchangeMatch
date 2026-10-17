
public class Student {
    private String name;
    private int[] preferences;

    public Student(String name, int[] preferences) {
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
