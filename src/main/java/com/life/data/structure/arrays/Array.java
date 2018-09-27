/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: Array.java
 * @Package com.life.data.structure.arrays
 * @Description: 自定义动态数组
 * @Author: ViaX-yanglin
 * @Date: 2018年9月25日 下午4:28:06
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.arrays;

import java.util.Arrays;

/**
 * @Title: Array
 * @Description: 自定义动态数组
 * @Author: ViaX-yanglin
 * @Date: 2018年9月25日 下午4:28:06
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class Array<E> {
	
	private E[] datas;

	//元素个数
	private int size;

	@SuppressWarnings("unchecked")
	public Array(int capacity) {
		datas=(E[]) new Object[capacity];
		this.size=0;
	}

	public Array() {
		this(10);
	}
	
	//获取数组的容量
	public int getCapacity() {
		return datas.length;
	}
	
	//获取素组中元素的个数
	public int getSize() {
		return size;
	}
	
	//判断数组是不是为空
	public boolean isEmpty() {
		return size==0;
	}
	
	//在指定索引位置添加元素
	public Array<E> add(E e,int index) {
		if (index>size||index<0) {
			throw new IllegalArgumentException("add failer.require index >=0 and index < "+size);
		}
		for(int i=size-1;i>=index;i--) {
			//将index及之后的元素向后移动一位
			datas[i+1]=datas[i];
		}
		//将index的元素设置为e
		datas[index]=e;
		size++;
		
		//如果数组已满，进行扩展为原来的两倍
		if (size==datas.length) {
			reSize(datas.length*2);
		}
		return this;
	}
	
	//在尾部添加一个元素
	public Array<E> addLast(E e) {
		return add(e, size);
	}
	
	//在头部添加一个元素
	public Array<E> addFirst(E e) {
		return add(e, 0);
	}
	
	//获取指定索引位置的元素
	public E find(int index) {
		if (index>=size||index<0) {
			throw new IllegalArgumentException("find failer.require index >=0 and index < "+size);
		}
		return datas[index];
	}
	
	//修改指定索引位置的元素
	public Array<E> set(int index,E e){
		if (index>=size||index<0) {
			throw new IllegalArgumentException("find failer.require index >=0 and index < "+size);
		}
		datas[index]=e;
		return this;
	}
	
	//判断是否存在指定的元素
	public boolean contains(E e) {
		for(int i=0;i<size;i++) {
			if (datas[i].equals(e)) {
				return true;
			}
		}
		return false;
	}
	
	//查找指定的元素的索引
	public int find(E e) {
		for(int i=0;i<size;i++) {
			if (datas[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}
	
	//删除指定位置的元素
	public E remove(int index){
		if (index>=size||index<0) {
			throw new IllegalArgumentException("find failer.require index >=0 and index < "+size);
		}
		E removeDate=datas[index];
		for(int i=index;i<size-1;i++) {
			datas[i]=datas[i+1];
		}
		size--;
		datas[size]=null;
		
		//如果元素个数少于容量的1/4，进行缩容操作
		if (size==datas.length/4&&datas.length/2!=0) {
			reSize(datas.length/2);
		}
		return removeDate;
	}
	
	public E removeFirst(){
		return remove(0);
	}
	
	public E removeLast(){
		return remove(size-1);
	}
	
	//将数组进行扩容或者缩容
	@SuppressWarnings({ "unchecked" })
	private Array<E> reSize(int newCapacity){
		E[] newDatas=(E[]) new Object[newCapacity];	
		for(int i=0;i<size;i++) {
			newDatas[i]=datas[i];
		}
		datas=newDatas;
		return this;
	}

	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("Array [capacity = "+getCapacity()+",size = "+getSize()+"]");
		buffer.append(Arrays.toString(datas));
		return buffer.toString();
	}
	
	public Array<E> display(){
		System.out.println("-------------");
		System.out.println(this.toString());
		return this;
	}
	
	
}
