import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        String upperCase = str.toUpperCase();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = upperCase.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = 0;
        Character answer = null;
        for (Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if (max < characterIntegerEntry.getValue()) {
                max = characterIntegerEntry.getValue();
                answer = characterIntegerEntry.getKey();
            } else if (max == characterIntegerEntry.getValue()) {
                answer = null;
            }
        }

        if (answer == null) {
            System.out.println("?");
        } else {
            System.out.println(answer);
        }
    }


}