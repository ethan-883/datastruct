package 剑指offer;

public class _剑指_Offer_33_二叉搜索树的后序遍历序列 {
	 public boolean verifyPostorder(int[] postorder) {
        //递归
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int p = left;
        while (postorder[p] < postorder[left]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[right]) {
            p++;
        }
        return p == right && recur(postorder, left, m - 1) 
            && recur(postorder, m, right - 1);
    }
}
