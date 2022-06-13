package contests.weekly._294;

public class ProblemA {
    public int percentageLetter(String s, char letter) {
        int N = s.length(), cnt = 0;
        for(int i=0; i<N; i++) {
            if(s.charAt(i) == letter) {
                cnt++;
            }
        }
        return (cnt*100)/N;
    }
}
