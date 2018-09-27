/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: LinkListQueue.java
 * @Package com.life.data.structure.queue
 * @Description: 使用链表来实现队列
 * @Author: ViaX-yanglin
 * @Date: 2018年9月26日 下午4:35:45
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.queue;

/**
 * @Title: LinkListQueue
 * @Description: 使用链表来实现队列
 * @Author: ViaX-yanglin
 * @Date: 2018年9月26日 下午4:35:45
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class LinkListQueue<E> implements Queue<E> {
	
	//从链表的头部进行出队，尾部进行入队
	private Node<E> head,tail;
	
	private int size;

	public LinkListQueue() {
		head=null;
		tail=null;
		size=0;
	}

	@Override
	public int getCapacity() {
		return 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public Queue<E> enQueue(E e) {
		if (tail==null) {
			tail=new Node<E>(e, tail);
			head=tail;
		}else {
			tail.next=new Node<>(e, tail.next);
			tail=tail.next;
		}
		size++;
		return this;
	}

	@Override
	public E deQueue() {
		if (isEmpty()) {
			throw new IllegalArgumentException("dequeue failer,the queue is empty");
		}
		Node<E> deNode=head;
		head=head.next;
		deNode.next=null;
		size--;
		return deNode.e;
	}

	@Override
	public E getFront() {
		if (isEmpty()) {
			throw new IllegalArgumentException("getFront failer,the queue is empty");
		}
		return head.e;
	}
	
	

	@Override
	public String toString() {
		StringBuffer buffer =new StringBuffer();
		buffer.append("LinkListQueue [head=" + head.e + ", tail=" + tail.e + ", size=" + size + "] head ");
		Node<E> currentNode=head;
		while (currentNode!=null) {
			buffer.append(currentNode.e+"->");
			currentNode=currentNode.next;
		}
		buffer.append("NULL tail ");
		return buffer.toString();
	}

	@Override
	public Queue<E> display() {
		System.out.println("--------------");
		System.out.println(this.toString());
		return this;
	}
	
	@SuppressWarnings("hiding")
	private class Node<E>{
		public E e;
		public Node<E> next;
		
		public Node(E e, Node<E> next) {
			this.e = e;
			this.next = next;
		}
	}
}
