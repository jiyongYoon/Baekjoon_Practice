import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());
    Map<String, Integer> map = new TreeMap<>();
    for (int i = 0; i < count; i++) {
      String s = br.readLine();
      String extension = s.split("\\.")[1];
      map.putIfAbsent(extension, 0);
      map.computeIfPresent(extension, (k, v) -> v = v + 1);
    }

    for (Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
      System.out.println(stringIntegerEntry.getKey() + " " + stringIntegerEntry.getValue());
    }
  }
}