/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: PriorityQueue.java
 * @Package com.life.data.structure.queue
 * @Description: 使用堆实现优先队列
 * @Author: ViaX-yanglin
 * @Date: 2018年9月29日 下午3:00:49
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.queue;

import java.util.Comparator;

import com.life.data.structure.heap.MaxHeap;

/**
 * @Title: PriorityQueue
 * @Description: 使用堆实现优先队列
 * @Author: ViaX-yanglin
 * @Date: 2018年9月29日 下午3:00:49
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class PriorityQueue<E> implements Queue<E> {
	

	//优先级规则
	private Comparator<E> comparator;
	
	//使用堆作为优先队列的数据存储
	private MaxHeap<E> heap;

	public PriorityQueue(Comparator<E> comparator) {
		this.comparator = comparator;
		this.heap=new MaxHeap<>(this.comparator);
	}
	
	@Override
	public int getCapacity() {
		return 0;
	}

	@Override
	public int getSize() {
		return heap.getSize();
	}

	@Override
	public boolean isEmpty() {
		return heap.isEmpty();
	}

	@Override
	public Queue<E> enQueue(E e) {
		heap.add(e);
		return this;
	}

	@Override
	public E deQueue() {
		return heap.extract();
	}

	@Override
	public E getFront() {
		return heap.getFront();
	}
	
	@Override
	public String toString() {
		return "PriorityQueue [size=" + getSize() + "]";
	}

	@Override
	public Queue<E> display() {
		System.out.println(this.toString());
		heap.display();
		return this;
	}

}
