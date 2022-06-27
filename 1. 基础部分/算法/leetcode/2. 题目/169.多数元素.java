import java.util.Arrays;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        // 排序，查找中位元素
        // return extracted(nums);

        // 分治 -->优
        return majorityElementRec(nums, 0, nums.length - 1);

        // 随机化
        // Random rand = new Random();
        // int majorityCount = nums.length / 2;
        // while (true) {
        // int candidate = nums[randRange(rand, 0, nums.length)];
        // if (countOccurences(nums, candidate) > majorityCount) {
        // return candidate;
        // }
        // }

    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    /**
     * 分治
     * 
     * 将数组分成左右两部分，分别求出左半部分的众数 a1
     * 以及右半部分的众数 a2，
     * 随后在 a1 和 a2 中选出正确的众数。
     * 
     * Your runtime beats 99.89 % of java submissions
     * Your memory usage beats 54.16 % of java submissions (44.5 MB)
     * 
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    private int majorityElementRec(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }

        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);
        // 进行剪枝，如果两个数字一致，就不同统计数量进行对比了
        if (left == right) {
            return left;
        }
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount >= rightCount ? left : right;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    /**
     * 排序
     * 
     * Your runtime beats 59.53 % of java submissions
     * Your memory usage beats 69.8 % of java submissions (44.3 MB)
     */
    private int extracted(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;
        return nums[(left + right) / 2];
    }
}
// @lc code=end
