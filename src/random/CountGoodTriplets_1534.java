package random;

public class CountGoodTriplets_1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int N = arr.length;
        int res = 0;
        for (int i = 0; i < N-2; i++) {
            for (int j = i+1; j < N-1; j++) {
                for (int k = j+1; k < N; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a
                            && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
