import java.util.HashMap;
import java.util.Map;

class Solution {
    public static Map<String, Integer> pointMap;
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        pointMap = new HashMap<>();

        int[] answer = new int[photo.length];

        int i = 0;
        for (String s : name) {
            pointMap.put(s, yearning[i++]);
        }

        int idx = 0;
        for (String[] strings : photo) {
            int point = 0;
            for (String item : strings) {
                point += pointMap.getOrDefault(item, 0);
            }
            answer[idx++] = point;
        }

        return answer;
    }
}