// Practice2
// 문제 설명
// 양의 정수로 이루어진 arr 배열이 주어졌을 때 해당 데이터로 만들 수 있는 permutation 중에서 다음과 같은 데이터를 출력하는 프로그램을 작성하세요.
// 현재 데이터보다 이전의 큰 수를 출력
// 한 번의 swap으로 출력 가능한 큰 수를 출력

// 입출력 예시
// 입력: 3, 2, 1 -> 출력: 3, 1, 2
// 입력: 1, 9, 4, 7, 6 -> 출력: 1, 9, 4, 6, 7
// 입력: 1, 1, 2, 3 -> 출력: 1, 1, 2, 3

import java.util.Arrays;

public class BasePractice2 {
    public static void solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 바꿔줄 대상 찾기
        int idx = -1;
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i] < arr[i - 1]) {
                idx = i - 1;
                break;
            }
        }

        // 이미 정렬된 상태 -> 그대로 출력
        if (idx == -1) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        // 어떤 걸로 swap 할지 출력
        for (int i = arr.length - 1; i > idx; i--) {
            if (arr[i] < arr[idx] && arr[i] != arr[i - 1]) {
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 4, 1};
        solution(arr);

        arr = new int[]{1, 9, 4, 7, 6};
        solution(arr);

        arr = new int[]{1, 1, 2, 3};
        solution(arr);
    }
}