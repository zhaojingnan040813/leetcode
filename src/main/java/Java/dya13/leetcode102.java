package Java.dya13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 层序遍历的本质是广度优先搜索（BFS），核心思想是利用队列实现逐层处理
 * offer 是入队列， poll 是出队列
 */
public class leetcode102 {
    public static void main(String[] args) {
        leetcode102 solution = new leetcode102();

        // 测试用例1：空树
        System.out.println("测试用例1 - 空树:");
        List<List<Integer>> result1 = solution.levelOrder(null);
        System.out.println(result1); // 预期输出: []

        // 测试用例2：单节点树
        System.out.println("\n测试用例2 - 单节点树 (根值为1):");
        TreeNode root2 = new TreeNode(1);
        List<List<Integer>> result2 = solution.levelOrder(root2);
        System.out.println(result2); // 预期输出: [[1]]

        // 测试用例3：完全二叉树
        System.out.println("\n测试用例3 - 完全二叉树:");
        TreeNode root3 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        List<List<Integer>> result3 = solution.levelOrder(root3);
        System.out.println(result3); // 预期输出: [[3], [9, 20], [15, 7]]

        // 测试用例4：不平衡树（左斜树）
        System.out.println("\n测试用例4 - 左斜树:");
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        root4.left.left.left = new TreeNode(4);
        List<List<Integer>> result4 = solution.levelOrder(root4);
        System.out.println(result4); // 预期输出: [[1], [2], [3], [4]]

        // 测试用例5：右斜树
        System.out.println("\n测试用例5 - 右斜树:");
        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(2);
        root5.right.right = new TreeNode(3);
        root5.right.right.right = new TreeNode(4);
        List<List<Integer>> result5 = solution.levelOrder(root5);
        System.out.println(result5); // 预期输出: [[1], [2], [3], [4]]
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//  入队列
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }


            res.add(list);


        }


        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
