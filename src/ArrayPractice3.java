// Practice2
// 배열 arr의 데이터 순서를 거꾸로 변경하세요.
// 추가 배열을 사용하지 않고 구현

// 입출력 예시)
// arr: 1, 3, 5, 7, 9
// 결과: 9, 7, 5, 3, 1

import java.util.Arrays;

public class ArrayPractice3 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};

        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i -1] = tmp;
        }
        System.out.println("결과: " + Arrays.toString(arr));
    }
}
