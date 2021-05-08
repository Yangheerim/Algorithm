public class kakaointernship_solution2 {
    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        solution(places);
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = isOk(places[i]);
            System.out.print(answer[i]+" ");
        }
        return answer;
    }

    public static int isOk(String[] place) {
        char[][] map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String tmp = place[i];
            for (int j = 0; j < 5; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'P') {
                    if (!check1Dis(map, i, j)) { // 거리두기 안지켜졌으면
                        return 0;
                    }
                    if (!check2Dis(map, i, j)) { // 거리두기 안지켜졌으면
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    // true : 범위 벗어남
    public static boolean isOutBound(int i, int j) {
        if (i < 0 || i >= 5 || j < 0 || j >= 5) return true;
        return false;
    }

    // true : 거리두기 지켜짐, false : 안지켜짐
    public static boolean check1Dis(char[][] map, int i, int j) {
        int[] move1i = {0, 0, 1, -1};
        int[] move1j = {1, -1, 0, 0};

        for (int d = 0; d < 4; d++) {
            int ni = i + move1i[d];
            int nj = j + move1j[d];
            if (isOutBound(ni, nj)) continue;
            if (map[ni][nj] == 'P') return false;
        }
        return true;
    }

    // true : 거리두기 지켜짐, false : 안지켜짐
    public static boolean check2Dis(char[][] map, int i, int j) {
        int[] move2i = {0, 0, -1, -1, 1, 1, 2, -2};
        int[] move2j = {2, -2, -1, 1, -1, 1, 0, 0};

        for (int d = 0; d < 8; d++) {
            int ni = i + move2i[d];
            int nj = j + move2j[d];
            if (isOutBound(ni, nj)) continue;
            if (map[ni][nj] == 'P') {
                if (move2i[d] == 0 || move2j[d] == 0) {
                    if (map[i+move2i[d]/2][j+move2j[d]/2] != 'X') return false;
                } else {
                    if (map[ni][j] != 'X' || map[i][nj] != 'X') return false;
                }

            }
        }
        return true;
    }

}
