import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static class Square {
        private int a;
        private int b;

        public void draw() {
            for (int i = a; i < a + 10; i++) {
                for (int j = b; j < b + 10; j++) {
                    field[i][j] = 1;
                }
            }
        }

        public Square(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static int[][] field = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());

        List<Square> squareList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);

            squareList.add(new Square(a, b));
        }

        for (Square square : squareList) {
            square.draw();
        }

        int answer = 0;

        for (int[] booleans : field) {
            for (int aBoolean : booleans) {
                if (aBoolean == 1) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}