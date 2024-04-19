import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static int index = 0;
    static List<Character> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String log = br.readLine();
            char[] charArray = log.toCharArray();

            for (char c : charArray) {
                operate(c);
            }

            StringBuilder sb = new StringBuilder(list.size());
            for (char c : list) {
                sb.append(c);
            }
            System.out.println(sb);
            reset();
        }
    }

    public static void reset() {
        index = 0;
        list.clear();
    }

    public static void operate(char c) {
        if (c == '<') {
            index = Math.max(0, index - 1);
        } else if (c == '>') {
            index = index + 1;
            if (index > list.size()) {
                index = list.size();
            }
        } else if (c == '-') {
            if (index > 0) {
                list.remove(index - 1);
                index--;
            }
        } else {
            list.add(index++, c);
        }
    }
}