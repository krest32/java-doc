import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 螺旋打印矩阵
        return extracted(matrix);

    }

    private List<Integer> extracted(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            for (int i = left; i <= right; i++)
                res.add(matrix[top][i]);
            top++;
            if (top > bottom)
                break;

            for (int i = top; i <= bottom; i++)
                res.add(matrix[i][right]);
            right--;
            if (right < left)
                break;

            for (int i = right; i >= left; i--)
                res.add(matrix[bottom][i]);
            bottom--;
            if (bottom < top)
                break;

            for (int i = bottom; i >= top; i--)
                res.add(matrix[i][left]);
            left++;
            if (left > right)
                break;
        }
        return res;
    }
}
// @lc code=end
