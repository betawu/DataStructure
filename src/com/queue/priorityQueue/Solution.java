package com.queue.priorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.array.Array;

/**
 * 
 * @author beta
 *前K个高频元素
 *
 *给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]
 */
public class Solution {
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
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (Integer i : set) {
			//如果没有取满k个元素就入队
			if(pq.getCapacity()<k) {
				pq.enQueue(i);
			}else {
				//满了就判断 将频率最小的元素替换掉
				if(m.get(i)>pq.getFront()) {
					pq.deQueue();
					pq.enQueue(i);
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		while(!pq.isEmpty()) {
			list.add(pq.deQueue());
		}
		return list;
    }
	
	private class Frep<E>  implements Comparable<Frep>{
		public E e;
		public int frep;
		
		public Frep(E e, int frep) {
			this.e = e;
			this.frep = frep;
		}

		@Override
		//频率越小优先级越高
		public int compareTo(Frep other) {
//			if(frep-other.frep<0) {
//				return 1;
//			}else if(frep - other.frep>0) {
//				return -1;
//			}else {
//				return 0;
//			}
			return other.frep - frep;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,3};
		Solution s = new Solution();
		List<Integer> list = s.topKFrequent(arr, 2);
		System.out.println(list.toString());
	}
}
