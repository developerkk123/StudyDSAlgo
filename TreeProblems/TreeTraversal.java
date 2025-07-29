package TreeProblems;

public class TreeTraversal {
    public static void preorder(TreeNode root){
        /*
         * Logic remember P-L-R
         * print root -> go left -> go right
         * edge case : if root are null return
         */
        if(root == null) return;
        System.out.print(root.value +" ");
        preorder(root.left);
        preorder(root.right);
        TreeNode temNode = root.left;
        TreeNode temNode2 = root.right;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        postorder(root);
    }
}
