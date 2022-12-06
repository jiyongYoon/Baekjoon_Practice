import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1. 아이디어
- 그래프 연결 : int[][]
- DFS : 재귀함수.
- BFS : 큐.
 */

public class Main {

    public static int[][] map;
    public static boolean[][] visited;
    public static int N;
    public static int M;
    public static Queue<Node> queue;
    public static final int[][] dir = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    public static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void bfs() {
        queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            if(cur.x == M - 1 && cur.y == N - 1) {
                System.out.println(cur.cnt);
                break;
            }

            for (int[] d : dir) {
                int x = cur.x + d[0];
                int y = cur.y + d[1];
                if(x >= 0 && y >= 0 && x < M && y < N && map[x][y] == 1 && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Node(x, y, cur.cnt + 1 ));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs();
    }
}