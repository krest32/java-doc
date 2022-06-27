/*
 * @lc app=leetcode.cn id=670 lang=java
 *
 * [670] 最大交换
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        // 另类的贪心算法
        // return extracted(num);

        // 暴力
        return extracted2(num);
    }

    /**
     * Your runtime beats 33.64 % of java submissions
     * Your memory usage beats 41.19 % of java submissions (38.3 MB)
     * 
     * @param num
     * @return
     */
    private int extracted2(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        char[] charArray = s.toCharArray();
        int max = num;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                swap(charArray, i, j);
                max = Math.max(max, Integer.parseInt(new String(charArray)));
                swap(charArray, i, j);
            }
        }
        return max;
    }

    private int extracted(int num) {
        String s = String.valueOf(num);
        int[] last = new int[10];
        int len = s.length();

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            last[arr[i] - '0'] = i;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 9; j > arr[i] - '0'; j--) {
                if (last[j] > i) {
                    swap(arr, i, last[j]);
                    return Integer.parseInt(new String(arr));
                }
            }
        }
        return num;
    }

    private void swap(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }
}
// @lc code=end
