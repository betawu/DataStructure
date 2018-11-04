package com.graph.mst;

public class Data<T extends Comparable<T>> implements Comparable<Data> {

	private T t;

	public Data(T t) {
		super();
		this.t = t;
	}

	public Data() {
	}
	
	public T get() {
		return t;
	}

	@Override
	public int compareTo(Data o) {
		if (SortUtil.less((Comparable)t, (Comparable)o.get())) {
			return -1;
		}
		else if (!SortUtil.less((Comparable)t, (Comparable)o.get())) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
