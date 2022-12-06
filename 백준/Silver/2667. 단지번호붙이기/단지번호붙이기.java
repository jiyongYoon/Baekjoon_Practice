import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static int[][] map;
    public static boolean[][] visited;
    public static int N;
    public static ArrayList<Integer> answer;
    public static int result;
    public static final int[][] dir = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    public static int cnt;

    public static void dfs(int i, int j) {
        cnt++;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if(x >= 0 && y >= 0 && x < N & y < N && !visited[x][y] && map[x][y] == 1) {
                visited[x][y] = true;
                dfs(x, y);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    cnt = 0;
                    visited[i][j] = true;
                    dfs(i, j);
                    result++;
                    answer.add(cnt);
                }
            }
        }
        System.out.println(result);
        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }
}