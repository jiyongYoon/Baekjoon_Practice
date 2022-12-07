import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. 아이디어
- 백트래킹, 순서가 상관있는 순열
- 먼저 팀 배정
    visited[] 배열로 가는데, return depth를 N / 2로
- 이후 계산
 */

public class Main {

    public static int N;
    public static int[] teamA;
    public static int[] teamB;
    public static boolean[] visited;
    public static int minResult;
    public static int[][] grid;

    public static void calculate() {
        int idx = 0;
        for (int i = 0; i < visited.length; i++) {
            if(visited[i]) {
                teamA[idx++] = i;
            }
        }
        idx = 0;
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                teamB[idx++] = i;
            }
        }

        int teamASum = 0;
        for (int i = 0; i < teamA.length; i++) {
            int cur = teamA[i];
            for (int j = 0; j < teamA.length; j++) {
                int next = teamA[j];
                if(cur == next) {
                    continue;
                }
                teamASum += grid[cur][next];
            }
        }

        int teamBSum = 0;
        for (int i = 0; i < teamB.length; i++) {
            int cur = teamB[i];
            for (int j = 0; j < teamB.length; j++) {
                int next = teamB[j];
                if(cur == next) {
                    continue;
                }
                teamBSum += grid[cur][next];
            }
        }

        minResult = Math.min(minResult, Math.abs(teamASum - teamBSum));
    }

    public static void solution(int depth, int start) {
        if(depth == N / 2) {
            calculate();
            return;
        }

        for (int i = start; i < N; i++) {
            if(!visited[start]) {
                visited[start] = true;
                solution(depth + 1, i);
                visited[start] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        teamA = new int[N / 2];
        teamB = new int[N / 2];
        visited = new boolean[N];

        minResult = Integer.MAX_VALUE;

        solution(0, 0);
        System.out.println(minResult);

    }
}