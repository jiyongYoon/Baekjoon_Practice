import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Integer count = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < count; i++) {
      int nextNum = Integer.parseInt(br.readLine());
      if (nextNum == 0) {
        stack.pop();
      } else {
        stack.add(nextNum);
      }
    }

    AtomicLong result = new AtomicLong();
    stack.forEach(result::addAndGet);

    System.out.println(result.longValue());
  }
}