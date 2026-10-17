
public class Main {

    public static void main(String[] args) {

        Student[] students = {
                new Student("Anna", new int[]{0, 1, 2}),
                new Student("Kate", new int[]{0, 2, 1}),
                new Student("Maria", new int[]{1, 2, 0})
        };

        ExchangeProgram[] programs = {
                new ExchangeProgram(
                        "University of Milan",
                        new int[]{1, 0, 2}),

                new ExchangeProgram(
                        "University of Paris",
                        new int[]{0, 2, 1}),

                new ExchangeProgram(
                        "University of Zurich",
                        new int[]{2, 1, 0})
        };

        int[] matches = GaleShapley.match(students, programs);

        System.out.println("EXCHANGEMATCH RESULTS");
        System.out.println("     ");

        for (int i = 0; i < students.length; i++) {
            System.out.println(
                    students[i].getName()
                            + " -> "
                            + programs[matches[i]].getName()
            );
        }
    }
}
