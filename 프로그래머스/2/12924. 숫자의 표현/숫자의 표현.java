class Solution {
    public static int solution(int n) {
        int answer = 1;

        int start = n % 2 == 0 ? n / 2 : (n + 1) / 2;

        int sum = start;
        int left = start - 1;
        int right = start;

        for (int i = start; i >= 1; i--) {
            while (left >= 1) {
                sum += left;
                if (sum > n) {
                    sum -= right;
                    right--;
                } else if (sum < n) {
                    left--;
                    sum += left;
                }

                if (sum == n) {
                    answer++;
                }
                left--;
            }
            
            if (left == 0) {
                    break;
                }
        }

        return answer;
    }
}