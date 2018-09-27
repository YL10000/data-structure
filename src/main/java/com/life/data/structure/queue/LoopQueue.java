/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: LoopQueue.java
 * @Package com.life.data.structure.queue
 * @Description: 循环队列
 * @Author: ViaX-yanglin
 * @Date: 2018年9月25日 下午6:58:44
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.queue;

/**
 * @Title: LoopQueue
 * @Description: 循环队列
 * @Author: ViaX-yanglin
 * @Date: 2018年9月25日 下午6:58:44
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class LoopQueue<E> implements Queue<E> {
	
	private E[] datas;
	
	//front:下次出队的元素索引
	//tail:下次入队的元素索引
	//size:元素个数
	private int front,tail,size;
	
	public LoopQueue() {
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	public LoopQueue(int capacity) {
		//故意多出一个元素的容量，当tail==front时，表示数组队列为空；当tail+1=front时，表示队列满了，但其实tail目前的位置是空的（多出来的那个容量的位置）
		datas=(E[]) new Object[capacity+1];
		this.front=0;
		this.tail=0;
		this.size=0;
	}

	@Override
	public int getCapacity() {
		//数组的长度比容量大1
		return datas.length-1;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.front==this.tail;
	}

	@Override
	public Queue<E> enQueue(E e) {
		//如果容量不够，进行扩容
		if ((tail+1)%datas.length==front) {
			reSize(getCapacity()*2);
		}
		
		//将元素添加到tial所在的位置
		datas[tail]=e;
		
		//将tail的索引向后移动一位
		tail=++tail%datas.length;
		size++;
		return this;
	}

	@Override
	public E deQueue() {
		if (isEmpty()) {
			throw new IllegalArgumentException("edqueue failer,queue is empty");
		}
		
		//将front做在的元素进行删除
		E removeDate=datas[front];
		datas[front]=null;
		
		//将front的索引向后移动一位
		front=++front%datas.length;
		size--;
		
		//如果元素个数小于容量的1/4,进行缩容操作
		if (size==getCapacity()/4&&getCapacity()/2!=0) {
			reSize(getCapacity()/2);
		}
		return removeDate;
	}

	@Override
	public E getFront() {
		if (isEmpty()) {
			throw new IllegalArgumentException("getFront fialer,the queue is empty");
		}
		//查看队头的元素
		return datas[front];
	}

	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("LoopQueue [capacity = "+getCapacity()+",size = "+getSize()+"]");
		buffer.append("front [");
		for(int i=front;i!=tail;i=(i+1)%datas.length) {
			buffer.append(datas[i]);
			if ((i+1)%datas.length!=tail) {
				buffer.append(",");
			}
		}
		buffer.append("] tail");
		return buffer.toString();
	}

	@Override
	public Queue<E> display() {
		System.out.println("----------");
		System.out.println(this.toString());
		return this;
	}
	
	//对原来的数组进行扩容或缩容操作
	@SuppressWarnings("unchecked")
	private Queue<E> reSize(int newCapacity){
		E[] newDatas=(E[]) new Object[newCapacity+1];
		for(int i=0;i<size;i++) {
			//将原来数组中的元素复制给新的数组
			newDatas[i]=datas[(front+i)%datas.length];
		}
		datas=newDatas;
		front=0;
		tail=size;
		return this;
	}
}
