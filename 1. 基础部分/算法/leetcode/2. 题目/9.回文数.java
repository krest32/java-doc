

/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        // string类 翻转字符串
        return extract1(x);
        
        // 双指针
        // return extract2(x);
    }

    /**
     * 
     * 首尾双指针
     * 
     * Your runtime beats 76.53 % of java submissions
     * Your memory usage beats 48.53 % of java submissions (40.3 MB)
     * 
     * @param x
     * @return
     */
    boolean extract2(int x) {
        // 方法二： 首尾双指针,截取逐个字符进行比对
        String orginStr = String.valueOf(x);
        int left = 0, right = orginStr.length() - 1;
        while (left < right) {
            if (orginStr.charAt(left) != orginStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 
     * 利用 string 方法处理，但性能比较低
     * 
     * Your runtime beats 31.62 % of java submissions
     * Your memory usage beats 5.05 % of java submissions (41.2 MB)
     * 
     * @param x
     * @return
     */
    boolean extract1(int x) {
        // 方法一： 使用String工具类
        StringBuilder originStr = new StringBuilder(String.valueOf(x));
        String revStr = originStr.reverse().toString();
        return String.valueOf(x).equals(revStr);
    }

}
// @lc code=end
