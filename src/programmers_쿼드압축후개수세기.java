package programmers;

public class programmers_쿼드압축후개수세기 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}
        };
        int[][] arr1 = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}
        };

        solution(arr);
        solution(arr1);
    }

    static int[][] map;
    static int cnt0 = 0;
    static int cnt1 = 0;

    // 최종적으로 남는 0의 개수와 1의 개수 return
    // arr은 정사각형
    public static int[] solution(int[][] arr) {
        map = arr;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    cnt1++;
                } else {
                    cnt0++;
                }
            }
        }

        if (cnt0 == 0) {
            return new int[]{0, 1};
        } else if (cnt1 == 0) {
            return new int[]{1, 0};
        }

        compress(0, 0, n);

        return new int[]{cnt0, cnt1};
    }

    public static void compress(int si, int sj, int length) {

        if (length/2 == 1) return;

        // 왼위
        int c0 = 0, c1 = 0;
        for (int i = si; i < si + length / 2; i++) {
            for (int j = sj; j < sj + length / 2; j++) {
                if (map[i][j] == 0) {
                    c0++;
                } else {
                    c1++;
                }
            }
        }
        if (c0 == 0) {
            cnt1 -= (length / 2) * (length / 2) - 1;
        } else if (c1 == 0) {
            cnt0 -= (length / 2) * (length / 2) - 1;
        } else {
            compress(si, sj, length / 2);
        }

        // 오위
        c0 = 0;
        c1 = 0;
        for (int i = si; i < si + length / 2; i++) {
            for (int j = sj + length / 2; j < sj + length; j++) {
                if (map[i][j] == 0) {
                    c0++;
                } else {
                    c1++;
                }
            }
        }
        if (c0 == 0) {
            cnt1 -= (length / 2) * (length / 2) - 1;
        } else if (c1 == 0) {
            cnt0 -= (length / 2) * (length / 2) - 1;
        } else {
            compress(si, sj + length / 2, length / 2);
        }

        // 왼아래
        c0 = 0;
        c1 = 0;
        for (int i = si + length / 2; i < si + length; i++) {
            for (int j = sj; j < sj + length / 2; j++) {
                if (map[i][j] == 0) {
                    c0++;
                } else {
                    c1++;
                }
            }
        }
        if (c0 == 0) {
            cnt1 -= (length / 2) * (length / 2) - 1;
        } else if (c1 == 0) {
            cnt0 -= (length / 2) * (length / 2) - 1;
        } else {
            compress(si + length / 2, sj, length / 2);
        }

        // 우아래
        c0 = 0;
        c1 = 0;
        for (int i = si + length / 2; i < si + length; i++) {
            for (int j = sj + length / 2; j < sj + length; j++) {
                if (map[i][j] == 0) {
                    c0++;
                } else {
                    c1++;
                }
            }
        }
        if (c0 == 0) {
            cnt1 -= (length / 2) * (length / 2) - 1;
        } else if (c1 == 0) {
            cnt0 -= (length / 2) * (length / 2) - 1;
        } else {
            compress(si + length / 2, sj + length / 2, length / 2);
        }
    }
}
