import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
class Solution {
    public static HashMap<Integer, Integer> hm;
    public static PriorityQueue<Tangerine> pq;
    public static class Tangerine implements Comparable<Tangerine> {
        int id;
        int cnt;

        public Tangerine(int id, int cnt) {
            this.id = id;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Tangerine o) {
            return this.cnt >= o.cnt ? -1 : 1;
        }
    }

    public static int solution(int k, int[] tangerine) {
        pq = new PriorityQueue<>();
        hm = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            hm.put(tangerine[i], hm.getOrDefault(tangerine[i], 0) + 1);
        }

        for (Entry<Integer, Integer> entry : hm.entrySet()) {
            Tangerine cur = new Tangerine(entry.getKey(), entry.getValue());
            pq.add(cur);
        }

        int kind = 0;
        int cnt = 0;
        while(!pq.isEmpty()) {
            Tangerine cur = pq.poll();
            cnt += cur.cnt;
            kind++;
            if(cnt >= k) {
                break;
            }
        }
        return kind;
    }
}