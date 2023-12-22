import java.util.Map;
import java.util.HashMap;


class Solution {
    public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String call : callings) {
            call(call, players, map);
        }

        return players;
    }

    public static void call(String player, String[] players, Map<String, Integer> map) {
        Integer i = map.get(player);
        switchPlayer(players, i, map);
    }

    private static void switchPlayer(String[] players, int i, Map<String, Integer> map) {
        map.put(players[i], i - 1);
        map.put(players[i - 1], i);

        String tmp = players[i];
        players[i] = players[i - 1];
        players[i - 1] = tmp;
    }
}