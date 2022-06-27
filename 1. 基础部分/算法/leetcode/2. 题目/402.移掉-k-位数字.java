import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉 K 位数字
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        // 双端队列
        // return extracted(num, k);

        // 1
        return extracted2(num, k);
    }

    private String extracted2(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char tempNum = num.charAt(i);
            while (!deque.isEmpty() && deque.peekLast() > tempNum
                    && k > 0) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(tempNum);
        }

        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean flag = true;
        while (!deque.isEmpty()) {
            char ch = deque.pollFirst();
            if (flag && ch == '0') {
                continue;
            }
            flag = false;
            ret.append(ch);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }

    private String extracted(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            // 当遇到下一个字符比队列中的字符大的时候，就移除当前队列中的字符
            while (!deque.isEmpty() && k > 0
                    && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        // 如果 K!=0,移除尾巴的元素
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
// @lc code=end
