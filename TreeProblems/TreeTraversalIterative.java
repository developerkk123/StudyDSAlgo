package TreeProblems;

import java.util.*;

public class TreeTraversalIterative {
    public static void postorder(TreeNode root){
        /*
         * Logic remember P-L-R
         * print root -> go left -> go right
         * edge case : if root are null return
         */
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value +" ");
    }
    public static void inOrderIter(TreeNode root){
        /*
         * Time complexity is O(n)
         * Space complexity is O(n)
         */
        // base case 
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null || stack.size() > 0){
            // go till left
            while(curr != null){
                stack.add(curr);
                curr = curr.left;
            }
            // here curr is null so take out from stack and print
            curr = stack.pop();
            System.out.print(curr.value+" ");

            // left part is done now move to right to get inorder 
            curr = curr.right;
        }
    }
    public static void preorderIter(TreeNode root){
        //TreeNode curr = root;
        /*
         * Data structure: Use stack
         * Step 1: First push root
         * Step 2: pop from stack and print 
         * Step 3: push first right 
         * Step 4: push left
         * 
         */

         // base case
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty() ){
            TreeNode curr = stack.pop();
            System.out.print(curr.value +" ");
            if(curr.right != null)
            stack.add(curr.right);
            if(curr.left != null)
            stack.add(curr.left);
        }
    }
    public static void postorderIter(TreeNode root){
        //TreeNode curr = root;
        /*
         * Data structure: Use stack
         * Step 1: First push root
         * Step 2: pop from stack and print 
         * Step 3: push first right 
         * Step 4: push left
         * 
         */

         // base case
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while( curr != null || stack.size() >0){
            // if(curr.left == null && curr.right == null){
            //     System.out.print(curr.value+" ");
            // }
            while(curr.left != null){
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.value+" ");
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        root.left.left.right.left = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        postorder(root);
        System.out.println();
        postorderIter(root);
    }
}
