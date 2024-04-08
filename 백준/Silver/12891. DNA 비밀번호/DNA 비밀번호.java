import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int stringLength = Integer.parseInt(st.nextToken());
        int partStringLength = Integer.parseInt(st.nextToken());

        String totalString = br.readLine();
        char[] totalChar = totalString.toCharArray();

        st = new StringTokenizer(br.readLine());

        int aCount = Integer.parseInt(st.nextToken());
        int cCount = Integer.parseInt(st.nextToken());
        int gCount = Integer.parseInt(st.nextToken());
        int tCount = Integer.parseInt(st.nextToken());

        int answer = 0;

        int leftIndex = 0;
        int rightIndex = leftIndex + partStringLength - 1;

        int a = aCount;
        int c = cCount;
        int g = gCount;
        int t = tCount;

        String firstPartString = totalString.substring(leftIndex, rightIndex + 1);
        char[] partChars = firstPartString.toCharArray();

        for (char character : partChars) {
            switch(character) {
                case 'A': a--; break;
                case 'C': c--; break;
                case 'G': g--; break;
                case 'T': t--; break;
                default: break;
            }
        }

        answer = checkAnswer(a, c, g, t, answer);

        while (rightIndex < stringLength - 1) {

            rightIndex++;

            char addChar = totalChar[rightIndex];

            switch(addChar) {
                case 'A': a--; break;
                case 'C': c--; break;
                case 'G': g--; break;
                case 'T': t--; break;
                default: break;
            }

            char minusChar = totalChar[leftIndex];

            switch(minusChar) {
                case 'A': a++; break;
                case 'C': c++; break;
                case 'G': g++; break;
                case 'T': t++; break;
                default: break;
            }
            leftIndex++;

            answer = checkAnswer(a, c, g, t, answer);
        }

        System.out.println(answer);
    }

    private static int checkAnswer(int a, int c, int g, int t, int answer) {
        if (a <= 0 && c <= 0 && g <= 0 && t <= 0) {
            answer++;
        }

        return answer;
    }

}