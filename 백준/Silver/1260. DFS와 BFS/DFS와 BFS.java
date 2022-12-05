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
    public static boolean[] visited;
    public static int N;
    public static int M;
    public static int V;
    public static ArrayList<Integer> dfsList;
    public static ArrayList<Integer> bfsList;

    public static void dfs() {
        dfsList = new ArrayList<>();
        visited = new boolean[N + 1];
        visited[V] = true;
        dfsList.add(V);
        for (int i = 0; i < N + 1; i++) {
            if(map[V][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfsList.add(i);
                recur(i);
            }
        }
        for (Integer integer : dfsList) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void recur(int i) {
        for (int j = 0; j < N + 1; j++) {
            if(map[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfsList.add(j);
                recur(j);
            }
        }
    }

    public static void bfs() {
        bfsList = new ArrayList<>();
        visited = new boolean[N + 1];
        visited[V] = true;
        Queue<Integer> queue = new LinkedList<>();
        bfsList.add(V);
        queue.add(V);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < N + 1; i++) {
                if(map[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    bfsList.add(i);
                    queue.add(i);
                }
            }
        }
        for (Integer integer : bfsList) {
            System.out.print(integer + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = 1;
            map[to][from] = 1;
        }

        dfs();
        bfs();

    }
}