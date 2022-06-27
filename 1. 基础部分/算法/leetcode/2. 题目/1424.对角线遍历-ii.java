import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1424 lang=java
 *
 * [1424] 对角线遍历 II
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // 模拟
        return extracted(nums);
    }

    /**
     * 56/56 cases passed (21 ms)
     * Your runtime beats 94.14 % of java submissions
     * Your memory usage beats 37.59 % of java submissions (68.5 MB)
     * 
     * @param nums
     * @return
     */
    private int[] extracted(List<List<Integer>> nums) {
        List<int[]> list = new ArrayList<int[]>();
        int rows = nums.size();
        for (int i = 0; i < rows; i++) {
            List<Integer> rowList = nums.get(i);
            int cols = rowList.size();
            for (int j = 0; j < cols; j++) {
                int num = rowList.get(j);
                list.add(new int[] { i + j, j, num });
            }
        }
        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        int size = list.size();
        int[] order = new int[size];
        for (int i = 0; i < size; i++) {
            order[i] = list.get(i)[2];
        }
        return order;
    }
}
// @lc code=end
