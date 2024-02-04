// 알고리즘 - 정렬2
// 합병 정렬
// 힙 정렬
// 퀵 정렬
// 트리 정렬

import java.util.Arrays;

public class MySort2 {
    // 합병 정렬
    // 분할하는 함수
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, tmp, left, mid); // 좌측 부분
            mergeSort(arr, tmp, mid + 1, right); // 우측 부분
            merge(arr, tmp, left, right, mid);
        }
    }
    // 합쳐주는 함수
    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) {
        int p = left;
        int q = mid + 1;
        int idx = p;

        while (p <= mid || q <= right) {
            if (p <= mid && q <= right) {
                if (arr[p] <= arr[q]) {
                    tmp[idx++] = arr[p++];
                }
                else {
                    tmp[idx++] = arr[q++];
                }
            } else if (p <= mid && q > right) {
                tmp[idx++] = arr[p++];
            } else {
                tmp[idx++] = arr[q++];
            }
        }
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }
    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
        System.out.println("합병 정렬: " + Arrays.toString(arr));
    }
}