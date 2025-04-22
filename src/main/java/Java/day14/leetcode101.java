package Java.day14;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            // 两节点都为空 → 继续下一轮
            if (node1 == null && node2 == null) continue;
            // 一个为空，另一个不为空 → 不对称
            if (node1 == null || node2 == null) return false;
            // 值不等 → 不对称
            if (node1.val != node2.val) return false;

            // 按镜像顺序入队
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}