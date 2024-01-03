class Solution {
    public static long solution(int n) {
        if (n == 0) return 0;

        long a = 1;
        long b = 1;

        int index = 2;

        long answer = a;

        while (index < n) {
            answer = answer + a;
            a = b;
            b = answer;
            index++;

            if (answer > 1234567) {
                answer = answer % 1234567;
            }
        }

        return answer;
    }
}