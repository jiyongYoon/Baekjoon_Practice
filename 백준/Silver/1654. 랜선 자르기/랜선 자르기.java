import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

  public static int originalNeedCount = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    Integer hadCount = Integer.parseInt(s[0]);
    Integer needCount = Integer.parseInt(s[1]);
    originalNeedCount = needCount;

    Long totalLength = 0L;
    List<Long> lanList = new ArrayList<>();
    // 1. 일단 선을 다 더한다
    for (int i = 0; i < hadCount; i++) {
      Long len = Long.parseLong(br.readLine());
      totalLength += len;
      lanList.add(len);
    }

//    System.out.println("totalLength = " + totalLength);

    // 2. 필요한 갯수로 나눈다 -> 최대 선 길이가 나온다 -> 이걸로 나눠본다
    Long maxLength = totalLength / needCount;
    Long minLength = maxLength;

//    System.out.println("maxLength = " + maxLength);

    Boolean possible = null;
    do {
//      System.out.println("maxLength = " + maxLength);
//      System.out.println("minLength = " + minLength);

      possible = cut(minLength, originalNeedCount, lanList);
      // 3. 안되면 필요한 갯수를 하나 높인다
      if (!possible) {
        needCount++;
        maxLength = minLength;
        minLength = totalLength / needCount;
      }
    } while (!possible);
    // 2 ~ 3 번 작업을 하다보면 안되는 것과 되는것 사이가 나오는데, 여기서 이분 탐색을 한다.

//    System.out.println("--------------------------------");
//    System.out.println("minLength = " + minLength);
//    System.out.println("maxLength = " + maxLength);
//    System.out.println("--------------------------------");

    while (true) {
      Long middle = (maxLength + minLength) / 2;
      Long originalMiddle = middle;
//      System.out.println("--------------------------------");
//      System.out.println("middle = " + middle);

      boolean possible2 = cut(middle, originalNeedCount, lanList);
//      System.out.println("possible = " + possible2);

      if (possible2) {
        minLength = middle;
      } else {
        maxLength = middle;
      }

      if ((long) minLength == (long) maxLength || (long) minLength + 1L == (long) maxLength) {
        break;
      }
    }

//    System.out.println("minLength = " + minLength);
//    System.out.println("maxLength = " + maxLength);

    System.out.println(minLength);
  }

  private static boolean cut(long minLength, int needCount, List<Long> lanList) {
    AtomicLong result = new AtomicLong();
    lanList.forEach(lan -> {
      long cutCount =  Math.floorDiv(lan, minLength);
//      System.out.println("lanLength = " + lan + " / cutCount = " + cutCount);
      result.addAndGet(cutCount);
    });

//    System.out.println("result = " + result.intValue());
//    System.out.println("needCount = " + originalNeedCount);

    return result.intValue() >= originalNeedCount;

  }

}