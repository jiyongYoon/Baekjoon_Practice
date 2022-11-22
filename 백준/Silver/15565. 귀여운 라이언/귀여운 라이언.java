import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int total;
    static int lion;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        total = Integer.parseInt(st.nextToken());
        lion = Integer.parseInt(st.nextToken());
        arr = new int[total];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lionCnt = 0;
        int left = 0;
        int answer = Integer.MAX_VALUE;

        while(left < total - 1 && arr[left] != 1) {
            left++;
        }
        lionCnt++;
        int right = left;

        while (right < total - 1) {
            right++;

            if(arr[right] == 1) {
                lionCnt++;
            }

            if(lionCnt == lion) {
                answer = Math.min(answer, right - left + 1);
                left++;
                lionCnt--;
                while (arr[left] != 1) {
                    left++;
                }
            }
        }

        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}