import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    // 获取杨辉三角中的某一行
    public List<Integer> getRow(int rowIndex) {
        // 解法一 列出所有
        return extracted(rowIndex);

        // 解法二 优化了空间结构，但是速度没有提升
        // return extracted2(rowIndex);

        // 解法三 线性递推 --> 最优解法
        // return extracted3(rowIndex);

    }

    /**
     * 线性对推，根据一个公式，可以推导出任意一行的数据
     * 
     * index : 表示第几行
     * dp[0] = 0;
     * dp[i] = dp[i-1]*(index-i+1)/i;
     * 
     * @param rowIndex
     * @return
     */
    private List<Integer> extracted3(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            // 比如 rowIndex = 5
            // i = 1，ans = 1*(5-1+1)/1 = 5,
            // i = 2, ans = 5*(5-2+1)/2 = 10,
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }

        return row;
    }

    /**
     * 优化解法一
     * 
     * @param rowIndex
     * @return
     */
    private List<Integer> extracted2(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

    /**
     * 数学模拟，迭代出所有行
     * 
     * Your runtime beats 77.39 % of java submissions
     * Your memory usage beats 6.35 % of java submissions (39.3 MB)
     * 
     * @param rowIndex
     * @return
     */
    private List<Integer> extracted(int rowIndex) {
        List<List<Integer>> C = new ArrayList<List<Integer>>();
        // 计算杨辉三角
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(C.get(i - 1).get(j - 1) + C.get(i - 1).get(j));
                }
            }
            C.add(row);
        }
        return C.get(rowIndex);
    }
}
// @lc code=end
