import java.util.HashSet;

class Solution {
    public static HashSet<Integer> hashSet;

    public static int solution(int[] elements) {
        hashSet = new HashSet<>();

        int total = 0;
        for (int i = 0; i < elements.length; i++) {
            total += elements[i];
        }

        for (int i = 0; i < elements.length; i++) {
            int cnt = 1 + i;
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = 0; k < cnt; k++) {
                    sum += elements[(j + k) % elements.length];
                }
                hashSet.add(sum);
            }
        }

        return hashSet.size();
    }
}