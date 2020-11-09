package com.yb.tree;

public class P968 {
    int res = 0;
    int NO_NEED = -1;
    int NO_CAMERA = 0;
    int HAS_CAMERA = 1;

    /**
     * 968. 监控二叉树
     * 给定一个二叉树，我们在树的节点上安装摄像头。
     * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
     * 计算监控树的所有节点所需的最小摄像头数量。
     * <p>
     * 提示：
     * 给定树的节点数的范围是 [1, 1000]。
     * 每个节点的值都是 0。
     */
    public int minCameraCover(TreeNode root) {
//        TreeNode dp = new TreeNode(1);
//        dfs(root, dp);
        if (root == null) return 0;
        if (dfs2(root) == NO_CAMERA) res += 1;
        return res;
    }

    private int countTree(TreeNode root) {
        if (root == null) return 0;
        return root.val + countTree(root.left) + countTree(root.right);
    }

    private void dfs(TreeNode root, TreeNode dp) {
        int val = root.val == 0 ? 1 : 0;

        if (root.left != null) {
            dp.left = new TreeNode(val);
            root.left.val = Math.abs(val);
            dfs(root.left, dp.left);
        }
        if (root.right != null) {
            dp.right = new TreeNode(val);
            root.right.val = Math.abs(val);
            dfs(root.right, dp.right);
        }
    }

    private int dfs2(TreeNode root) {
        if (root == null) return NO_CAMERA;
        int left = dfs2(root.left);
        int right = dfs2(root.right);

        if (left == NO_NEED && right == NO_NEED) return NO_CAMERA;
        if (left == NO_CAMERA || right == NO_CAMERA) {
            res += 1;
            return HAS_CAMERA;
        }
        return left >= HAS_CAMERA || right >= HAS_CAMERA ? NO_NEED : NO_CAMERA;
    }

    /**
     * 617. 合并二叉树
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     * 你需要将他们合并为一个新的二叉树。
     * 合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 != null && t2 != null) t1.val += t2.val;
        if (t1 == null) t1 = t2;
        else t2 = t1;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
