package 剑指offer;

public class _剑指Offer_26_树的子结构 {
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		boolean flag = false;
		if (A != null && B != null) {
			flag = DoesTree1HasTree2(A,B);
			if (!flag) {
				flag = isSubStructure(A.left, B);
			}
			if (!flag) {
				flag = isSubStructure(A.right, B);
			}
		}
		return flag;
	}
	boolean DoesTree1HasTree2(TreeNode A, TreeNode B) {
		if (B == null) {
			return true;
		}
		if (A == null) {
			return false;
		}
		if (A.val != B.val) {
			return false;
		}
		return DoesTree1HasTree2(A.left, B.left) && DoesTree1HasTree2(A.right, B.right);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
}

