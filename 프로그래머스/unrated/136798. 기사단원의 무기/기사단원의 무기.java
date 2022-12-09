class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;

        for (int i = 2; i <= number; i++) {
            int max = i / 2;

            int cnt = 1;
            for (int j = 1; j <= max; j++) {
                if(i % j == 0) {
                    cnt++;
                }
            }

            int kg = 0;
            if(cnt > limit) {
                kg = power;
            } else {
                kg = cnt;
            }
            answer += kg;
        }

        return answer;
    }
}