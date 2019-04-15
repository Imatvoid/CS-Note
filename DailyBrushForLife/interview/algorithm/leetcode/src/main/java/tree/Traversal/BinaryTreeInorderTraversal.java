package tree.Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        inorderTraversal(res,root);

        return  res;
    }

    void inorderTraversal(List<Integer> res,TreeNode root){
        if(root == null){
            return;
        }
        inorderTraversal(res,root.left);
        res.add(Integer.valueOf(root.val));
        inorderTraversal(res,root.right);
    }


    /**
     * 非递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            // cur 不为null的情况
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            // stack
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rr  = new TreeNode(2);
        rr.left = new TreeNode(3);
        root.right =rr;
        new BinaryTreeInorderTraversal().inorderTraversal2(root);

    }
}
