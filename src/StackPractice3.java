// Practice3
// 후위표기법 연산
// 참고 설명) 전위/중위/후위 표기법
// 문제 푸는 방법: 연산자를 만나기 전까지의 숫자들을 stack에 넣어줌!
// 연산자를 만나면 stack에 들어있는 두 숫자를 pop하고 연산해줌!

// 입출력 예시)
// 입력: "2 2 +"
// 출력: 4

// 입력: "2 2 -"
// 출력: 0

import java.util.Stack;

public class StackPractice3 {
    public static double calculate(String string) {
        Stack<Double> stack = new Stack();

        for (String str: string.split(" ")) {
            if (str.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (str.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (str.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (str.equals("/")) {
                stack.push(1 / stack.pop() * stack.pop());
            } else {
                stack.push(Double.parseDouble(str));
            }
        }
        return stack.pop(); // 최종 결과 보여주기
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(calculate("2 2 +"));     // 4
        System.out.println(calculate("2 2 -"));     // 0
        System.out.println(calculate("2 2 *"));     // 4
        System.out.println(calculate("2 2 /"));     // 1

        System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -"));     // 1
        System.out.println(calculate("5 2 * 3 - 8 * 4 /"));         // 14
    }
}