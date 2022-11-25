import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int size;
    static int[][] grid;
    static int[][] out;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        grid = new int[size][size];
        out = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(out[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void solution() {
        for (int i = 0; i < size; i++) {
            visited = new boolean[size];
            for (int j = 0; j < size; j++) {
                if(grid[i][j] == 1) {
                    visited[j] = true;
                    int rowIdx = j;
                    out[i][j] = 1;
                    recur(rowIdx, i);
                }
            }
        }
    }

    public static void recur(int rowIdx, int rootIdx) {
        for (int i = 0; i < size; i++) {
            if(grid[rowIdx][i] == 1 && !visited[i]) {
                out[rootIdx][i] = 1;
                visited[i] = true;
                recur(i, rootIdx);
            }
        }
    }
}