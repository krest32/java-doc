/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 方法一： 横向扫描
        // return extracted1(strs);

        // 方法二： 纵向扫描
        // return extracted2(strs);

        // 方法三： 分治，速度最佳
        return extracted3(strs);

        // 方法四： 双指针，速度最慢：因为针对数组进行了多次的遍历
        // return extracted(strs);
    }

    /**
     * 双指针
     * 
     * Your runtime beats 20.38 % of java submissions
     * Your memory usage beats 41.53 % of java submissions (39.1 MB)
     * 
     * @param strs
     * @return
     */
    private String extracted(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        // 获取最短字符串长度
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        // 查找居中的字符，是否属于公共字符串的其中之一
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 分治
     * 可以先亮亮求取公共前缀，然后对于得出的公共前缀在进行求其公共前缀
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 23.9 % of java submissions (39.4 MB)
     * 
     * @param strs
     * @return
     */
    private String extracted3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            // 进行问题的拆分
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            // 结果进行组合
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);

    }

    /**
     * 
     * 纵向扫描
     * 速度与横向扫描差不多，但是空间上效率提升
     * 
     * Your runtime beats 68.93 % of java submissions
     * Your memory usage beats 46.89 % of java submissions (39 MB)
     * 
     * @param strs
     * @return
     */
    private String extracted2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 
     * 横向扫描
     * Your runtime beats 68.93 % of java submissions
     * Your memory usage beats 26.29 % of java submissions (39.3 MB)
     * 
     * @param strs
     * @return
     */
    private String extracted1(String[] strs) {
        if (strs.length == 0)
            return null;
        String indexStr = strs[0];
        // 抽取数组的第一个String，对于字符进行逐个遍历
        for (int i = 0; i < indexStr.length(); i++) {
            char tempCh = indexStr.charAt(i);
            int j = 0;
            // 判断 [当前字符] 与 [数组中其他每个String 同位置的字符] 是否相等
            while (j < strs.length) {
                if (i < strs[j].length() && strs[j].charAt(i) == tempCh) {
                    j++;
                } else {
                    // 如果不满足字符相同条件，直接返回截取的字符即可
                    return indexStr.substring(0, i);
                }
            }
        }
        return indexStr;
    }
}
// @lc code=end
