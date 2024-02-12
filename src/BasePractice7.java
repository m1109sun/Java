// Practice7
// 문제 설명
// 회문 또는 팰린드롬(pallindrome)은 앞 뒤 방향으로 같은 순서의 문자로 구성된 문자열을 말한다.
// 에시) 'abba', 'kayak', 'madam'

// 유사회문은 문자열 그 자체는 회문이 아니지만 한 문자를 삭제하면 회문이 되는 문자열을 말한다.
// 예시) 'summuus'의 5번째 또는 6번째 문자 'u'를 제거하면 'summus'인 회문을 만들 수 있다.

// 주어진 문자열을 확인한 후 문자열 종류에 따라 다음과 같이 출력하는 프로그램을 작성하세요.
// 회문: 0
// 유사회문: 1
// 기타: 2

// 입출력 예시
// 입력: abba -> 출력: 0
// 입력: summuus -> 출력: 1
// 입력: xabba -> 출력: 1
// 입력: xabbay -> 출력: 2
// 입력: comcom -> 출력: 2
// 입력: comwwmoc -> 출력: 0
// 입력: comwwtmoc -> 출력: 1

public class BasePractice7 {
    public static int solution(String str) {
        return isPalindrome(0, str.length() - 1, str.toCharArray(), 0);
    }

    public static int isPalindrome(int left, int right, char[] arr, int delCnt) {
        while (left < right) {
            if (arr[left] != arr[right]) {

                if (delCnt == 0) {
                    if (isPalindrome(left + 1, right, arr, 1) == 0 ||
                    isPalindrome(left, right - 1, arr, 1) == 0) {
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    return 2;
                }
            } else {
                left++;
                right--;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // Test code
        String[] str = {"abba", "summuus", "xabba", "xabbay", "comcom", "comwwmoc", "comwwtmoc"};
        System.out.println(solution("abba"));
        System.out.println(solution("summuus"));
        System.out.println(solution("xabba"));
        System.out.println(solution("xabbay"));
        System.out.println(solution("comcom"));
        System.out.println(solution("comwwmoc"));
        System.out.println(solution("comwwtmoc"));
    }
}