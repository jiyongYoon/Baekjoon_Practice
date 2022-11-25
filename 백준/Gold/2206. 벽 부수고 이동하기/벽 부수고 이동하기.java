import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int[][] map;
    public static final int[][] dir = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    public static PriorityQueue<Here> pq;
    public static int[][] visited;
    public static int answer = Integer.MAX_VALUE;

    public static class Here implements Comparable<Here> {
        int x;
        int y;
        int block;
        int count;

        public Here(int x, int y, int block, int count) {
            this.x = x;
            this.y = y;
            this.block = block;
            this.count = count;

        }

        @Override
        public int compareTo(Here o) {
            return this.count >= o.count ? 1 : -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] s = st.nextToken().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        pq = new PriorityQueue<>();
        Here start = new Here(0, 0, 0, 1);
        visited[start.x][start.y] = 0;
        pq.add(start);
        while(!pq.isEmpty()) {

            Here now = pq.poll();
            if(now.x == N - 1 && now.y == M - 1) {
                System.out.println(now.count);
                return;
            }

            for (int[] d : dir) {
                int x = now.x + d[0];
                int y = now.y + d[1];
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if(visited[x][y] > now.block) {
                        if(map[x][y] == 0) {
                            pq.add(new Here(x, y, now.block, now.count + 1));
                            visited[x][y] = now.block;
                        } else {
                            if(now.block == 0) {
                                pq.add(new Here(x, y, now.block + 1, now.count + 1));
                                visited[x][y] = now.block + 1;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}