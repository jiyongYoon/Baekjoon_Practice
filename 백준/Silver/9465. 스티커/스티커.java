import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] sticker;
    static int[][] dp;
    static int times;
    static int width;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        times = Integer.parseInt(st.nextToken());

        for (int i = 0; i < times; i++) {

            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());

            dp = new int[2][width];
            sticker = new int[2][width];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < width; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            
            if(width == 1) {
                System.out.println(Math.max(sticker[0][0], sticker[1][0]));
                continue;
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            dp[0][1] = dp[1][0] + sticker[0][1];
            dp[1][1] = dp[0][0] + sticker[1][1];

            if(width == 2) {
                System.out.println(Math.max(dp[0][1], dp[1][1]));
                continue;
            }

            for (int j = 2; j < width; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + sticker[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + sticker[1][j];
            }
            System.out.println(Math.max(dp[0][width - 1], dp[1][width - 1]));
        }

    }
}