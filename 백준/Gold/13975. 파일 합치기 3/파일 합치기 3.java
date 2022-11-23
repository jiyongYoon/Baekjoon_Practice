import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static long times;
    static long answer;
    static long pqSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        times = Integer.parseInt(st.nextToken());
        for (int i = 0; i < times; i++) {
            answer = 0;

            st = new StringTokenizer(br.readLine());
            pqSize = Integer.parseInt(st.nextToken());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < pqSize; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long cur = 0;
            long next = 0;

            for (int j = 0; j < pqSize - 1; j++) {
                cur = pq.poll();
                if(!pq.isEmpty()) {
                    next = pq.poll();
                }
                long reAdd = cur + next;
                answer += reAdd;
                pq.add(reAdd);
            }
            System.out.println(answer);
        }
    }
}