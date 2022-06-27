
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=720 lang=java
 *
 * [720] 词典中最长的单词
 */

// @lc code=start
class Solution {
    public String longestWord(String[] words) {
        // 暴力
        // return extracted(words);

        // 前缀树
        return extracted2(words);
    }

    private String extracted2(String[] words) {
        Trie trie = new Trie();
        int index = 0;
        // 构建前缀树
        for (String word : words) {
            trie.insert(word, ++index); // indexed by 1
        }
        trie.words = words;
        return trie.dfs();
    }

    // 字符N叉树
    class Node {
        char c;
        HashMap<Character, Node> children = new HashMap<>();
        int end;

        public Node(char c) {
            this.c = c;
        }
    }

    class Trie {
        Node root;
        String[] words;

        public Trie() {
            root = new Node('0');
        }

        public void insert(String word, int index) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new Node(c));
                cur = cur.children.get(c);
            }
            cur.end = index;
        }

        public String dfs() {
            String ans = "";
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.empty()) {
                Node node = stack.pop();
                if (node.end > 0 || node == root) {
                    if (node != root) {
                        String word = words[node.end - 1];
                        if (word.length() > ans.length() ||
                                word.length() == ans.length() && word.compareTo(ans) < 0) {
                            ans = word;
                        }
                    }
                    for (Node nei : node.children.values()) {
                        stack.push(nei);
                    }
                }
            }
            return ans;
        }

    }

    /**
     * Your runtime beats 87.31 % of java submissions
     * Your memory usage beats 42.6 % of java submissions (41.1 MB)
     * 
     * @param words
     * @return
     */
    private String extracted(String[] words) {
        String ans = "";
        Set<String> wordset = new HashSet<>();
        for (String word : words)
            wordset.add(word);
        for (String word : words) {
            if (word.length() > ans.length() ||
                    (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                boolean good = true;

                for (int k = 1; k < word.length(); ++k) {
                    if (!wordset.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
                if (good)
                    ans = word;
            }
        }
        return ans;
    }
}

// @lc code=end
