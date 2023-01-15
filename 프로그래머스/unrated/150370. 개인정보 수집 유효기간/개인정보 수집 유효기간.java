import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    static int todayYear;
    static int todayMonth;
    static int todayDay;
    static HashMap<String, Integer> termsMap;

    static class Privacy {
        int year;
        int month;
        int day;
        String type;

        public Privacy(int year, int month, int day, String type) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.type = type;
        }
    }

    static class Possible {
        int year;
        int month;
        int day;

        public Possible(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    public static ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();

        todayYear = Integer.parseInt(today.substring(0, 4));
        todayMonth = Integer.parseInt(today.substring(5, 7));
        todayDay = Integer.parseInt(today.substring(8, 10));

        LocalDate todayLocalDate = LocalDate.parse(todayYear
                + "-" + String.format("%02d", todayMonth)
                + "-" + String.format("%02d", todayDay)
        );

        termsMap = new HashMap<>();
        for (String item : terms) {
            termsMap.put(item.substring(0, 1), Integer.parseInt(item.substring(2)));
        }

        ArrayList<Privacy> privacyList = new ArrayList<>();
        for (String item : privacies) {
            Privacy privacy = new Privacy(
                    Integer.parseInt(item.substring(0, 4)),
                    Integer.parseInt(item.substring(5, 7)),
                    Integer.parseInt(item.substring(8, 10)),
                    item.substring(11)
            );
            privacyList.add(privacy);
        }

        for (int i = 0; i < privacyList.size(); i++) {
            Privacy curPrivacy = privacyList.get(i);
            Possible possibleDate = getPossibleDate(curPrivacy);

            if (!checkPast(todayLocalDate, possibleDate)) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

    private static boolean checkPast(LocalDate todayLocalDate, Possible possibleDate) {
        LocalDate possibleLocalDate = LocalDate.parse(possibleDate.year
                + "-" + String.format("%02d", possibleDate.month)
                + "-" + String.format("%02d", possibleDate.day)
        );

        if (todayLocalDate.isBefore(possibleLocalDate)) {
            return true;
        }
        return false;
    }

    private static Possible getPossibleDate(Privacy privacy) {
        int term = termsMap.get(privacy.type);
        int possibleYear = privacy.year;
        int possibleMonth = privacy.month + term;
        int possibleDay = privacy.day;

        while(possibleMonth > 12) {
            possibleMonth = possibleMonth - 12;
            possibleYear++;
        }

        return new Possible(possibleYear, possibleMonth, possibleDay);
    }
}