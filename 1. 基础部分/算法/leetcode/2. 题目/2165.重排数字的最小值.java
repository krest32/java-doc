/*
 * @lc app=leetcode.cn id=2165 lang=java
 *
 * [2165] 重排数字的最小值
 */

// @lc code=start
class Solution {
    public long smallestNumber(long num) {
        long temp = num;
        int[] cnt = new int[10];
        num = Math.abs(num);
        // 记录每个数字出现的次数
        while(num!=0){
            int n = (int) (num%10);
            cnt[n] ++;
            num /= 10;
        } 
        long ans = 0;
        if(temp>0){
            // 获取得到第一个数组，然后结束循环
            for(int i=1;i<10;i++){
                if(cnt[i]!=0){
                    ans = i;
                    cnt[i]--;
                    break;
                }
            }
            // 追加其余数字
            for(int i=0;i<10;i++){
                while(cnt[i]>0){
                    ans = ans*10 + i;
                    cnt[i]--;
                }
            }
        }else{
            // 处理负数的情况
            for(int i=9; i>=0; i--){
                while(cnt[i]>0){
                    ans = ans*10+i;
                    cnt[i]--;
                }
            }
            ans *= -1;
        }
        return ans;
    }
}
// @lc code=end
