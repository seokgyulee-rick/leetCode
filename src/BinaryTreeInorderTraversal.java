import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public static void main(String[] args) {
          pro();
    }

    static void pro(){
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2, three, null);
        TreeNode root = new TreeNode(1, null, two);
        inorderTraversal(root);
    }
    static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        printRecurse(root, list);
        System.out.println(list.toString());
        return list;
    }
    static void printRecurse (TreeNode currentNode,  List<Integer> list){
          if(currentNode ==  null) return;

          printRecurse(currentNode.left, list);

          list.add(currentNode.val);

          printRecurse(currentNode.right,list);
    }
}

/**
 * solution
 *
 * class Solution {
 *     public List<Integer> inorderTraversal(TreeNode root) {
 *         List<Integer> result = new ArrayList<>();
 *         tree(root, result);
 *         return (result);
 *     }
 *
 *     public void tree(TreeNode root, List<Integer> result) {
 *         if (root == null) {
 *             return;
 *         }
 *         tree(root.left, result);
 *         result.add(root.val);
 *         tree(root.right, result);
 *     }
 * }
 */