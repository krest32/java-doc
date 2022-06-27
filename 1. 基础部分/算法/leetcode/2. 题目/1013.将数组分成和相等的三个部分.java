import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1013 lang=java
 *
 * [1013] 将数组分成和相等的三个部分
 */

// @lc code=start
class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        // 模拟
        return extracted(arr);
    }

    private boolean extracted(int[] arr) {
        int s = Arrays.stream(arr).sum();
        // 如果和不为3的倍数，返回False
        if (s % 3 != 0)
            return false;
        int target = s / 3;
        int n = arr.length, i = 0, cur = 0;

        while (i < n) {
            cur += arr[i];
            if (cur == target) {
                break;
            }
            ++i;
        }

        if (cur != target)
            return false;
        int j = i + 1;

        // 需要满足最后一个数组非空
        while (j + 1 < n) {
            cur += arr[j];
            if (cur == target * 2) {
                return true;
            }
            j++;
        }
        return false;
    }
}
// @lc code=end
