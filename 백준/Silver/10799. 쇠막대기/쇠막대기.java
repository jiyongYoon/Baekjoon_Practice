import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static boolean isLaser(int i, char[] chars) {
        char cur = chars[i];
        if (i < chars.length - 1) {
            char next = chars[i + 1];
            return cur == '(' && next == ')';
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] chars = st.nextToken().toCharArray();

        int answer = 0;
        int flag = 0;
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (isLaser(i, chars)) {
                i++;
                if (flag == 0) {
                    continue;
                } else {
                    answer += flag;
                }
            } else {
                if (cur == '(') {
                    flag++;
                } else {
                    flag--;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}