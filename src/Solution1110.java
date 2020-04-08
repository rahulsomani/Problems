import java.util.*;

public class Solution1110 {
	public static void main(String[] args) {
		TreeNode rootTest1 = new TreeNode(1);
		rootTest1.left = new TreeNode(2);
		rootTest1.right = new TreeNode(3);

		rootTest1.left.left = new TreeNode(4);
		rootTest1.left.right = new TreeNode(5);

		rootTest1.right.left = new TreeNode(6);
		rootTest1.right.right = new TreeNode(7);

		int[] to_deleteTest1 = { 3, 5 };

		Solution1110 o = new Solution1110();

		o.delNodes(rootTest1, to_deleteTest1).forEach(x -> System.out.println(x.val));
	}

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

		List<TreeNode> forest = new ArrayList<TreeNode>();
		
		if (root == null) {
			return forest;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < to_delete.length; i++) {
			set.add(to_delete[i]);
		}
		
		deleteNodes(root, set, forest);
		
		if (!set.contains(root.val)) {
			forest.add(root);
		}
		
		
		
		
		return forest;
	}
	
	private TreeNode deleteNodes(TreeNode node, Set<Integer> set, List<TreeNode> forest) {
		
		if (node == null) {
			return null;
		}
		
		node.left = deleteNodes(node.left, set, forest);
		node.right = deleteNodes(node.right, set, forest);
		
		if (set.contains(node.val)) {
			
			if (node.left!= null) {
				forest.add(node.left);
			}
			if (node.right!= null) {
				forest.add(node.right);
			}
			return null;
		}
		return node;
	}

}
