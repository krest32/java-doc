import java.util.ArrayList;
import java.util.List;

import javax.swing.border.Border;

/*
 * @lc app=leetcode.cn id=1054 lang=java
 *
 * [1054] 距离相等的条形码
 */

// @lc code=start
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        int[] cnt = new int[10001];
        for (int barcode : barcodes) {
            cnt[barcode]++;
        }
        List<Integer> items = new ArrayList<>();
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] != 0) {
                items.add(i);
            }
        }
        items.sort((o1, o2) -> cnt[o2] - cnt[o1]);

        int[] cur = new int[n];
        int j = 0;
        for (int item : items) {
            for (int i = 0; i < cnt[item]; i++) {
                cur[j++] = item;
            }
        }

        int[] res = new int[n];
        j = 0;
        for (int i = 0; i < n; i += 2) {
            res[i] = cur[j++];
        }
        for (int i = 1; i < n; i += 2) {
            res[i] = cur[j++];
        }
        return res;
    }
}
// @lc code=end
