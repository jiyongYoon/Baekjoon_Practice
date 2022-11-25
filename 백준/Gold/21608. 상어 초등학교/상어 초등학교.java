import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[][] chair;
    public static int[][] like;
    public static int answer;
    public static final int[][] dir = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        chair = new int[N][N];
        like = new int[N * N][5];
        answer = 0;

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                like[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N * N; i++) {
            Point returnPoint = condition1(i).get(0);
            chair[returnPoint.x][returnPoint.y] = like[i - 1][0];
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(chair[i][j] + " ");
//            }
//            System.out.println();
//        }

        answer();
    }

    public static void answer() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int curStudent = chair[i][j];
                int likeCnt = 0;
                for (int k = 0; k < N * N; k++) {
                    if(curStudent == like[k][0]) {
                        ArrayList<Integer> sideStudent = new ArrayList<>();
                        for (int[] d : dir) {
                            int x = i + d[0];
                            int y = j + d[1];
                            if(x >= 0 && y >= 0 && x < N && y < N) {
                                sideStudent.add(chair[x][y]);
                            }
                        }
                        for (int l = 1; l < 5; l++) {
                            int likeStudent = like[k][l];
                            for (int m = 0; m < sideStudent.size(); m++) {
                                if(likeStudent == sideStudent.get(m)) {
                                    likeCnt++;
                                }
                            }
                        }
                    }
                }
                if(likeCnt == 0) {
                    answer += 0;
                } else if(likeCnt == 1) {
                    answer += 1;
                } else if(likeCnt == 2) {
                    answer += 10;
                } else if(likeCnt == 3) {
                    answer += 100;
                } else if(likeCnt == 4) {
                    answer += 1000;
                }

            }
        }
        System.out.print(answer);
    }

    public static int checkSeat(int a, int b) {
        int empty = 0;

        for (int[] d : dir) {
            int x = a + d[0];
            int y = b + d[1];
            if(x >= 0 && y >= 0 && x < N && y < N) {
                if(chair[x][y] == 0) {
                    empty++;
                }
            }
        }

        return empty;
    }

    public static int checkLikeStudents(int a, int b, int studentNum) {
        int result = 0;

        for (int i = 0; i < N * N; i++) {
            if(like[i][0] == studentNum) {
                for (int j = 1; j < 5; j++) {
                    int curLike = like[i][j];
                    for (int[] d : dir) {
                        int x = a + d[0];
                        int y = b + d[1];
                        if (x >= 0 && y >= 0 && x < N && y < N) {
                            if (chair[x][y] == curLike) {
                                result++;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public static ArrayList<Point> condition1(int studentIdx) {
        int[][] condition1Arr = new int[N][N];
        int[] cntArr = new int[4];
        int maxChair = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(chair[i][j] == 0) {
                    condition1Arr[i][j] = checkLikeStudents(i, j, like[studentIdx - 1][0]);
                    maxChair = Math.max(maxChair, condition1Arr[i][j]);
                }
            }
        }

        ArrayList<Point> condition1List = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(condition1Arr[i][j] == maxChair && chair[i][j] == 0) {
                    condition1List.add(new Point(i, j));
                }
            }
        }

        if(condition1List.size() == 1) {
            return condition1List;
        }

        ArrayList<Point> answerList = new ArrayList<>();

        answerList = condition2(condition1List, studentIdx);

        if(answerList.size() == 1) {
            return answerList;
        }

        Point answer = condition3(answerList, studentIdx);

        return new ArrayList<>(Arrays.asList(answer));
    }

    public static ArrayList<Point> condition2(ArrayList<Point> condition1List, int studentIdx) {
        ArrayList<Point> condition2List = new ArrayList<>();

        int maxEmpty = -1;
        int[] condition1Arr = new int[condition1List.size()];
        int tmpCnt = 0;
        int[] out = new int[2];

        for (Point item : condition1List) {
            int tmp = checkSeat(item.x, item.y);
            condition1Arr[tmpCnt] = tmp;
            tmpCnt++;
            if(tmp > maxEmpty) {
                maxEmpty = tmp;
                out[0] = item.x;
                out[1] = item.y;
            }
        }

        int maxCnt = 0;
        for (int i = 0; i < condition1Arr.length; i++) {
            if(condition1Arr[i] == maxEmpty) {
                maxCnt++;
            }
        }

        if(maxCnt == 1) {
            return new ArrayList<>(Arrays.asList(new Point(out[0], out[1])));
        }

        for (int i = 0; i < condition1Arr.length; i++) {
            if(condition1Arr[i] == maxEmpty) {
                condition2List.add(condition1List.get(i));
            }
        }

        return condition2List;
    }

    public static Point condition3(ArrayList<Point> condition2List, int studentIdx) {
        PriorityQueue<Point> pq = new PriorityQueue<>((Point p1, Point p2) -> p1.x >= p2.x ? 1 : -1);
        for (Point item : condition2List) {
            pq.offer(item);
        }

        while(!pq.isEmpty()) {
            Point cur = pq.poll();
            Point next = pq.peek();
            if(cur.x == next.x) {
                if(cur.y < next.y) {
                    return cur;
                } else {
                    return next;
                }
            } else {
                if(cur.x < next.x) {
                    return cur;
                } else {
                    return next;
                }
            }
        }
        return null;
    }

}