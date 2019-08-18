
class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        int left = depth(root.left, 1);
        int right = depth(root.right, 1);    
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    

    int depth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        
        int left = depth(root.left, depth + 1);
        int right = depth(root.right, depth + 1);
        return Math.max(left, right);
    }
}