package tree.Traversal;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 二叉树层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res =  new ArrayList<List<Integer>>();
        if(root ==null){
            return   res;
        }
        Queue<TreeNode> queue  = new LinkedList<TreeNode>();
        // offer 更好，但在这里一样。容量无限
        queue.add(root);
        while (!queue.isEmpty()){
            // 这里也算一个小点。
            int levelNum = queue.size();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                temp.add(queue.poll().val);
            }
            res.add(temp);
        }

          return res;


    }
}
