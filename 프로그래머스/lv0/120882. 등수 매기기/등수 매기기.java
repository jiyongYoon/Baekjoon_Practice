import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    class Member {
        int idx;
        double avg;
        int rank;

        public Member(int idx, double avg) {
            this.idx = idx;
            this.avg = avg;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }

    public int[] solution(int[][] score) {
        List<Member> memberList = new ArrayList<>();
        int idx = 1;
        for (int[] ints : score) {
            memberList.add(new Member(idx++, avg(ints[0], ints[1])));
        }
        Collections.sort(memberList, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if (o1.avg < o2.avg) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        idx = 0;

        int rank = 0;
        double beforeAvg = 0;
        int stack = 0;
        for (Member member : memberList) {
            double curAvg = member.avg;
            if (beforeAvg == curAvg) {
                member.setRank(rank);
                stack++;
            } else {
                rank = rank + stack + 1;
                stack = 0;
                member.setRank(rank);
            }
            beforeAvg = curAvg;
        }

        Collections.sort(memberList, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if (o1.idx >= o2.idx) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        int[] answer = new int[memberList.size()];
        idx = 0;
        for (Member member : memberList) {
            answer[idx++] = member.rank;
        }
        return answer;
    }

    public static double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}