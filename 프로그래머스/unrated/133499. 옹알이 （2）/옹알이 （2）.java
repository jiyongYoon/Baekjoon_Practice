class Solution {
    public static int solution(String[] babbling) {
        int answer = 0;
        String[] can = {"aya", "ye", "woo", "ma"};

        for (int i = 0; i < babbling.length; i++) {
            int idx = 0;
            String cur = babbling[i];
            boolean falseFlag = false;
            String before = "";
            while(idx < cur.length()) {
                cur = cur.substring(idx);
                if(cur.startsWith("a") && cur.length() >= can[0].length()) {
                    String compare = cur.substring(0, can[0].length());
                    if(compare.equals(can[0]) && !compare.equals(before)) {
                        idx = can[0].length();
                        before = can[0];
                    } else {
                        falseFlag = true;
                        break;
                    }
                } else if(cur.startsWith("y") && cur.length() >= can[1].length()) {
                    String compare = cur.substring(0, can[1].length());
                    if(compare.equals(can[1]) && !compare.equals(before)) {
                        idx = can[1].length();
                        before = can[1];
                    } else {
                        falseFlag = true;
                        break;
                    }
                } else if(cur.startsWith("w") && cur.length() >= can[2].length()) {
                    String compare = cur.substring(0, can[2].length());
                    if(compare.equals(can[2]) && !compare.equals(before)) {
                        idx = can[2].length();
                        before = can[2];
                    } else {
                        falseFlag = true;
                        break;
                    }
                } else if(cur.startsWith("m") && cur.length() >= can[3].length()) {
                    String compare = cur.substring(0, can[3].length());
                    if(compare.equals(can[3]) && !compare.equals(before)) {
                        idx = can[3].length();
                        before = can[3];
                    } else {
                        falseFlag = true;
                        break;
                    }
                } else {
                    falseFlag = true;
                    break;
                }
            }
            if (!falseFlag) {
                answer++;
            }
        }

        return answer;
    }
}