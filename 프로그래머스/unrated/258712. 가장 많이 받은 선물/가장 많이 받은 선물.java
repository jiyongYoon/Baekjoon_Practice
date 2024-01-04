import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public static int solution(String[] friends, String[] gifts) {
        for (String name : friends) {
            Friend friend = new Friend(name);
            save(friend);
        }

        for (String fromTo : gifts) {
            String[] split = fromTo.split(" ");
            String from = split[0];
            String to = split[1];

            Friend giver = findByName(from);
            giver.giveGiftTo(to);
        }
        
        Map<String, Integer> answerMap = new HashMap<>();

        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String name1 = friends[i];
                String name2 = friends[j];
                String receiverName = whoReceiveNextMonth(name1, name2);

                if (receiverName != null) {
                    answerMap.putIfAbsent(receiverName, 0);
                    answerMap.put(receiverName, answerMap.get(receiverName) + 1);
                }
            }
        }
        
        if (answerMap.isEmpty()) {
            return 0;
        }

        return Collections.max(answerMap.values());
    }


    static String whoReceiveNextMonth(String name1, String name2) {
        Friend friend1 = findByName(name1);
        Friend friend2 = findByName(name2);
        Integer f1Tof2 = friend1.getGiveMap().getOrDefault(friend2.getName(), 0);
        Integer f2Tof1 = friend2.getGiveMap().getOrDefault(friend1.getName(), 0);

        if (f1Tof2 > f2Tof1) {
            return friend1.getName();
        } else if (f2Tof1 > f1Tof2) {
            return friend2.getName();
        } else {
            Integer f1Point = friend1.getPoint();
            Integer f2Point = friend2.getPoint();
            if (f1Point > f2Point) {
                return friend1.getName();
            } else if (f2Point > f1Point) {
                return friend2.getName();
            } else {
                return null;
            }
        }
    }


    static Map<String, Friend> repository = new HashMap<>();

    static Friend findByName(String name) {
        return repository.get(name);
    }

    static void save(Friend friend) {
        repository.put(friend.getName(), friend);
    }

    static class Friend {

        public Friend(String name) {
            this.name = name;
            this.point = 0;
            this.giveMap = new HashMap<>();
        }

        private String name;
        private Integer point;
        private Map<String, Integer> giveMap;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getPoint() {
            return point;
        }

        public Map<String, Integer> getGiveMap() {
            return giveMap;
        }

        private void minusPoint() {
            this.point--;
        }

        private void plusPoint() {
            this.point++;
        }

        public void giveGiftTo(String name) {
            Integer count = giveMap.getOrDefault(name, 0);
            count++;
            giveMap.put(name, count);

            this.plusPoint();

            Friend receiver = findByName(name);
            receiver.minusPoint();
        }
    }
}