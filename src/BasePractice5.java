// Practice5
// 문제 설명
// 영토에 대한 지도 정보가 row X col grid 맵 형태로 다음과 같이 주어졌다.
// 이 때, grid[i][j]가 1이면 땅 영역을 의미하고 grid[i][j]가 0이면 물 영역을 의미한다.
// 이와 같이 영토에 대한 지도 정보가 주어졌을 때 땅의 둘레를 구하는 프로그램을 작성하세요.
// grid 한 cell의 변의 길이는 1이다.
// 지도에는 하나의 독립된 영토만 있다. (분리된 땅 없음)
// 땅 내부에 물이 존재하지 않는다.

// 입출력 예시
// 입력: {1} -> 출력: 4
// 입력: {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}} -> 출력: 16

public class BasePractice5 {
    // 반복문 풀이
    public static int solution1(int[][] grid) {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // x, y에 대한 좌표값
        int cnt = 0;

        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    for (int[] d: directions) {
                        int x = i + d[0];
                        int y = j + d[1];

                        // 바운더리와 맞닿아 있는 경우
                        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    // 재귀 풀이
    public static int solution2(int[][] grid) {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // x, y에 대한 좌표값

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return recursion(grid, directions, i, j);
                }
            }
        }


        return 0;
    }

    public static int recursion(int[][] grid, int[][] directions, int i , int j) {
        int row = grid.length;
        int col = grid[0].length;

        grid[i][j] = -1; // 이미 방문한 곳은 -1로 바꿈! 방문했던 곳을 다시 방문하지 않기 위함!
        int cnt = 0;
        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0) {
                cnt++;
            } else {
                if (grid[x][y] == 1) {
                    cnt += recursion(grid, directions, x, y);
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        // Test code
        int[][] grid = {{1}};
        System.out.println(solution1(grid));
        System.out.println(solution2(grid));
        System.out.println();

        grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(solution1(grid));
        System.out.println(solution2(grid));
        ;
    }
}