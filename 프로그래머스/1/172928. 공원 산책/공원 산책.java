class Solution {
    
    static char[][] field;

    static int[] cur = new int[2];
    
    public static int[] solution(String[] park, String[] routes) {
            field = new char[park.length][park[0].length()];

            for (int i = 0; i < park.length; i++) {
                String s = park[i];
                for (int j = 0; j < s.length(); j++) {
                    field[i][j] = s.charAt(j);
                    if (field[i][j] == 'S') {
                        cur[0] = i;
                        cur[1] = j;
                    }
                }
            }

            for (int i = 0; i < routes.length; i++) {
                String[] arr = routes[i].split(" ");
                String dir = arr[0];
                int move = Integer.parseInt(arr[1]);

                int falseCount = 0;
                int[] before = {cur[0], cur[1]};
                for (int j = 0; j < move; j++) {
                    falseCount += move(dir);
                }

                if (falseCount != 0) {
                    cur[0] = before[0];
                    cur[1] = before[1];
                    falseCount = 0;
                }
            }

            return cur;
        }

        static int move(String dir) {
            switch (dir) {
                case "E":
                    cur[1] = cur[1] + 1;
                    break;
                case "W":
                    cur[1] = cur[1] - 1;
                    break;
                case "S":
                    cur[0] = cur[0] + 1;
                    break;
                case "N":
                    cur[0] = cur[0] - 1;
                    break;
            }

            if (check()) {
                return 0;
            } else {
                return 1;
            }
        }

        static boolean check() {
            if (cur[0] >= 0 && cur[0] < field.length
                && cur[1] >= 0 && cur[1] < field[0].length) {
                if (field[cur[0]][cur[1]] != 'X') {
                    return true;
                }
            }
            return false;
        }
}