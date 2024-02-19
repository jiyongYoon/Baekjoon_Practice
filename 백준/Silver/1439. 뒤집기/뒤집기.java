import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        int zero = 0;
        int one = 0;

        char[] chars = s.toCharArray();

        char start = chars[0];
        char before = start;

        if (start == '0') {
            zero++;
        } else {
            one++;
        }

        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c != before) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            before = c;
        }

        System.out.println(Math.min(zero, one));
    }
}