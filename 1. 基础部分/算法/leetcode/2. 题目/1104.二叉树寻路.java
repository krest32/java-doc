import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1104 lang=java
 *
 * [1104] 二叉树寻路
 */

// @lc code=start
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        // 数学
        // return extracted(label);

        // 模拟
        return extracted2(label);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 57.95 % of java submissions (38.6 MB)
     * 
     * @param label
     * @return
     */
    private List<Integer> extracted2(int label) {
        int row = 1, rowStart = 1;
        while (rowStart * 2 <= label) {
            row++;
            rowStart *= 2;
        }
        if (row % 2 == 0) {
            label = getReverse(label, row);
        }
        List<Integer> path = new ArrayList<Integer>();
        while (row > 0) {
            if (row % 2 == 0) {
                path.add(getReverse(label, row));
            } else {
                path.add(label);
            }
            row--;
            label >>= 1;
        }
        Collections.reverse(path);
        return path;
    }

    public int getReverse(int label, int row) {
        return (1 << row - 1) + (1 << row) - 1 - label;

    }

    private List<Integer> extracted(int n) {
        int level = 1;
        // 获取层数
        while (getEnd(level) < n)
            level++;
        int[] ans = new int[level];
        int idx = level - 1, cur = n;
        while (idx >= 0) {
            ans[idx--] = cur;
            int loc = ((1 << (level)) - 1 - cur) >> 1;
            cur = (1 << (level - 2)) + loc;
            level--;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : ans)
            list.add(i);
        return list;
    }

    int getStart(int level) {
        return (int) Math.pow(2, level - 1);
    }

    int getEnd(int level) {
        int a = getStart(level);
        return a + a - 1;
    }
}
// @lc code=end
