package com.segmentTree;
/**
 * 
 * @author beta
 *线段树融合器
 */
public interface Merge<E> {
	E merge(E a,E b);
}
