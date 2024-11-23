import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    String longestWord = "";

    while ((line = br.readLine()) != null) {
      String[] words = line.split("[^a-zA-Z-]+"); // 단어 분리
      for (String word : words) {
        if (word.equals("E-N-D")) { // 입력 종료 조건
          System.out.println(longestWord.toLowerCase());
          return;
        }
        if (word.length() > longestWord.length()) {
          longestWord = word;
        }
      }
    }
  }
}