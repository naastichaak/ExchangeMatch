import java.util.Arrays;

public class GaleShapley {

    public static int[] match(
            Student[] students,
            ExchangeProgram[] programs) {

        int n = students.length;

        if (n != programs.length) {
            throw new IllegalArgumentException(
                    "The groups must have equal sizes.");
        }

        int[] studentMatches = new int[n];
        int[] programMatches = new int[n];
        int[] nextProposal = new int[n];
        int[][] rankings = new int[n][n];

        Arrays.fill(studentMatches, -1);
        Arrays.fill(programMatches, -1);

        for (int p = 0; p < n; p++) {
            int[] preferences = programs[p].getPreferences();

            for (int rank = 0; rank < n; rank++) {
                rankings[p][preferences[rank]] = rank;
            }
        }

        int matchedCount = 0;

        while (matchedCount < n) {
            for (int s = 0; s < n; s++) {

                if (studentMatches[s] != -1) {
                    continue;
                }

                int program = students[s]
                        .getPreferences()[nextProposal[s]];

                nextProposal[s]++;

                int currentStudent = programMatches[program];

                if (currentStudent == -1) {
                    programMatches[program] = s;
                    studentMatches[s] = program;
                    matchedCount++;

                } else if (rankings[program][s]
                        < rankings[program][currentStudent]) {

                    studentMatches[currentStudent] = -1;
                    programMatches[program] = s;
                    studentMatches[s] = program;
                }
            }
        }

        return studentMatches;
    }
}