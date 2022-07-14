package contests.weekly._297;

public class ProblemA {
    public static void main(String[] args) {
        int[][] slabs = {{3, 50},{7,10},{12,25}};
        System.out.println(calculateTax(slabs, 10));
    }

    public static double calculateTax(int[][] brackets, int income) {
        int N = brackets.length;
        int ind = 0;
        double tax = 0d;
        while (ind < N) {
            if (income >= brackets[ind][0]) {
                tax += ((double) (brackets[ind][0] - (ind > 0 ? brackets[ind-1][0] : 0)) * (brackets[ind][1] / 100.0d));
            } else {
                tax += ((double) (income - brackets[ind-1][0]) * (brackets[ind][1] / 100.0d));
            }
            ind++;
        }
        return tax;
    }
}
