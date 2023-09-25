class Solution {
    enum Dir {
        RIGHT,
        DOWN,
        LEFT,
        UP
        ;

    }

    class Pointer {
        int x;
        int y;
        int num;
        Dir dir;

        public Pointer(int x, int y, int num, Dir dir) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
        }
    }

    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = 0;
            }
        }

        Pointer pointer = new Pointer(0, 0, 1, Dir.RIGHT);

        answer[0][0] = pointer.num++;

        for (int i = 0; i < n * n - 1; i++) {
            int a = pointer.x;
            int b = pointer.y;
            switch (pointer.dir) {
                case UP:
                    if (a - 1 >= 0 && answer[a - 1][b] == 0) {
                        pointer.x = pointer.x - 1;
                        answer[pointer.x][pointer.y] = pointer.num;
                        pointer.num++;
                    } else {
                        i--;
                        pointer.dir = Dir.RIGHT;
                    }
                    break;
                case DOWN:
                    if (a + 1 < n && answer[a + 1][b] == 0) {
                        pointer.x = pointer.x + 1;
                        answer[pointer.x][pointer.y] = pointer.num;
                        pointer.num++;
                    } else {
                        i--;
                        pointer.dir = Dir.LEFT;
                    }
                    break;
                case RIGHT:
                    if (b + 1 < n && answer[a][b + 1] == 0) {
                        pointer.y = pointer.y + 1;
                        answer[pointer.x][pointer.y] = pointer.num;
                        pointer.num++;
                    } else {
                        i--;
                        pointer.dir = Dir.DOWN;
                    }
                    break;
                case LEFT:
                    if (b - 1 >= 0 && answer[a][b - 1] == 0) {
                        pointer.y = pointer.y - 1;
                        answer[pointer.x][pointer.y] = pointer.num;
                        pointer.num++;
                    } else {
                        i--;
                        pointer.dir = Dir.UP;
                    }
            }
        }

        return answer;
    }
}