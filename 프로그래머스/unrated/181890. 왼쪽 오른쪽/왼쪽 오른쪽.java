import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};

        List<String> leftList = new ArrayList<>();
        List<String> rightList = new ArrayList<>();

        int idx = 0;
        boolean isLeft = false;
        boolean isRight = false;
        for (int i = 0; i < str_list.length; i++) {
            idx = i;
            if (str_list[i].equals("l")) {
                isLeft = true;
                break;
            } else if (str_list[i].equals("r")) {
                isRight = true;
                break;
            } else {
                leftList.add(str_list[i]);
            }
        }

        if (isLeft) {
            return leftList.toArray(new String[0]);
        } else if (isRight) {
            for (int i = idx + 1; i < str_list.length; i++) {
                rightList.add(str_list[i]);
            }
            return rightList.toArray(new String[0]);
        }
        return new String[0];    
    }
}