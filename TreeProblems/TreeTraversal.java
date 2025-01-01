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
    }
    public static void inorder(TreeNode root){
        /*
         * Logic remember L-P-R
         * go left -> print -> go right
         * edge case : if root are null return
         */
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.value +" ");
        inorder(root.right);
    }
    public static void postorder(TreeNode root){
        /*
         * Logic remember L-R-P
         *  go left -> go right -> print root
         * edge case : if root are null return
         */
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value +" ");
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        postorder(root);
    }
}
