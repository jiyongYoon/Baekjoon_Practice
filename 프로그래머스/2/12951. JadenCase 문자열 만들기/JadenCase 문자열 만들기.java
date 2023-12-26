class Solution {
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String[] stringArr = s.split("");
        boolean beforeBlank = true;

        for (String str : stringArr) {
            if (str.isBlank()) {
                sb.append(" ");
                beforeBlank = true;
                continue;
            }

            Character c = str.charAt(0);
            if (beforeBlank) {
                beforeBlank = false;
                if (Character.isAlphabetic(c)) {
                    sb.append(String.valueOf(c).toUpperCase());
                } else {
                    sb.append(str.toLowerCase());
                }
            } else {
                sb.append(str.toLowerCase());
            }
        }
        
        return sb.toString();
    }
}