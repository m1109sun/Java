// Practice3
// 문제 설명
// 문자열 s1과 s2가 주어졌을 때,
// s1을 permutation한 문자열이 s2의 부분 문자열에 해당하면 true를 반환하고
// 그렇지 않으면 false를 반환하는 프로그램을 작성하세요.

// 입출력 예시
// s1: ab, s2: adbak -> 출력: true
// s1: ac, s2: car -> 출력: true
// s1: ak, s2: aabbkk -> 출력: false

import java.util.ArrayList;

public class BasePractice3 {
    // 1. 기본 permutation 방법
    public static boolean solution1(String s1, String s2) {
        boolean[] visited = new boolean[s1.length()];
        char[] out = new char[s1.length()];
        ArrayList<String> list = new ArrayList<>();
        permutation(s1.toCharArray(), 0, s1.length(), s1.length(), visited, out, list);

        for (String s: list) {
            if (s2.contains(s)) {
                return true;
            }
        }

        return false;
    }

    public static void permutation(char[] arr, int depth, int n, int r, boolean[] visited, char[] out, ArrayList<String> list) {
        if (depth == r) {
            list.add(new String(out));
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth + 1, n, r, visited, out, list);
                visited[i] = false;
            }
        }
    }

    // 2. 문제 규칙 찾아 해결
    public static boolean solution2(String s1, String s2) {
        final int ALPHABET = 26;

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] cnt = new int[ALPHABET];
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            cnt[s2.charAt(i) - 'a']--;

            if (i - s1.length() >= 0) {
                cnt[s2.charAt(i - s1.length()) - 'a']++;
            }

            boolean isZero = true;
            for (int j = 0; j < ALPHABET; j++) {
                if (cnt[j] != 0) {
                    isZero = false;
                    break;
                }
            }

            if (isZero) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test code
        String s1 = "ab";
        String s2 = "adbak";
        System.out.println(solution1(s1, s2));
        System.out.println(solution2(s1, s2));
        System.out.println();

        s1 = "ac";
        s2 = "car";
        System.out.println(solution1(s1, s2));
        System.out.println(solution2(s1, s2));
        System.out.println();

        s1 = "ak";
        s2 = "aabbkk";
        System.out.println(solution1(s1, s2));
        System.out.println(solution2(s1, s2));
        System.out.println();
    }
}