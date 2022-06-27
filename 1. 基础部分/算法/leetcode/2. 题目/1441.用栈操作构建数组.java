import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1441 lang=java
 *
 * [1441] 用栈操作构建数组
 */

// @lc code=start
class Solution {
    
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 0, num = 1; i < target.length; i++, num++) {
            result.add("Push");
            if (target[i] != num) {
                result.add("Pop");
                i--;
            }
        }
        return result;
    }
}
// @lc code=end

