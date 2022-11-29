import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
회문 - 0
유사회문 - 1
그 외 - 2
 */

public class Main {

    static String[] arr;

    public static int check(String s) {

        int left = 0;
        int right = s.length() - 1;
        int cnt = 0;
        int check2Cnt = 0;
        char leftChar = 0;
        char rightChar = 0;

        while(left < right) {
            leftChar = s.charAt(left);
            rightChar = s.charAt(right);

            if(leftChar == rightChar) {
                left++;
                right--;
                continue;
            }

            // 회문이 아니면 넘어옴
            if(cnt == 0) {
                cnt++;
            }
            break;
        }

        if(cnt == 0) {
            return 0;
        }

        int left2 = left;
        int right2 = right;

        // 회문이 아니면 넘어옴
        if(s.charAt(left + 1) == s.charAt(right)) {
            left++;
            check2Cnt = check2(s, left, right, cnt);
        }

        if(check2Cnt == 1) {
            return 1;
        } else {
            left = left2;
            right = right2;
            if (s.charAt(right - 1) == s.charAt(left)) {
                right--;
                check2Cnt = check2(s, left, right, cnt);
            } else {
                check2Cnt = 3;
            }
        }

        if(check2Cnt == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    public static int check2(String s, int left, int right, int cnt) {
        while(left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if(leftChar == rightChar) {
                left++;
                right--;
                continue;
            }

            cnt++;
            break;
        }

        if(cnt == 1) {
            return 1;
        } else {
            return 2;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        arr = new String[T];

        for (int i = 0; i < T; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(check(arr[i]));
        }
    }
}