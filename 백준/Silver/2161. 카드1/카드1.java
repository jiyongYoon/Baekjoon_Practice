import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < num; i++) {
            deque.add(i + 1);
        }

        List<Integer> answerList = new ArrayList<>();

        while (deque.size() != 1) {
            answerList.add(deque.pop());

            if (deque.size() > 1) {
                Integer pop = deque.pop();
                deque.add(pop);
            }
        }

        answerList.add(deque.pop());

        answerList.forEach(s -> System.out.print(s + " "));
    }
}