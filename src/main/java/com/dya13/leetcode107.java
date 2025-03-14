package com.dya13;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class leetcode107 {

    /**
     * 我直接把 leetcode102 哪一题得到的result结果数组结果反转一下就可以了吗？
     * 按照这个思路，应该怎么写  调用 Collections.reverse()反转列表顺序
     *
     * @param root
     * @return 这种方法会超时
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();//这是集合，要用 Collections而不是Arrays
        if (root == null) {
            return result; //返回空数组而不是Null
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();// 获取当前层节点数
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                    res.add(node.val);


                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(res);
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


}
