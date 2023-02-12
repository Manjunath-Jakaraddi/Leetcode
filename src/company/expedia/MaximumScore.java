package company.expedia;

public class MaximumScore {
    public static void main(String[] args) {
        int[] arr1 = new int[] {4, 6, -10, -1, 10, -20};
        int[] arr = new int[] {-5, 4, -10, -1, -5, 8, -3};

        int K = 3;
        int N = arr.length;
        int count = 0, sum = 0, temp;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (arr[j+1] > arr[j]) {
                    arr[j+1]=arr[j+1]+arr[j];
                    arr[j]= arr[j+1]-arr[j];
                    arr[j+1]= arr[j+1]-arr[j];
                }
            }
        }
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
        for(int i=0;i<N;i++)
        {
            if(count==K)
                break;
            else
            {
                sum=sum+arr[i];
                count++;
            }
        }
        System.out.println(sum);
    }
}
