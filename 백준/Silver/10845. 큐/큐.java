import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = Integer.parseInt(br.readLine());

    Deque<Integer> queue = new LinkedList<>();

    for (int i = 0; i < count; i++) {
      String command = br.readLine();
      if (command.startsWith("push")) {
        queue.add(Integer.parseInt(command.split(" ")[1]));
        continue;
      }

      switch (command) {
        case "pop":
          if (queue.isEmpty()) {
            System.out.println("-1");
          } else {
            System.out.println(queue.pollFirst());
          }
          break;
        case "empty":
          if (queue.isEmpty()) {
            System.out.println("1");
          } else {
            System.out.println("0");
          }
          break;
        case "size":
          System.out.println(queue.size());
          break;
        case "front":
          if (queue.isEmpty()) {
            System.out.println("-1");
          } else {
            System.out.println(queue.peekFirst());
          }
          break;
        case "back":
          if (queue.isEmpty()) {
            System.out.println("-1");
          } else {
            System.out.println(queue.peekLast());
          }
          break;
      }

    }


  }
}