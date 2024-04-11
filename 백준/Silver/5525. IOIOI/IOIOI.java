import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static char[] targetArr;
    static List<Integer> PnList = new ArrayList<>();
    static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int checkCount = Integer.parseInt(st.nextToken());

        int length = Integer.parseInt(br.readLine());

        if (length < 3) {
            System.out.println(0);
            return;
        }

        String targetString = br.readLine();
        targetArr = targetString.toCharArray();

        while (index < length - 1) {
            recur(index, 0);
        }

        int answer = 0;

        for (Integer integer : PnList) {
            if (integer >= checkCount) {
                answer += integer - checkCount + 1;
            }
        }

        System.out.println(answer);
    }

    private static void recur(int i, int count) {

        try {
            if (checkI(targetArr[i])) {
                i++;
                if (checkO(targetArr[i])) {
                    i++;
                    if (checkI(targetArr[i])) {
                        count++;
                        recur(i, count);
                    } else {
                        if (count > 0) {
                            PnList.add(count);
                        }
                        index = i + 1;
                    }
                } else {
                    if (count > 0) {
                        PnList.add(count);
                    }
                    index = i;
                }
            } else {
                if (count > 0) {
                    PnList.add(count);
                }
                index = i + 1;
            }
        } catch (IndexOutOfBoundsException e) {
            if (count > 0) {
                PnList.add(count);
            }
             index = i + 1;
        }
    }

    private static boolean checkI(char c) {
        return (c == 'I');
    }

    private static boolean checkO(char c) {
        return (c == 'O');
    }
}