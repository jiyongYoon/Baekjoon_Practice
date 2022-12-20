import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            hm.put(phone_book[i], 1);
        }

        for (String num : phone_book) {
            for (int i = 1; i < num.length(); i++) {
                if(hm.containsKey(num.substring(0, i))) {
                    return false;
                }
            }
        }

        return answer;
    }
}