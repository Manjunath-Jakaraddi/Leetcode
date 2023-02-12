package company.expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindingIntegers {
    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1,2,3,4},
                {2,1,3,4},
                {3,1,2,4},
                {1,3,2,4},
                {2,3,1,4},
                {3,2,1,4},
                {3,2,4,1},
                {2,3,4,1},
                {4,3,2,1},
                {3,4,2,1},
                {2,4,3,1},
                {4,2,3,1},
                {4,1,3,2},
                {1,4,3,2},
                {3,4,1,2},
                {4,3,1,2},
                {1,3,4,2},
                {3,1,4,2},
                {2,1,4,3},
                {1,2,4,3},
                {4,2,1,3},
                {2,4,1,3},
                {1,4,2,3},
                {4,1,2,3},
        };
        for (int t = 0; t < arr.length; t++) {
                int N = arr[t].length;
                int K = 2;
                List<Integer> res = new ArrayList<>();
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for (int i = 0; i < N; i++) {
                    if (i < K) {
                        pq.add(arr[t][i]);
                    } else {
                        if (arr[t][i] > pq.peek()) {
                            pq.poll();
                            pq.add(arr[t][i]);
                        }
                    }
                    if (i >= K-1) {
                        res.add(pq.peek());
                    }
                }
                Arrays.stream(arr[t]).forEach(x -> System.out.print(x + " "));
                System.out.println();
                res.stream().forEach(x -> System.out.print(x + " "));
                System.out.println();
            }
        }
}
