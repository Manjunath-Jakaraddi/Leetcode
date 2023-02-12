package contests.weekly._307;

public class ProblemA {
    public int minNumberOfHours(int iE, int iX, int[] energy, int[] experience) {
        int res = 0;
        int N = energy.length;
        for (int i=0; i<N; i++) {
            if (iX <= experience[i]) {
                res += (experience[i] - iX + 1);
                iX += (experience[i] - iX + 1);
            }
            iX += experience[i];
            if (iE <= energy[i]) {
                res += (energy[i] - iE + 1);
                iE = (energy[i] + 1);
            }
            iE -= energy[i];
        }
        return res;
    }
}
