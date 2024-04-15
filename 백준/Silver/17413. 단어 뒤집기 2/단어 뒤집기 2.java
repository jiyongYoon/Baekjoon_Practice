import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] array = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '<') {
                while (i < array.length && array[i] != '>') {
                    sb.append(array[i]);
                    i++;
                }
                if (i < array.length) {
                    sb.append('>');
                }
            } else {
                Stack<Character> stack = new Stack<>();
                boolean space = true;
                while (i < array.length && array[i] != ' ') {
                    if (array[i] == '<') {
                        space = false;
                        i--;
                        break;
                    }
                    stack.add(array[i]);
                    i++;
                }
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                if (space) {
                    sb.append(' ');
                }
            }
        }
        System.out.println(sb);
    }
}