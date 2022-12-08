import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
각 집은 치킨거리를 가지고 있음 -> |x1 - x2| + |y1 - y2|
도시의 치킨거리 -> 모든 집의 치킨거리의 합

1. 아이디어
- 일단 돌아가면서 치킨집, 마을이 어디고 몇개인지 체크
- 치킨집 / 마을 로 2차원 배열 만들어서 각 거리를 기입
- 치킨집을 백트래킹, 조합으로 체크(총 치킨집 중 M개를 선택할 때)
 */

public class Main {

    public static int N;
    public static int M;
    public static int[][] map;
    public static ArrayList<int[]> chicken;
    public static ArrayList<int[]> home;
    public static int[][] homeChicken;
    public static int chickenCnt;
    public static int homeCnt;
    public static boolean[] chickenVisited;
    public static int[] choiceChicken;
    public static ArrayList<Integer> answer;


    public static int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
    public static void solution() {
        chickenCnt = chicken.size();
        homeCnt = home.size();
        homeChicken = new int[homeCnt][chickenCnt];
        chickenVisited = new boolean[chickenCnt];
        choiceChicken = new int[M];

        for (int i = 0; i < homeCnt; i++) {
            int[] curHome = home.get(i);
            for (int j = 0; j < chickenCnt; j++) {
                int[] curChicken = chicken.get(j);
                homeChicken[i][j] = getDistance(curHome, curChicken);
            }
        }

        recur(0, 0);

    }

    public static void recur(int depth, int start) {
        if(depth == M) {
            int result = 0;
            for (int i = 0; i < homeCnt; i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    tmp = Math.min(tmp, homeChicken[i][choiceChicken[j]]);
                }
                result += tmp;
            }
            answer.add(result);
            return;
        }

        for (int i = start; i < chickenCnt; i++) {
            if(!chickenVisited[i]) {
                chickenVisited[i] = true;
                choiceChicken[depth] = i;
                recur(depth + 1, i);
                chickenVisited[i] = false;
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        answer = new ArrayList<>();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    home.add(new int[]{i, j});
                } else if(map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        solution();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < answer.size(); i++) {
            min = Math.min(answer.get(i), min);
        }
        System.out.println(min);
    }
}