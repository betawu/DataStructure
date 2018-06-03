package com.queue.priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * @author beta
 *前K个高频元素
 *
 *给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]
 *
 *使用java内置的优先队列（基于最小堆实现的）
 */
public class Solution2 {
	public List<Integer> topKFrequent(int[] nums, int k) {
        //统计各个元素出现的频率
		HashMap<Integer,Integer> m = new HashMap<>();
		for (int i : nums) {
			if(m.containsKey(i)) {
				m.put(i, m.get(i)+1);
			}else {
				m.put(i, 1);
			}
		}
		//取频率最高的前k个元素
		Set<Integer> set = m.keySet();
		PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(
				//自定义比较器 Comparator
				//最小堆 频率越小优先级越低
				(a,b)->m.get(a)-m.get(b)
		);
		for (Integer i : set) {
			//如果没有取满k个元素就入队
			if(pq.size()<k) {
				pq.add(i);
			}else {
				//满了就判断 将频率最小的元素替换掉
				if(m.get(i)>m.get(pq.peek())) {
					pq.remove();
					pq.add(i);
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		while(!pq.isEmpty()) {
			list.add(pq.remove());
		}
		return list;
    }
	
	public static void main(String[] args) {
		int[] arr = {4,1,-1,2,-1,2,3};
		Solution2 s = new Solution2();
		List<Integer> list = s.topKFrequent(arr, 2);
		System.out.println(list.toString());
	}
}