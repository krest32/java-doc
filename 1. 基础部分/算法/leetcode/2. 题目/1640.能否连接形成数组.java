/*
 * @lc app=leetcode.cn id=1640 lang=java
 *
 * [1640] 能否连接形成数组
 */

// @lc code=start
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // 数组计数
        return method(arr, pieces);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 39.91 % of java submissions (40.8 MB)
     * 
     * @param arr
     * @param pieces
     * @return
     */
    boolean method(int[] arr, int[][] pieces) {
        int[] indexs = new int[101];
        Arrays.fill(indexs, -1);
        // 记录数组中每个元素的位置
        for (int i = 0; i < arr.length; i++) {
            indexs[arr[i]] = i;
        }
        for (int i = 0; i < pieces.length; i++) {
            // 这里就分为两种情况讨论，
            // 第一种，pieces[i].length>1，这种查看元素间的顺序是否严格对应arr的顺序
            if (pieces[i].length > 1) {
                for (int j = 1; j < pieces[i].length; j++) {
                    // 判段元素是否在arr中出现
                    if (indexs[pieces[i][j]] == -1 || indexs[pieces[i][j - 1]] == -1) {
                        return false;
                    }
                    // 判断相邻坐标的元素是否是连续的
                    if (indexs[pieces[i][j]] - indexs[pieces[i][j - 1]] != 1) {
                        return false;
                    }
                }
            } else {
                // 第二种，pieces[i].length=1，这种查看元素是否存在arr中
                if (indexs[pieces[i][0]] == -1) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
