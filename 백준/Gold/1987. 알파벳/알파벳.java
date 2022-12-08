import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int R;
    public static int C;
    public static char[][] map;
    public static boolean[] visited;
    public static final int[][] dir = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    public static int answer;

    public static void solution(int a, int b, boolean flag, int cnt) {
        if(flag) {
            answer = Math.max(answer, cnt);
            return;
        }

        boolean finishFlag = true;
        for (int[] d : dir) {
            int x = a + d[0];
            int y = b + d[1];
            if(x >= 0 && y >= 0 && x < R && y < C && !visited[(int)map[x][y] - 65]) {
                finishFlag = false;
                visited[(int)map[x][y] - 65] = true;
                solution(x, y, finishFlag, cnt + 1);
                visited[(int)map[x][y] - 65] = false;
            }
        }

        if(finishFlag) {
            solution(a, b, finishFlag, cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[26];
        answer = Integer.MIN_VALUE;

        for (int i = 0; i < R; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp[j];
            }
        }

        visited[(int)map[0][0] - 65] = true;
        solution(0, 0, false, 1);
        System.out.println(answer);
    }
}