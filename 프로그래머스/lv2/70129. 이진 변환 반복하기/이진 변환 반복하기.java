class Solution {
    public static StringBuilder sb;
    public static int[] answer;
    public static int[] solution(String s) {
        answer = new int[2];
        sb = new StringBuilder(s);

        while(sb.length() != 1) {
            answer[0]++;
            removeZero();
            changeBinary();
        }
        return answer;
    }

    public static void removeZero() {
        int cnt = 0;
        int sbLeng = sb.length();
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '0') {
                cnt++;
            }
        }
        answer[1] += cnt;
        sb.delete(0, sb.length());
        for (int i = 0; i < sbLeng - cnt; i++) {
            sb.append("1");
        }
    }

    public static void changeBinary() {
        String binary = Integer.toBinaryString(sb.length());
        sb.delete(0, sb.length());
        sb.append(binary);
    }
}