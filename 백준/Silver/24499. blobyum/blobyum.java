import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]);
    int k = Integer.parseInt(s[1]);

    String[] s1 = br.readLine().split(" ");

    int result = firstSum(0, k, s1);
    int beforeSum = result;
    for (int i = 0; i < n - 1; i++) {
      int minus = Integer.parseInt(s1[i]);
      int nextIndex = (i + k) % n;
      int plus = Integer.parseInt(s1[nextIndex]);
      int afterSum = beforeSum - minus + plus;

      result = Math.max(result, afterSum);

      beforeSum = afterSum;

//      System.out.println(String.format("beforeSum = %d, minus = %d, plus = %d, afterSum = %d, result = %d",
//          beforeSum, minus, plus, afterSum, result));
    }

    System.out.println(result);
  }

  public static int firstSum(int left, int right, String[] strings) {
    int start = left;
    int result = 0;
    while (start < right) {
      result += Integer.parseInt(strings[start]);
      start++;
    }
//    System.out.println(String.format("first = %d", result));
    return result;
  }
}