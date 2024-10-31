import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());

    Map<String, Integer> bookCounter = new HashMap<>();

    for (int i = 0; i < count; i++) {
      String bookName = br.readLine();
      bookCounter.putIfAbsent(bookName, 0);
      bookCounter.computeIfPresent(bookName, (k, v) -> v + 1);
    }

    String result = "";
    int max = 0;
    for (Entry<String, Integer> stringIntegerEntry : bookCounter.entrySet()) {
      String key = stringIntegerEntry.getKey();
      Integer value = stringIntegerEntry.getValue();

      if (max == 0) {
        result = key;
        max = value;
        continue;
      }

      if (value == max) {
        result = sort(result, key);
        max = value;
      } else if (value > max) {
        result = key;
        max = value;
      }
    }

    System.out.println(result);
  }

  private static String sort(String result, String candidate) {
    List<String> stringList = Arrays.asList(result, candidate);
    stringList.sort(Comparator.naturalOrder());
    return stringList.stream().findFirst().get();
  }
}