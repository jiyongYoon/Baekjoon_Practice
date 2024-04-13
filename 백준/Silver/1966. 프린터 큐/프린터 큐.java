import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Doc {
        int index;
        int priority;

        public Doc(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        public int getIndex() {
            return index;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public String toString() {
            return "Doc{" +
                "index=" + index +
                ", priority=" + priority +
                '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < totalCase; i++) {
            st = new StringTokenizer(br.readLine());
            int documentCount = Integer.parseInt(st.nextToken());
            int targetIndex = Integer.parseInt(st.nextToken());

            Queue<Doc> docQueue = new LinkedList<>();
            int[] map = new int[10];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < documentCount; j++) {
                int priority = Integer.parseInt(st.nextToken());
                Doc doc = new Doc(j, priority);
                docQueue.add(doc);
                map[priority]++;
            }

            int answer = 0;
            loop:
            for (int j = 9; j >= 0; j--) {
                while (map[j] > 0) {
                    Doc poll = docQueue.poll();
                    if (poll.getPriority() == j) {
                        answer++;
                        map[j]--;
                        if (poll.getIndex() == targetIndex) {
                            System.out.println(answer);
                            break loop;
                        }
                    } else {
                        docQueue.add(poll);
                    }
                }
            }

        }

    }
}