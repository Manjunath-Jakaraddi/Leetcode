package contests.weekly._295;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int discount = 50;
        String input = sc.nextLine();
        System.out.println(input);
        System.out.println(discountPrices(input, discount));
    }

    public static String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (isPrice(word)) {
                sb.append(calculateDiscount(Double.parseDouble(word.substring(1)), discount))
                        .append(" ");
            } else {
                sb.append(word).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static String calculateDiscount(double amount, double discount) {
        double ans = amount - ((amount * discount) / 100.0D);
        return "$" + String.format("%.2f", ans);
    }

    private static boolean isPrice(String word) {
        return word.startsWith("$") && word.substring(1).matches("\\d+");
    }
}
