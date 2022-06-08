package 排序;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 堆排序优先队列 {
	public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
    	//堆排序优先队列
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }
        int j = 0;
        while (!heap.isEmpty()) {
            nums[j++] = heap.poll();
        }
    }
}
