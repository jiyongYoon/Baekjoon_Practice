import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = Integer.parseInt(br.readLine());

    Map<Integer, List<String>> map = new TreeMap<>();
    for (int i = 0; i < count; i++) {
      String[] s = br.readLine().split(" ");
      Integer age = Integer.parseInt(s[0]);
      String name = s[1];

      if (map.containsKey(age)) {
        List<String> strings = map.get(age);
        strings.add(name);
      } else {
        map.put(age, new ArrayList<>(Arrays.asList(name)));
      }
    }

    for (Entry<Integer, List<String>> integerListEntry : map.entrySet()) {
      Integer age = integerListEntry.getKey();
      integerListEntry.getValue().forEach(value -> {
        System.out.print(age + " " + value);
        System.out.println();
      });
    }
  }

}