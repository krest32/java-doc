import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1980 lang=java
 *
 * [1980] 找出不同的二进制字符串
 */

// @lc code=start
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int len = nums[0].length();
        Set<String> set = new HashSet<>();
        // 对数组的内容进行一次去重
        for(String num : nums){
            set.add(num);
        }

        for(int i=0; i<Math.pow(2,len); i++){
            StringBuilder tempSB = new StringBuilder();
            int num = i;
            for(int j=0; j<len; j++){
                if((num & 1 )== 1){
                    tempSB.append(1);
                }else{
                    tempSB.append(0);
                }
                num>>=1;
            }
            if(!set.contains(tempSB.toString())){
                return tempSB.toString();
            }
        }
        return null;

    }
}
// @lc code=end

