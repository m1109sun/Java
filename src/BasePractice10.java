// Practice10
// 문제 설명
// 하노이의 탑은 퍼즐의 일종이다. 하노이의 탑 퍼즐 게임 규칙은 다음과 같다.
// 한 번에 한 개의 원판만 옮길 수 있다.
// 큰 원판이 작은 원판 위에 있어서는 안된다.

// 원판의 개수 n이 주어졌을 때 가장 왼쪽 기둥으로부터 끝 기둥으로 이동하는 과정에 대해 출력하는 프로그램을 구현하세요.

// 입출력 예시
// 입력: 2 -> 출력: 12 13 23
// 입력: 3 -> 출력: 13 12 32 13 21 23 13

public class BasePractice10 {
    static StringBuffer sb;

    public static void solution(int n) {
        sb = new StringBuffer();

        hanoi(n, 1, 2, 3);
        System.out.println(sb);
    }

    public static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }
        hanoi(n - 1, start, to, mid);

        sb.append(start + " " + to + "\n");

        hanoi(n - 1, mid, start, to);
    }

    public static void main(String[] args) {
        // Test code
        solution(2);
        System.out.println();

        solution(3);
        System.out.println();

        solution(4);
    }
}