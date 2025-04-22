package Java.dya13;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetocde199 {
    /**
     * 层序遍历找出每一层最右边的节点
     * 核心目标：找到每层最右侧的节点。
     * 深度优先遍历的话，如何判断它是最右侧节点呢？这是关键
     * 关键：for循环遍历的时候，如果i==这一行节点最后一个索引，也就是levelSize-1
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {//它
            return result;
        }
        queue.offer(root);

        while (!queue.isEmpty()) { //每个while循环是一行
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 处理当前节点，本题区别在这个地方
                if (i==size-1){
                    result.add(node.val);
                }
                // 2. 扩展子节点
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }
        }
        return result;

    }

    class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val,  TreeNode left,  TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
