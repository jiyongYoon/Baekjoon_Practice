import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. 아이디어
- 백트래킹, 순서가 상관있는 순열
- 숫자에 방문배열 하나, 기호는 0일때 넘어가는걸로
- 계산은 따로 메서드를 뺀 후 계산
 */

public class Main {

    public static int N;
    public static int[] nums;
    public static boolean[] visited;
    public static int[] operator;
    public static int maxResult;
    public static int minResult;
    public static String[] operatorStrArr;

    public static void calculate() {
        int sum = nums[0];
        for (int i = 1; i < N; i++) {
            String operator = operatorStrArr[i - 1];
            int nextInt = nums[i];
            if(operator.equals("+")) {
                sum += nextInt;
            } else if(operator.equals("-")) {
                sum -= nextInt;
            } else if(operator.equals("*")) {
                sum *= nextInt;
            } else if(operator.equals("/")){
                if(sum < 0) {
                    int tmp = (sum * -1) / nextInt;
                    sum = tmp * -1;
                } else {
                    sum /= nextInt;
                }
            }
        }
        maxResult = Math.max(maxResult, sum);
        minResult = Math.min(minResult, sum);
    }

    public static void solution(int start) {
        if(start == N - 1) {
            calculate();
            return;
        }

        for (int j = 0; j < 4; j++) {
            if(operator[j] > 0) {
                operator[j]--;
                String operatorStr = "";
                if(j == 0) {
                    operatorStr = "+";
                } else if(j == 1) {
                    operatorStr = "-";
                } else if(j == 2) {
                    operatorStr = "*";
                } else {
                    operatorStr = "/";
                }

                operatorStrArr[start] = operatorStr;
                solution(start + 1);
                operator[j]++;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        visited = new boolean[N];
        operator = new int[4];

        operatorStrArr = new String[N - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        maxResult = Integer.MIN_VALUE;
        minResult = Integer.MAX_VALUE;
        solution(0);
        System.out.println(maxResult);
        System.out.println(minResult);
    }
}