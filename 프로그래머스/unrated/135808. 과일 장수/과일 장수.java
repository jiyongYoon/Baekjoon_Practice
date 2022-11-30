class Solution {
    static int minVal;
    static int appleCnt;
    static int[] appleVal;
    static int idx;

    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        int totalCnt = score.length;
        int times = totalCnt / m;
        appleVal = new int[k + 1];
        for (int i = 0; i < totalCnt; i++) {
            appleVal[score[i]]++;
        }
        idx = appleVal.length - 1;
        for (int i = 0; i < times; i++) {
            appleCnt = 0;
            put(m);
            answer += minVal * m;
        }

        return answer;
    }

    public static void put(int m) {
        if(appleCnt == m) {
            minVal = idx;
            return;
        }

        if(appleVal[idx] + appleCnt == m) {
            appleCnt = m;
            appleVal[idx] = 0;
            put(m);
        } else if (appleVal[idx] + appleCnt > m) {
            appleVal[idx] -= m - appleCnt;
            appleCnt = m;
            put(m);
        } else {
            appleCnt += appleVal[idx];
            appleVal[idx] = 0;
            idx--;
            put(m);
        }
    }
}