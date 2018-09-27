/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: ArrayQueue.java
 * @Package com.life.data.structure.queue
 * @Description: 使用数组实现队列
 * @Author: ViaX-yanglin
 * @Date: 2018年9月25日 下午6:43:06
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.queue;

import com.life.data.structure.arrays.Array;

/**
 * @Title: ArrayQueue
 * @Description: 使用数组实现队列
 * @Author: ViaX-yanglin
 * @Date: 2018年9月25日 下午6:43:06
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class ArrayQueue<E> implements Queue<E> {

	//使用array作为queue底层数据的存储结构，
	//在尾部进行入队（时间复杂度为O(1)）,在头部进行出队（时间复杂度为O(n)）
	private Array<E> array;
	
	public ArrayQueue() {
		this(10);
	}

	public ArrayQueue(int capacity) {
		this.array = new Array<>(capacity);
	}

	@Override
	public int getCapacity() {
		return array.getCapacity();
	}

	@Override
	public int getSize() {
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public Queue<E> enQueue(E e) {
		//在array的尾部进行入队
		array.addLast(e);
		return this;
	}

	@Override
	public E deQueue() {
		//从array的头部进行出队
		return array.removeFirst();
	}

	@Override
	public E getFront() {
		//查看队头的元素（时间复杂度为O(1)）
		return array.find(0);
	}
	
	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("ArrayQueue [capacity = "+getCapacity()+",size = "+getSize()+"]");
		buffer.append("front [");
		for(int i=0;i<getSize();i++) {
			buffer.append(array.find(i));
			if (i!=getSize()-1) {
				buffer.append(",");
			}
		}
		buffer.append("] tail");
		return buffer.toString();
	}

	@Override
	public Queue<E> display() {
		System.out.println("-------------");
		System.out.println(this.toString());
		return this;
	}
}
