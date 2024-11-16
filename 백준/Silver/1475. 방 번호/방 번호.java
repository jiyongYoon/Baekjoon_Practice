import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[] chars = br.readLine().toCharArray();

    if (chars.length == 1) {
      System.out.println(1);
      return;
    }

    int[] countArr = new int[10];

    for (char aChar : chars) {
      countArr[aChar - 48]++;
    }

    int result = 0;

    for (int i = 0; i < countArr.length; i++) {
      if (i == 6 || i == 9) {
        continue;
      }

      result = Math.max(result, countArr[i]);
    }

    result = (int) Math.max(result, Math.ceil((countArr[6] + countArr[9]) / 2.0));

    System.out.println(result);
  }
}