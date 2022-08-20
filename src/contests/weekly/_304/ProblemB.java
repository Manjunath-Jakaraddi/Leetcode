package contests.weekly._304;

public class ProblemB {
    int maximumGroups(int[] grades) {
        return (int) (Math.sqrt(2 * grades.length + 0.25) - 0.5);
    }
}

/**
 * l * (l + 1) / 2 = n
 * l ^ 2 + l = 2 * n
 * l ^ 2 + l + 0.25 - 0.25 = 2 * n
 * (l + 0.5) * (l + 0.5) - 0.25 = 2 * n
 * (l + 0.5) ^ 2 = 2 * n + 0.25
 * l = sqrt(2 * n + 0.25) - 0.5
 */