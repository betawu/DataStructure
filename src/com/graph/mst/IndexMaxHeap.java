package com.graph.mst;

/**
 * 索引优先队列
 * 
 * @author Beta
 *
 */
public class IndexMaxHeap<T extends Comparable<T>> {
	private int[] qp;
	private int[] pq;
	private T[] keys;
	private int size;

	public IndexMaxHeap(int n) {
		qp = new int[n];
		pq = new int[n];
		keys = (T[]) new Comparable[n];
		for (int i = 0; i < qp.length; i++) {
			qp[i] = -1;
			pq[i] = -1;
		}
	}
	
	public T get(int i) {
		if (qp[i] == -1) {
			return null;
		}
		return keys[pq[qp[i]]];
	}

	public void insert(int k, T t) throws Exception {
		if (k >= qp.length) {
			throw new Exception("索引越界");
		}
		qp[k] = size;
		pq[size] = k;
		keys[k] = t;
		swim(size);
		size++;
	}

	public T delMax() {
		T rs = keys[pq[0]];
		exch(0, size - 1);
		keys[pq[size - 1]] = null;
		qp[size - 1] = -1;
		size--;
		sink(0);
		return rs;
	}

	private void sink(int i) {
		while ((2 * i + 1) < size - 1) {
			int k = 2 * i + 1;
			if (k + 1 <= size - 1 && SortUtil.less(keys[pq[k]], keys[pq[k + 1]])) {
				k++;
			}
			if (SortUtil.less(keys[pq[i]], keys[pq[k]])) {
				exch(i, k);
			}
			i = k;
		}
	}

	private void swim(int i) {
		while (i > 0 && SortUtil.less(keys[pq[(i - 1) / 2]], keys[pq[i]])) {
			exch(i, (i - 1) / 2);
			i = (i - 1) / 2;
		}
	}

	private void exch(int i, int j) {
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void show() {
		for (int i = 0; i < pq.length; i++) {
			if (pq[i] == -1) {
				System.out.print(i + "=null ");
			} else {
				System.out.print(i + "=" + keys[pq[i]] + " ");
			}
		}
	}
	
	public int size() {
		return size;
	}
}
