import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<String, Set<String>> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();

        char[] chars = text.toCharArray();

        for (char aChar : chars) {
            String key = String.valueOf(aChar);
            map.put(key, new HashSet<>());
            map.get(key).add(key);
        }

        for (int i = 1; i <= text.length(); i++) {
            int start = 0;
            int end = i;

            while (end <= text.length()) {
                String curText = text.substring(start, end);
                String startText = curText.substring(0, 1);

                map.get(startText).add(curText);

                start++;
                end++;
            }
        }

        int answer = 0;
        for (Set<String> value : map.values()) {
            answer += value.size();
        }

        System.out.println(answer);
    }
}