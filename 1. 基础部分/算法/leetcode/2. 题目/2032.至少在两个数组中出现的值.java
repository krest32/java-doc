
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2032 lang=java
 *
 * [2032] 至少在两个数组中出现的值
 */

// @lc code=start
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        /**
         * 用100个int记录每个可能出现的数字的状态，每个数字的状态按如下编码：
         * 
         * 0：不出现
         * 1：在nums1中出现
         * 2：在nums2中出现
         * 3：在nums3中出现
         * 4：在nums1、2中出现
         * 5：在nums1、3中出现
         * 6：在nums2、3中出现
         * 大于7：在nums1、2、3中出现
         * 
         */

        List<Integer> res = new ArrayList<>();
        int[] caches = new int[101];
        for (int x : nums1) {
            caches[x] = 1;
        }
        for (int x : nums2) {
            if (caches[x] <= 1) {
                caches[x] += 1;
                // 如果==1 ，便是只在数组2出现过
                caches[x] *= 2;
                // 便是x在两个数组中出现过
                if (caches[x] == 4) {
                    res.add(x);
                }
            }
        }

        for (int x : nums3) {
            if (caches[x] == 1 || caches[x] == 2) {
                caches[x] += 4;
                res.add(x);
            }
        }
        return res;
    }
}
// @lc code=end
