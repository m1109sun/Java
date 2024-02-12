// Practice8
// 문제 설명
// 주어진 1차 방정식에 대해 풀이를 하는 프로그램을 작성하세요.
// 해당 방정식은 '+','-','x'와 '상수'로만 이루어져 있다.
// 해가 없으면 "No solution"을 출력,
// 해가 무한대인 경우 "Infinite solutions"를 출력,
// 해가 있는 경우 x의 값을 "x=" 형태로 출력하세요.

// 입출력 예시
// 입력: x+5-3+x=6+x-2 -> 출력: x=2
// 입력: x=x -> 출력: Infinite solutions
// 입력: 2x=x -> 출력: x=0

public class BasePractice8 {
    public static String solution(String equation) {
        String[] parts = equation.split("=");
        int[] leftSide = evaluate1(parts[0]);
        int[] rightSide = evaluate1(parts[1]);

        if (leftSide[0] == rightSide[0] && leftSide[1] == rightSide[1]) {
            return "Infinite solutions";
        } else if (leftSide[0] == rightSide[0]) {
            return "No solution";
        } else {
            return "x=" + (rightSide[1] - leftSide[1]) / (leftSide[0] - rightSide[0]);
        }
    }

    public static int[] evaluate1(String str) {
        int[] result = new int[2];

        boolean isMinus = false;
        int idx = 0;
        while (idx != str.length()) {
            char c = str.charAt(idx++);

            if (c == '+') {
                continue;
            }

            if (c == '-') {
                isMinus = true;
                continue;
            }

            if (c == 'x') {
                result[0] += isMinus ? -1 : 1;
            } else {
                if (idx < str.length() && str.charAt(idx) == 'x') {
                    result[0] += isMinus ? -(c - '0') : (c - '0');
                } else {
                    result[1] += isMinus ? -(c - '0') : (c - '0');
                }
            }
            isMinus = false;
        }
        return result;
    }

    // 새로운 방법 풀이
    public static int[] evaluate2(String str) {
        int[] result = new int[2];

        // 더하기/빼기 split 하는 정규식
        for (String s : str.split("(?=[+-])")) {
            if (s.equals("+x") || s.equals("x")) {
                result[0]++;
            } else if (s.equals("-x")) {
                result[0]--;
            } else if (s.contains("x")) {
                result[0] += Integer.parseInt(s.substring(0, s.length() - 1));
            } else {
                result[1] += Integer.parseInt(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        String equation = "x+5-3+x=6+x-2";
        System.out.println(solution(equation));

        equation = "x=x";
        System.out.println(solution(equation));

        equation = "2x=x";
        System.out.println(solution(equation));
    }
}