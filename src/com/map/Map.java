package com.map;
/**
 * 映射接口
 * @author beta
 *
 * @param <K>
 * @param <V>
 */
public interface Map<K,V> {
	void add(K k,V v);
	V remove(K k);
	V get(K k);
	void set(K k, V v);
	int size();
	boolean isEmpty();

}
