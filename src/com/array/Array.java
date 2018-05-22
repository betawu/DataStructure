package com.array;

import java.util.Arrays;

/**
 * 
 * @author beta
 * 封装自己的array类
 */
public class Array<E> {
	private E[] data;
	//数组的元素个数  相当于索引指向数组空的位置
	private int size;
	
	//构造函数  传入默认创建数组的大小
	public Array(int capacity) {
		data = (E[])new Object[capacity];
		size=0;
	}
	
	//构造函数  没有传入默认的大小
	public Array() {
		this(10);
	}
	
	//构造函数  传入一个数组
	public Array(E[] arr) {
		data = arr;
		size=arr.length;
	}
	
	//获取元素个数
	public int getSize() {
		return size;
	}
	
	//获取array的容量
	public int getCapacity() {
		return data.length;
	}
	
	//判断数组是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	
	//向数组最后一个位置添加元素
	public void addLast(E e) {
		if(size==data.length) {
//			throw new IllegalArgumentException("数组容量已满");
			resize(2*data.length);
		}
		data[size] = e;
		size++;
		//add(size,e);
	}
	

	//向数组第一个位置添加元素
	public void addFirst(E e) {
		add(0,e);
	}
	
	//向数组指定位置插入一个元素
	public void add(int index , E e) {
		if(index<0||index>size) {
			throw new IllegalArgumentException("索引越界");
		}
		if(size==data.length) {
//			throw new IllegalArgumentException("数组容量已满");
			resize(2*data.length);
		}
		
		for(int i=size;i>=index;i--) {
			data[i+1]=data[i];
		}
		data[index] = e;
		size++;
	}
	
	
	//查询指定索引的元素
	public E get(int index) {
		if(index<0||index>=size) {
			throw new IllegalAccessError("查询失败  索引越界");
		}
		
		return data[index];
	}

	
	//获取第一个元素
	public E getFirst() {
		return data[0];
	}
	
	//获取最后一个元素
	public E getLast() {
		return data[size-1];
	}
	
	//修改指定索引的元素
	public void set(int index , E e) {
		if(index<0||index>=size) {
			throw new IllegalAccessError("修改失败  索引越界");
		}
		
		data[index] = e;
	}
	
	
	//查询是否包含某个元素
	public boolean contains(E e) {
		for(int i=0;i<size;i++) {
			if(data[i].equals(e)) {
				return true;
			}
		}
		return false;
	}
	
	//查询元素返回索引
	public int find(E e) {
		for(int i=0;i<size;i++) {
			if(data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}
	
	
	//根据索引删除元素并返回元素
	public E remove(int index) {
		if(index<0||index>=size) {
			throw new IllegalAccessError("删除错误  索引越界");
		}
		E rs = data[index];
		for(int i=index;i<size;i++) {
			data[i]=data[i+1];
		}
		size--;
		
		if(size==data.length/4&&data.length/2!=0) {
			resize(data.length/2);
		}
		
		return rs;
	}
	
	
	//删除指定的元素
	public void removeElement(E e) {
		int index = find(e);
		if(index !=-1) {
			remove(index);
		}
	}
	
	

	@Override
	public String toString() {
		return "size:"+size+" capacity:"+data.length+"\n"+Arrays.toString(data);
	}
	
	//数组扩容
	private void resize(int capacity) {
		E[] newData = (E[])new Object[capacity];
		
		for(int i=0;i<size;i++) {
			newData[i]=data[i]; 
		}
		data = newData;
	}
	
	
}
