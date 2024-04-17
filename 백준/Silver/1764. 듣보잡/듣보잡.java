import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] split = str.split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        if (a == 0 || b == 0) {
            System.out.println(0);
            return;
        }

        Map<String, Boolean> aMap = new HashMap<>(a);
        Map<String, Boolean> bMap = new HashMap<>(b);

        for (int i = 0; i < a; i++) {
            aMap.put(br.readLine(), true);
        }

        for (int i = 0; i < b; i++) {
            bMap.put(br.readLine(), true);
        }

        List<String> answer = new ArrayList<>();

        for (String s : bMap.keySet()) {
            if (!aMap.isEmpty() && aMap.containsKey(s)) {
                answer.add(s);
                aMap.remove(s);
            }
        }
        answer.sort(Comparator.naturalOrder());
        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }
}