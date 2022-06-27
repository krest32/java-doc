import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @lc app=leetcode.cn id=207 lang=java
 *
 *     [207] 课程表
 */

// @lc code=start
class Solution {
    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 初始化数据结构，注意prerequisites.length == numCourses;
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            // 代表学这门课程之后，可以学习的其他课程
            edges.get(info[1]).add(info[0]);
            // 记录课程需要学习几次
            indeg[info[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // 如果该课程需要提前学习的次数为0，可以提前被学习
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            // 已经学习过得课程数量
            visited++;
            int u = queue.poll();
            for (int v : edges.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }
}
// @lc code=end
