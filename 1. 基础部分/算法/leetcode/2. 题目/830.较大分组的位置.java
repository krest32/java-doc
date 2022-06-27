import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=830 lang=java
 *
 * [830] 较大分组的位置
 */

// @lc code=start
class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        return extracted(s);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 38.25 % of java submissions (41.4 MB)
     * 
     * @param s
     * @return
     */
    private List<List<Integer>> extracted(String s) {

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = s.length();
        int num = 1;
        // 所有包含大于或等于三个连续字符的分组为 较大分组,
        // 然后输出他们的起点和终点的坐标节点
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }
}
// @lc code=end
