import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=905 lang=java
 *
 * [905] 按奇偶排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParity(int[] A) {
        // 排序
        // return extracted(A);

        // 双指针
        return extracted2(A);

    }

    /**
     * Your runtime beats 82.81 % of java submissions
     * Your memory usage beats 37.24 % of java submissions (42 MB)
     * 
     * @param A
     * @return
     */
    private int[] extracted2(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0)
                i++;
            if (A[j] % 2 == 1)
                j--;
        }

        return A;
    }

    /**
     * Your runtime beats 10.3 % of java submissions
     * Your memory usage beats 41.99 % of java submissions (42 MB)
     * 
     * @param A
     * @return
     */
    private int[] extracted(int[] A) {
        Integer[] B = new Integer[A.length];
        for (int t = 0; t < A.length; ++t)
            B[t] = A[t];

        // 根据对2的余数进行排序
        Arrays.sort(B, (a, b) -> Integer.compare(a % 2, b % 2));

        for (int t = 0; t < A.length; ++t)
            A[t] = B[t];
        return A;
    }
}
// @lc code=end
