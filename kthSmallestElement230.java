import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class kthSmallestElement230 {
	public int kthSmallest(TreeNode root, int k) {
        // preorder
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        Set<TreeNode> visited = new HashSet<TreeNode>();
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            System.out.println(cur.val + "," + queue.size());
            if (!visited.contains(cur)) {
                if (cur.right != null) {
                    queue.offerFirst(cur.right);
                }
                queue.offerFirst(cur);

                if (cur.left != null) {
                    queue.offerFirst(cur.left);
                } 

                visited.add(cur);
            } else {
                count++;
                if (count == k) {
                    return cur.val;
                }
            }
        }
        return 0;
    }
}