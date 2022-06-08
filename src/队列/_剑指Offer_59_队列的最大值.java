package 队列;

import java.util.ArrayDeque;
import java.util.Queue;

public class _剑指Offer_59_队列的最大值 {
    class MaxQueue {
        //存放队列
        Queue<Integer> queue;
        //存放最大值
        ArrayDeque<Integer> maxValueDeque;

        public MaxQueue() {
            queue = new ArrayDeque<>();
            maxValueDeque = new ArrayDeque<>();
        }
        
        public int max_value() {
            if (maxValueDeque.isEmpty()) {
                return -1;
            }
            return maxValueDeque.peekFirst();
        }
        
        public void push_back(final int value) {
            //从queue队头到队尾每个元素求maxValue就是dp
            while (!maxValueDeque.isEmpty() && maxValueDeque.peekLast() < value) {
                maxValueDeque.pollLast();
            }
            maxValueDeque.offerLast(value);
            queue.offer(value);
        }
        
        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int ans = queue.poll();
            if (ans == maxValueDeque.peekFirst()) {
                maxValueDeque.pollFirst();
            }
            return ans;
        }
    }
}