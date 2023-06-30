import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> keyCountMap = new HashMap<>();

        for (String k : keymap) {
            for (int i = 0; i < k.length(); i++) {
                Character c = k.charAt(i);
                if (keyCountMap.containsKey(c)) {
                    int cnt = keyCountMap.get(c) > i + 1 ? i + 1 : keyCountMap.get(c);
                    keyCountMap.put(c, cnt);
                } else {
                    keyCountMap.put(c, i + 1);
                }
            }
        }

        int idx = 0;
        for (String target : targets) {
            int cnt = 0;
            boolean flag = false;
            for (int i = 0; i < target.length(); i++) {
                Character c = target.charAt(i);
                if (!keyCountMap.containsKey(c)) {
                    flag = true;
                    break;
                }
                cnt += keyCountMap.get(c);
            }
            answer[idx++] = flag ? -1 : cnt;
        }

        return answer;
    }
}