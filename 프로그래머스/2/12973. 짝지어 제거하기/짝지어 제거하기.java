import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        if (chars.length % 2 != 0) {
            return 0;
        }

        for (char c : chars) {
            if (!stack.isEmpty()) {
                Character peekChar = stack.peek();
                if (peekChar.equals(c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}