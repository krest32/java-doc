/*
 * @lc app=leetcode.cn id=1541 lang=java
 *
 * [1541] 平衡括号字符串的最少插入次数
 */

// @lc code=start
class Solution {
    public int minInsertions(String s) {
        // 模拟
        return extracted(s);
    }

    private int extracted(String s) {
        int insertIndex = 0;
        int leftCount = 0;
        int len = s.length();
        int index = 0;
        while (index < len) {
            char ch = s.charAt(index);
            if (ch == '(') {
                leftCount++;
                index++;
            } else {
                // 判断第一个反向括号
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    insertIndex++;
                }

                // 判断是否存在第二个反向括号
                if (index < len - 1 && s.charAt(index + 1) == ')') {
                    index += 2;
                } else {
                    insertIndex++;
                    index++;
                }
            }
        }
        insertIndex += leftCount * 2;
        return insertIndex;
    }
}
// @lc code=end
