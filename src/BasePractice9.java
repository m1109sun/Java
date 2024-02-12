// Practice9
// 문제 설명
// 아래와 같이 구성되는 수를 좋은 수라고 한다.
// 짝수 인덱스 위치에는 짝수
// 홀수 인덱스 위치에는 소수 (2,3,5,7)
// 인덱스는 0부터 시작

// 예를 들면, 2582는 좋은 수다. 짝수 인덱스 위치에는 작수인 2와 8로, 홀수 위치에는 소수인 5와 2로 구성된다.
// 반면, 3245는 좋은 수가 아니다. 짝수 인덱스 위치에 홀수인 3이 위치하고 있다.

// 1 이상의 정수 n이 주어졌을 때, n 자리로 구성될 수 있는 좋은 수의 개수를 출력하는 프로그램을 작성하세요.
// 단, n의 값에 따라 값이 클 수 있으니 결과는 10^9 + 7로 나머지 연산을 한 결과로 출력하시오.

// 입출력 예시
// 입력: 1 -> 출력: 5
// 입력: 2 -> 출력: 20
// 입력: 3 -> 출력: 100
// 입력: 4 -> 출력: 400
// 입력: 50 -> 출력: 564908303

public class BasePractice9 {
    final static int mod = (int) 1e9 + 7;

    public static int solution(long n) {
        return (int) (recursion(5, (n + 1) / 2) * recursion(4, n / 2) % mod);
    }

    public static long recursion(long x, long y) {
        if (y == 0) {
            return 1;
        }

        long p = recursion(x, y / 2);
        return p * p * (y % 2 > 0 ? x : 1) % mod;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(50));
    }
}