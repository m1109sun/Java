// Practice1
// 문제 설명
// 파스칼의 삼각형은 수학에서 이항계수를 삼각형 모양의 기하학적 형태로 배열한 것이다.
// 파스칼의 삼각형은 다음과 같이 만들 수 있다.
// 1. 첫 번째 숫자는 숫자 1을 쓴다.
// 2. 그 다음 줄은 바로 위의 왼쪽 숫자와 오른쪽 숫자를 더한다.
// 삼각형의 행의 수가 입력으로 주어졌을 때, 파스칼의 삼각형을 출력하시오.

// 입출력 예시
// 입력: 1 -> 출력: [[1]]
// 입력: 3 -> 출력: [[1], [1, 1], [1, 2, 1]]
// 입력: 5 -> 출력: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]

import java.util.ArrayList;

public class BasePractice1 {
    public static ArrayList<ArrayList<Integer>> solution(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j < i + 1; j++) {
                // 가장 첫 번째 또는 외곽에 있는 것은 1 넣기
                if (j == 0 | j == i) {
                    list.add(1);
                } else {
                    int x = result.get(i - 1).get(j - 1); // 왼쪽 값
                    int y = result.get(i - 1).get(j); // 오른쪽 값
                    list.add(x + y);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
    }
}