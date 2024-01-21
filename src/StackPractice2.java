// Practice2
// 괄호 짝 검사
// 문제 푸는 방법: "("가 들어오면 push, ")"가 들어오면 pop을 시킴!
// 결과적으로 stack에 아무것도 들어있지 않으면 괄호 짝이 잘 맞는 것이므로 Pass!

// 입출력 예시)
// 입력: "("
// 출력: FAIL!

// 입력: ")"
// 출력: FAIL!

// 입력: "()"
// 출력: PASS!

import java.util.Stack;
public class StackPractice2 {
    public static void checkParenthesis(String str) {
        Stack stack = new Stack();
        boolean checkFlag = true; // 괄호 짝이 맞는지 안맞는지 체크하는 변수로 사용

        for (String s: str.split("")) {
            if (s.equals("(")) {
                stack.push(s);
            } else {
                if (stack.isEmpty()) {
                    checkFlag = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (checkFlag && stack.isEmpty()) {
            System.out.println("PASS!");
        } else {
            System.out.println("FAIL!");
        }
    }

    public static void main(String[] args) {
        // Test code
        checkParenthesis("(");        // FAIL!
        checkParenthesis(")");        // FAIL!
        checkParenthesis("()");       // PASS!
        checkParenthesis("()()()");   // PASS!
        checkParenthesis("(())()");   // PASS!
        checkParenthesis("(((()))");  // FAIL!
    }
}
