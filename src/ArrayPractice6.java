// Practice6
// 배열 arr에서 중복 값을 제거한 새 배열을 만드시오.

// 입출력 예시)
// arr: 1, 5, 3, 2, 2, 3, 1, 4, 1, 3, 5
// 결과: 1, 5, 3, 2, 4

public class ArrayPractice6 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5};
        int[] arrResult = new int[arr.length];
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean dupFlag = false; // 중복값인지 체크하는 변수
            for (int j = 0; j < cnt; j++) {
                if (arr[i] == arrResult[j]) {
                    dupFlag = true;
                }
            }

            if (dupFlag == false) {
                arrResult[cnt++] = arr[i];
            }
        }

        for (int i = 0; i < cnt; i ++) {
            System.out.print(arrResult[i] + " ");
        }
        System.out.println();
    }
}