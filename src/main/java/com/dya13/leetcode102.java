package com.dya13;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 层序遍历的本质是广度优先搜索（BFS），核心思想是利用队列实现逐层处理
 */
public class leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//头节点入队列也就是整个二叉树入队列
        while (!queue.isEmpty()) {
            int levelSize = queue.size();//返回改队列的元素数,刚开始就只有一个头结点是1，levelSizes是1
            List<Integer> currentLevel = new ArrayList<>();// 把它依次放到result里面
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();//出队列,它是出队列了，但是整个二叉树没有变，第一次while循环，到这里队列为空
                currentLevel.add(node.val);
                //左右节点入队列,所以这里node.left和node.right也是正常能够拿到左右节点
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }

            result.add(currentLevel);
        }
        Collections.reverse(result);
        return result;


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


}
