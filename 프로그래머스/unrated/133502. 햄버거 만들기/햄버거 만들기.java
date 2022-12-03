import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static int solution(int[] ingredient) {
        if(ingredient.length < 3) {
            return 0;
        }

        final int[] burger = {1, 2, 3, 1};
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        int idx = 0;

        while(idx < ingredient.length) {
            stack.add(ingredient[idx++]);

            if(stack.size() >= 4) {
                int first = stack.elementAt(stack.size() - 4);
                int second = stack.elementAt(stack.size() - 3);
                int third = stack.elementAt(stack.size() - 2);
                int fourth = stack.elementAt(stack.size() - 1);

                int[] check = {first, second, third, fourth};

                if (Arrays.equals(check, burger)) {
                    answer++;
                    for (int i = 0; i < 4; i++) {
                        stack.pop();
                    }
                }
            }
        }
        return answer;
    }
}