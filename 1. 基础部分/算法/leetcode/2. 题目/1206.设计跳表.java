
/*
 * @lc app=leetcode.cn id=1206 lang=java
 *
 * [1206] 设计跳表
 */

// @lc code=start
class Skiplist {
    // 跳表最大层数
    static int DEFAULT_MAX_LEAVEL = 32;
    static double DEFAULT_P_FACTOR = 0.25;
    // 定义初始链表
    Node head = new Node(null, DEFAULT_MAX_LEAVEL);
    // 记录当前的层数和位置
    int currentLevel = 1;

    public Skiplist() {
    }

    /**
     * *查找某个元素是否存在
     * 1. 从列表的当前层开始向下遍历
     */
    public boolean search(int target) {
        Node searchNode = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            // 当前层能否找到target元素
            searchNode = findCloseat(searchNode, i, target);
            //
            if (searchNode.next[i] != null && searchNode.next[i].value == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断在当前层找到target元素相同节点
     */
    private Skiplist.Node findCloseat(Skiplist.Node node, int LevelIndex, int value) {
        while ((node.next[LevelIndex]) != null && value > node.next[LevelIndex].value) {
            node = node.next[LevelIndex];
        }
        return node;
    }

    /**
     * * 追加新的元素
     */
    public void add(int num) {
        int level = randomLevel();
        Node updateNode = head;
        Node newNode = new Node(num, level);
        for (int i = currentLevel - 1; i >= 0; i--) {
            updateNode = findCloseat(updateNode, i, num);
            if (i < level) {
                if (updateNode.next[i] == null) {
                    updateNode.next[i] = newNode;
                } else {
                    Node temp = updateNode.next[i];
                    updateNode.next[i] = newNode;
                    newNode.next[i] = temp;
                }
            }
        }
        if (level > currentLevel) {
            for (int i = currentLevel; i < level; i++) {
                head.next[i] = newNode;
            }
            currentLevel = level;
        }
    }

    /**
     * 随机层
     */
    private static int randomLevel() {
        int level = 1;
        while (Math.random() < DEFAULT_P_FACTOR && level < DEFAULT_MAX_LEAVEL) {
            level++;
        }
        return level;
    }

    public boolean erase(int num) {
        boolean flag = false;
        Node searchNode = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            searchNode = findCloseat(searchNode, i, num);
            if (searchNode.next[i] != null && searchNode.next[i].value == num) {
                // 找到该层中该节点
                searchNode.next[i] = searchNode.next[i].next[i];
                flag = true;
                continue;
            }
        }
        return flag;
    }

    // 定义node 基本结构
    class Node {
        Integer value;
        // 节点数组
        Node[] next;

        public Node(Integer value, int size) {
            this.value = value;
            this.next = new Node[size];
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
// @lc code=end
