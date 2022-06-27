import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.xml.bind.ValidationEvent;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> occ = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            occ.put(nums[i], occ.getOrDefault(nums[i],0)+1);
        }
        List<int[]> occList = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:occ.entrySet()){
            int key = entry.getKey();
            int count = entry.getValue();
            occList.add(new int[]{key,count});
        }
        int[] ret = new int[k];
        qsort(occList,0,occList.size()-1,ret,0,k);
        return ret;
    }

    private void qsort(List<int[]> occList, int start, int end, int[] ret, int retIndex, int k) {
        // 获取第一个次数的基准数字
        int piovt = occList.get(start)[1];
        int index = start;
        for(int i=start+1; i<=end; i++){
            if(occList.get(i)[1]>=piovt){
                Collections.swap(occList, i, index+1);
                index++;
            }
        }
        Collections.swap(occList, start, index);
        if(k <= index-start){
            qsort(occList, start, index-1, ret,retIndex,k);
        }else{
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = occList.get(i)[0];
            }
            if(k > index - start + 1){
                qsort(occList, index+1, end, ret, retIndex, k-(index-start+1));
            }
        }

    }

}
// @lc code=end

