import java.util.ArrayList;

class Solution {
    public static boolean[] visited;
    public static ArrayList<Integer> answerList;
    public static int start;

    public static int solution(int[] cards) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        visited = new boolean[cards.length];

        int idx = 0;
        int cnt = 1;
        int total = 0;
        start = 0;
        visited[0] = true;
        while(total < cards.length) {
            int curInt = cards[idx] - 1;
            if(!visited[curInt]) {
                visited[curInt] = true;
                idx = curInt;
                cnt++;
                continue;
            }
            if(cnt > first) {
                second = first;
                first = cnt;
            } else if(cnt <= first && cnt > second) {
                second = cnt;
            }
            total += cnt;
            cnt = 0;
            for (int i = start; i < visited.length; i++) {
                if(!visited[i]) {
                    idx = i;
                    start = i;
                    break;
                }
            }
        }
        return first * second;
    }
}