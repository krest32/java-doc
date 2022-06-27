import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        int ans=0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num=entry.getKey();
            int occ= entry.getValue();
            if (occ==1){
                ans=num;
                break;
            }
        }
        return ans;
    }
}
// @lc code=end

