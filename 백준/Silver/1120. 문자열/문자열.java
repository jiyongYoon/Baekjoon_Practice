import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 슬라이딩 윈도우를 하면서 같은 것이 가장 많은 포인트를 체크한다
        String a = st.nextToken();
        String b = st.nextToken();

        int smallLength = 0;
        boolean smallA = false;

        if (a.length() > b.length()) {
            smallA = false;
            smallLength = b.length();
        } else {
            smallA = true;
            smallLength = a.length();
        }

        int left = 0;
        int right = left + smallLength;

        int result = Integer.MAX_VALUE;

        while (right <= (smallA ? b.length() : a.length())) {
            result = Math.min(countDiff((smallA ? a : b), (smallA ? b : a).substring(left, right)), result);
            left++;
            right++;

            if (result == 0) {
                System.out.println(result);
                return;
            }
        }

        System.out.println(result);
    }

    public static int countDiff(String a, String b) {
        int result = 0;

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        for (int i = 0; i < a.length(); i++) {
            if (aChars[i] != bChars[i]) {
                result++;
            }
        }

        return result;
    }
}