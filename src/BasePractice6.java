// Practice6
// 문제 설명
// 카탈랑 수는 0번, 1번, 2번, ...순으로 아래와 같이 구성되는 수열을 의미한다.
// 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, ...
// 카탈랑 수의 n번째 값을 구하는 프로그램을 작성하세요.

// 입출력 예시
// 입력: 0 -> 출력: 1
// 입력: 2 -> 출력: 2
// 입력: 5 -> 출력: 42
// 입력: 7 -> 출력: 429

public class BasePractice6 {
    public static int solution(int n) {
        int result = 0;

        if (n <= 1) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            result += solution(i) * solution(n  - i - 1);
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(0));
        System.out.println(solution(2));
        System.out.println(solution(5));
        System.out.println(solution(7));
    }
}