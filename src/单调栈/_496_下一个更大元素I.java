package 单调栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _496_下一个更大元素I {
	//可用单调栈
	
	//HashMap
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        //先对 nums2 中的每一个元素，求出它的右边第一个更大的元素；
        //将上一步的对应关系放入哈希表（HashMap）中；
        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.add(nums2[i]);
        }

        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;

        //暴力
        // int[] res = new int[nums1.length];
        // for (int i = 0; i < nums1.length; i++) {
        //     res[i] = -1;
        //     boolean flag = false;
        //     for (int j = 0; j < nums2.length; j++) {
        //         if (nums2[j] == nums1[i]) {
        //             flag = true;
        //         }
        //         if (flag && nums2[j] > nums1[i]) {
        //             res[i] = nums2[j];
        //             flag = false;
        //         }
        //     }
        // }
        // return res;
    }
	
}
