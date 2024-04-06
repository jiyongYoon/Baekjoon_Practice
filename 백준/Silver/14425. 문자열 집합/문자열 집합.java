import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        int totalCount = Integer.parseInt(st.nextToken());

        int answer = 0;

        Map<String, Integer> sMap = new HashMap<>();

        for (int i = 0; i < count; i++) {
            String word = br.readLine();
            sMap.put(word, 1);
        }

        for (int i = 0; i < totalCount; i++) {
            String word = br.readLine();
            if (sMap.containsKey(word)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}