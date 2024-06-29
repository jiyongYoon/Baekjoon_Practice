import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String line = br.readLine();
        List<String> answerList = new ArrayList<>();
        while (line != null) {
            char[] chars =line.toCharArray();

            Stack<Character> stack = new Stack<>();

            boolean alreadyCheck = false;

            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                boolean returnFlag = false;
                switch (aChar) {
                    case '[':
                    case '(':
                        stack.push(aChar);
                        break;
                    case ']': {
                        if (stack.isEmpty()) {
                            answerList.add("no");
                            alreadyCheck = true;
                            returnFlag = true;
                            break;
                        }
                        Character peek = stack.peek();
                        if (peek == '[') {
                            stack.pop();
                        } else {
                            answerList.add("no");
                            alreadyCheck = true;
                            returnFlag = true;
                        }
                        break;
                    }
                    case ')': {
                        if (stack.isEmpty()) {
                            answerList.add("no");
                            alreadyCheck = true;
                            returnFlag = true;
                            break;
                        }
                        Character peek1 = stack.peek();
                        if (peek1 == '(') {
                            stack.pop();
                        } else {
                            answerList.add("no");
                            alreadyCheck = true;
                            returnFlag = true;
                        }
                        break;
                    }
                    case '.': returnFlag = true;
                    default: {
                        break;
                    }
                }

                if (returnFlag) {
                    break;
                }
            }

            if (!alreadyCheck) {
                if (stack.isEmpty()) {
                    answerList.add("yes");
                } else {
                    answerList.add("no");
                }
            }

            line = br.readLine();
            if (Objects.equals(".", line)) {
                break;
            }
        }

        for (String s : answerList) {
            System.out.println(s);
        }

    }
}