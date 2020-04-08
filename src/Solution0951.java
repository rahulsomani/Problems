
public class Solution0951 {

	public static void main(String[] args) {

		TreeNode root1Test1 = new TreeNode(1);
		root1Test1.left = new TreeNode(2);
		root1Test1.right = new TreeNode(3);

		root1Test1.left.left = new TreeNode(4);
		root1Test1.left.right = new TreeNode(5);

		root1Test1.left.right.left = new TreeNode(7);
		root1Test1.left.right.right = new TreeNode(8);

		root1Test1.right.left = new TreeNode(6);

		TreeNode root2Test1 = new TreeNode(1);
		root2Test1.left = new TreeNode(3);
		root2Test1.right = new TreeNode(2);

		root2Test1.left.right = new TreeNode(6);

		root2Test1.right.left = new TreeNode(4);
		root2Test1.right.right = new TreeNode(5);

		root2Test1.right.right.left = new TreeNode(8);
		root2Test1.right.right.right = new TreeNode(7);

		Solution0951 o = new Solution0951();

		// System.out.println(o.flipEquiv(root1Test1, root2Test1)); // true

		TreeNode root1Test2 = new TreeNode(0);
		root1Test2.right = new TreeNode(1);
		TreeNode root2Test2 = null;

		// System.out.println(o.flipEquiv(root1Test2, root2Test2)); // false

		TreeNode root1Test3 = new TreeNode(0);
		root1Test3.left = new TreeNode(3);
		root1Test3.right = new TreeNode(1);
		root1Test3.right.right = new TreeNode(2);

		TreeNode root2Test3 = new TreeNode(0);
		root2Test3.left = new TreeNode(3);
		root2Test3.right = new TreeNode(1);
		root2Test3.left.left = new TreeNode(2);

		System.out.println(o.flipEquiv(root1Test3, root2Test3)); // false

	}

	public boolean flipEquiv(TreeNode root1, TreeNode root2) {

		flipEquiv = true;
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null) {
			return false;
		}

		flipEquivHelper(root1, root2);

		return flipEquiv;

	}

	private boolean flipEquiv = true;

	public void flipEquivHelper(TreeNode root1, TreeNode root2) {

		if (flipEquiv) {

			if (root1 == null && root2 == null) {
				return;
			} else if (root1 != null && root2 == null) {
				flipEquiv = false;
				return;
			} else if (root1 == null && root2 != null) {
				flipEquiv = false;
				return;
			} else if (root1.val != root2.val) {
				flipEquiv = false;
				return;
			} else {

				if (root1.left == null && root2.left == null) {

				} else if (root1.left != null && root2.left == null) {

					TreeNode temp = root2.left;
					root2.left = root2.right;
					root2.right = temp;

				} else if (root1.left == null && root2.left != null) {

					TreeNode temp = root2.left;
					root2.left = root2.right;
					root2.right = temp;

				} else {

					if (root1.left.val != root2.left.val) {
						TreeNode temp = root2.left;
						root2.left = root2.right;
						root2.right = temp;

					}
				}

				flipEquivHelper(root1.left, root2.left);

				if (root1.right == null && root2.right == null) {

				} else if (root1.right != null && root2.right == null) {

					TreeNode temp = root2.right;
					root2.right = root2.left;
					root2.left = temp;

				} else if (root1.right == null && root2.right != null) {

					TreeNode temp = root2.right;
					root2.right = root2.left;
					root2.left = temp;

				}
				else  {
					if (root1.right.val != root2.right.val) {
						TreeNode temp = root2.right;
						root2.right = root2.left;
						root2.left = temp;

					}

				}
				flipEquivHelper(root1.right, root2.right);

			}
		} else {
			flipEquiv = false;
		}
	}
}
