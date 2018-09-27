/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: MyQueue.java
 * @Package com.life.data.structure.queue
 * @Description: 队列的实现原理
 * @Author: ViaX-yanglin
 * @Date: 2018年9月10日 下午2:00:02
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.queue;

/**
 * @Title: MyQueue
 * @Description: 队列的实现原理
 * @Author: ViaX-yanglin
 * @Date: 2018年9月10日 下午2:00:02
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class MyQueue<E> {
	
	private Object[] datas;;
	
	//队头的下标
	private int topIndex;
	
	//队尾的下标
	private int endIndex;
	
	//队列中现有的元素个数
	private int count;
	
	
	public MyQueue(int capacity) {
		super();
		this.datas=new Object[capacity];
		topIndex=-1;
		endIndex=-1;
		count=0;
	}

	public boolean add(E e) {
		if (count<this.datas.length) {
			if (endIndex==this.datas.length-1) {
				endIndex=-1;
			}
			this.datas[++endIndex]=e;
			count++;
			return true;
		}else {
			throw new RuntimeException("队列已满");
		}
	}
	
	@SuppressWarnings("unchecked")
	public E remove() {
		if (count>0) {
			if (topIndex==this.datas.length-1) {
				topIndex=-1;
			}
			count--;
			return (E) this.datas[++topIndex];
		}else {
			throw new RuntimeException("队列已空");
		}
	}
	
	//查看队头元素
	@SuppressWarnings("unchecked")
	public E element() {
		if (count>0) {
			Integer currentIndex=topIndex;
			if (topIndex==this.datas.length-1) {
				currentIndex=-1;
			}
			return (E) this.datas[++currentIndex];
		}else {
			throw new RuntimeException("队列已空");
		}
	}
}
