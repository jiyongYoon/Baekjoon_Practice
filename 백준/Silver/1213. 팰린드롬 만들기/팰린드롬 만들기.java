import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[] chars = br.readLine().toCharArray();

    int[] charInt = new int[26];

    for (char aChar : chars) {
      charInt[(int) aChar - 65]++;
    }

    int impossibleFlag = 0;

    for (int i : charInt) {
      if (i % 2 != 0) {
        impossibleFlag++;
      }

      if (impossibleFlag == 2) {
        System.out.println("I'm Sorry Hansoo");
        return;
      }
    }

    StringBuilder sb = new StringBuilder();
    Character center = null;

    for (int i = 0; i < charInt.length; i++) {
      int a = charInt[i];
      char curChar = (char) (i + 65);
      if (a % 2 != 0) {
        charInt[i]--;
        center = curChar;
      }

      int count = Math.floorDiv(a, 2);
      for (int j = 0; j < count; j++) {
        sb.append(curChar);
      }
    }

    char[] suffixCharArr = sb.toString().toCharArray();

    if (center != null) sb.append(center);

    for (int i = suffixCharArr.length - 1; i >= 0; i--) {
      sb.append(suffixCharArr[i]);
    }

    System.out.println(sb.toString());
  }
}