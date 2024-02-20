import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] array = st.nextToken().toCharArray();
        int[] numCount = new int[10];

        for (char c : array) {
            numCount[Integer.parseInt(String.valueOf(c))]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            int count = numCount[i];
            if (count != 0) {
                for (int j = 0; j < count; j++) {
                    sb.append(i);
                }
            }
        }

        System.out.println(sb);
    }
}