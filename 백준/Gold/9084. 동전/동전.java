import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int coinKinds;
    static int[] coinValue;
    static int target;
    static ArrayList<Integer> answerList;
    static int[] dp;

    public static void solution() {
        dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i < coinValue.length; i++) {
            int curCoin = coinValue[i];
            for (int j = curCoin; j <= target; j++) {
                dp[j] += dp[j - curCoin];
            }
        }

        answerList.add(dp[target]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answerList = new ArrayList<>();
        int times = Integer.parseInt(st.nextToken());

        for (int i = 0; i < times; i++) {
            st = new StringTokenizer(br.readLine());
            coinKinds = Integer.parseInt(st.nextToken());
            coinValue = new int[coinKinds];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < coinKinds; j++) {
                coinValue[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            target = Integer.parseInt(st.nextToken());

            solution();
        }

        for (int i = 0; i < answerList.size(); i++) {
            System.out.println(answerList.get(i));
        }
    }
}