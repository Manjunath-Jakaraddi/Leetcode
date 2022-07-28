package company.infosys;

import java.util.*;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> arr = new ArrayList<>();
        int N = sc.nextInt();
        int[] power = new int[N], bonus = new int[N];
        int experience = sc.nextInt(), res = 0;
        for (int i = 0; i < N; i++) {
            power[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            bonus[i] = sc.nextInt();
            arr.add(new int[] {power[i], bonus[i]});
        }
        arr.sort(Comparator.comparingInt(p -> p[1]));
        for (int i = 0; i < N; i++) {
            if (arr.get(i)[1] > experience) {
                break;
            }
            res++;
            experience += arr.get(i)[0];
        }
        System.out.println(res);
    }
}
