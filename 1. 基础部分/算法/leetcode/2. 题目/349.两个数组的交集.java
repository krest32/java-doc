import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        // 哈希
        // return extracted(nums1, nums2);

        // 哈希 -> 最优解
        return extracted2(nums1, nums2);

    }

    private int[] extracted2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        // 遍历 nums1
        for (int i : nums1) {
            set1.add(i);
        }
        // 遍历nums2，判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        int[] resArr = new int[resSet.size()];
        int index = 0;
        for (int i : resSet) {
            resArr[index++] = i;
        }
        return resArr;
    }

    private int[] extracted(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 < len2) {
            return getArr(nums2, nums1);
        } else {
            return getArr(nums1, nums2);
        }
    }

    private int[] getArr(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < len1; i++) {
            set.add(nums1[i]);
        }
        for (int j = 0; j < len2; j++) {
            if (set.contains(nums2[j]) && !list.contains(nums2[j])) {
                list.add(nums2[j]);
            }
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}
// @lc code=end
