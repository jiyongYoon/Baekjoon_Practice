class Solution {
    public static int solution(String t, String p) {
        int answer = 0;

        long pNum = Long.parseLong(p);
        int pLength = p.length();

        int idx = 0;
        while(idx <= t.length() - pLength) {
            long tmp = Long.parseLong(t.substring(idx, idx + pLength));
            if(tmp <= pNum) {
                answer++;
            }
            idx++;
        }

        return answer;
    }
}