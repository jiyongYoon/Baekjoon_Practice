import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());

        Map<Integer, Set<String>> map = new HashMap<>();

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            int length = word.length();

            Set<String> orDefault = map.getOrDefault(length, new HashSet<>());
            orDefault.add(word);
            map.put(length, orDefault);
        }

        for (int i = 0; i < 51; i++) {
            if (map.containsKey(i)) {
                List<String> collect = new ArrayList<>(map.get(i));
                collect.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
            }
        }
    }
}