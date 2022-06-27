import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] 为运算表达式设计优先级
 */

// @lc code=start
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        // 分治
        return extracted2(expression);
    }

    private List<Integer> extracted2(String expression) {
        List<Integer> ways = new ArrayList<>();
        int len = expression.length();
        for (int i = 0; i < len; i++) {
            char way = expression.charAt(i);
            if (way == '+' || way == '-' || way == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                extracted(ways, way, left, right);
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(expression));
        }
        return ways;
    }

    private void extracted(List<Integer> ways,
            char way,
            List<Integer> left,
            List<Integer> right) {
        for (int l : left) {
            for (int r : right) {
                switch (way) {
                    case '+':
                        ways.add(l + r);
                        break;
                    case '-':
                        ways.add(l - r);
                        break;
                    case '*':
                        ways.add(l * r);
                        break;
                }
            }
        }
    }
}
// @lc code=end
