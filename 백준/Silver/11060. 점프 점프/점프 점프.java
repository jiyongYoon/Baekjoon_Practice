import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());

        int[] arr = new int[length];
        int[] dp = new int[length];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        if(length == 1) {
            System.out.println(0);
            return;
        }

        dp[0] = 0;
        for (int i = 0; i < length; i++) {
            int move = arr[i];
            boolean breakFlag = false;
            for (int j = i + 1; j <= i + move; j++) {
                if(j == length) {
                    breakFlag = true;
                    break;
                }

                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
            if(breakFlag) {
                break;
            }
        }

        if(dp[length - 1] == Integer.MAX_VALUE || dp[length - 1] < 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[length - 1]);
        }
    }
}