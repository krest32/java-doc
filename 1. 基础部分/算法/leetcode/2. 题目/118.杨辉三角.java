import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {

        // 解法一 迭代打印
        // return extracted(numRows);

        // 1
        return test(numRows);
    }

    private List<List<Integer>> test(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(row);
        }
        return ans;
    }

    /**
     * 数学模拟，迭代打印
     * 
     * @param numRows
     * @return
     */
    private List<List<Integer>> extracted(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        // 遍历每一行
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            // 遍历每一行中的每一个元素
            for (int j = 0; j <= i; ++j) {
                // 元素属于杨辉三角的边界，直接赋值1
                if (j == 0 || j == i) {
                    row.add(1);
                    // 否则就拿到上一行，临近左右的元素想加
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
// @lc code=end
