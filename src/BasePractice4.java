// Practice4
// 문제 설명
// 주어진 양의 정수가 행복한 수 인지를 판별하는 프로그램을 작성하세요.
// 행복한 수란,
// 각 자리수를 제곱한 것을 더하는 과정을 반복했을 때 1로 끝나는 수이다.
// 행복한 수가 아니라면 1에 도달하지 못하고 같은 수열이 반복하게 된다.

// "행복한 수"를 찾는 과정 예시
// 19가 행복한 수인지 확인하는 과정
// 1^2 + 9^2 = 82
// 8^2 + 2^2 = 68
// 6^2 = 8^2 = 100
// 1^2 + 0^2 + 0^2 = 1

// 입출력 예시
// 입력: 19 -> 출력: true
// 입력: 2 -> 출력: false
// 입력: 61 -> 출력: false

import java.util.HashSet;

public class BasePractice4 {
    public static boolean solution(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (set.add(n)) {
            int squareSum = 0;

            while (n > 0) {
                int remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }

            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(19));
        System.out.println(solution(2));
        System.out.println(solution(61));
    }
}