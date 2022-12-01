import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static final long[] nums = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
    static ArrayList<Long> list;

    public static void solution(long result, int depth) {
        if(depth == nums.length) {
            list.add(result);
            return;
        }

        solution(result * 10 + nums[depth], depth + 1);
        solution(result, depth + 1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        long result = 0;
        solution(result, 0);

        Collections.sort(list);

        int max = list.size();
        if(N < max) {
            System.out.println(list.get(N));
        } else {
            System.out.println(-1);
        }

    }
}