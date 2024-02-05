// 알고리즘 - 이진 탐색

public class MyBinarySearch {
    // 방법1: 반복문 구조
    public static int binarySearch1(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else  {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 방법2: 재귀 호출 구조
    public static int binarySearch2(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (target == arr[mid]) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearch2(arr, target, left, mid - 1);
        } else {
            return binarySearch2(arr, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};

        System.out.println("Index: " + binarySearch1(arr, 30));
        System.out.println();
        System.out.println("Index: " + binarySearch2(arr, 30, 0, arr.length - 1));
    }
}