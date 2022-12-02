import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1. PQ로 from, to를 받아서 넣음
2. 1번으로 시작하는공을 먼저 다 꺼내서 찐친 체크
3. 그 다음부터는 큐에 있는것들 다 꺼내서 찐친 친구인지 한번 더 체크
 */

public class Main {

    static class Node implements Comparable<Node>{
        int from;
        int to;

        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Node o) {
            return this.from >= o.from ? 1 : -1;
        }
    }

//    static PriorityQueue<Node> realFriends;
    static PriorityQueue<Node> secondFriends;
    static Queue<Node> realFriends;
//    static Queue<Node> secondFriends;

    static int n;
    static int m;
    static boolean[] invited1;
    static boolean[] invited2;
    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

//        realFriends = new PriorityQueue<>();
//        secondFriends = new PriorityQueue<>();

        realFriends = new LinkedList<>();
//        secondFriends = new LinkedList<>();
        secondFriends = new PriorityQueue<>();
        invited1 = new boolean[n + 1];
        invited2 = new boolean[n + 1];
        answer = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());
            Node friend =
                new Node(Math.min(tmp1, tmp2), Math.max(tmp1, tmp2));
            if(friend.from == 1 && !invited1[friend.to]) {
                realFriends.add(friend);
                invited1[friend.to] = true;
                invited2[friend.to] = true;
                answer++;
            } else {
                secondFriends.add(friend);
            }
        }

        if(realFriends.isEmpty()) {
            System.out.println(0);
            return;
        }

        while(!secondFriends.isEmpty()) {
            Node curFriend = secondFriends.poll();
            if(invited1[curFriend.from] && !invited2[curFriend.to]) {
                invited2[curFriend.to] = true;
                answer++;
            } else if(invited1[curFriend.to] && !invited2[curFriend.from]) {
                invited2[curFriend.from] = true;
                answer++;
            }
        }

//        for (int i = 0; i < invited1.length; i++) {
//            System.out.print(invited1[i] + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < invited2.length; i++) {
//            System.out.print(invited2[i] + " ");
//        }
//        System.out.println();

        System.out.println(answer);
    }
}