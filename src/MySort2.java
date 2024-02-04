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
    // 힙 정렬
    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    public static void heapify(int[] arr, int parentIdx, int size) {
        int leftIdx = 2 * parentIdx + 1;
        int rightIdx = 2 * parentIdx + 2;
        int maxIdx = parentIdx;

        if (leftIdx < size && arr[maxIdx] < arr[leftIdx]) {
            maxIdx = leftIdx;
        }

        if (rightIdx < size && arr[maxIdx] < arr[rightIdx]) {
            maxIdx = rightIdx;
        }

        if (parentIdx != maxIdx) {
            swap(arr, maxIdx, parentIdx);
            heapify(arr, maxIdx, size);
        }
    }

    public static void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 퀵 정렬
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;

        while (i < j) {
            while (arr[j] > pivot && i < j) {
                j--;
            }

            while (arr[i] <= pivot && i < j) {
                i++;
            }

            swap(arr, i, j);
        }
        swap(arr, left, i);

        return i;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
        System.out.println("합병 정렬: " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7 ,1, 4, 6};
        heapSort(arr);
        System.out.println("힙 정렬: " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7 ,1, 4, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("퀵 정렬: " + Arrays.toString(arr));
    }
}