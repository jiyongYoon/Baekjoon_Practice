import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int times;
    static int kinds;
    static HashMap<String, Integer> hm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        times = Integer.parseInt(st.nextToken());
        for (int i = 0; i < times; i++) {
            kinds = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            
            if(kinds == 0) {
                System.out.println(0);
                continue;
            }

            hm = new HashMap<>();

            for (int j = 0; j < kinds; j++) {
                st = new StringTokenizer(br.readLine());
                String wear = st.nextToken();
                String wearKind = st.nextToken();
                hm.put(wearKind, hm.getOrDefault(wearKind, 0) + 1);
            }

            int answer = 1;

            if(hm.size() > 1) {
                for (String s : hm.keySet()) {
                    answer *= (hm.get(s) + 1);
                }
                System.out.println(answer - 1);
            } else {
                for (String s : hm.keySet()) {
                    answer *= (hm.get(s));
                }
                System.out.println(answer);
            }
        }
    }
}