/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        char[] sChar = s.toCharArray();
        int right = s.length() - 1;
        int left = 0;
        while (left < right) {
            while (left < right && !isVowels(sChar[left])) {
                left++;
            }
            while (left < right && !isVowels(sChar[right])) {
                right--;
            }
            swap(sChar, left, right);
            left++;
            right--;
        }
        return new String(sChar);
    }

    private void swap(char[] sChar, int left, int right) {
        char temp = sChar[left];
        sChar[left] = sChar[right];
        sChar[right] = temp;
    }

    private boolean isVowels(char c) {
        if (c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i'
                || c == 'A' || c == 'E' || c == 'O' || c == 'U' || c == 'I') {
            return true;
        }
        return false;
    }
}
// @lc code=end
