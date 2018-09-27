/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: DummyHeadLinkedList.java
 * @Package com.life.data.structure.linked_list
 * @Description: 添加了虚拟头结点的链表
 * @Author: ViaX-yanglin
 * @Date: 2018年9月26日 下午2:22:18
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.linked_list;

/**
 * @Title: DummyHeadLinkedList
 * @Description: 添加了虚拟头结点的链表
 * @Author: ViaX-yanglin
 * @Date: 2018年9月26日 下午2:22:18
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class DummyHeadLinkedList<E> {
	
	//虚拟头结点
	private Node dummyHead;
	
	private int size;
	
	public DummyHeadLinkedList() {
		super();
		dummyHead=new Node(null, null);
		size=0;
	}

	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	//添加指定位置的结点
	public DummyHeadLinkedList<E> add(int index,E e){
		if (index<0 || index > size) {
			throw new IllegalArgumentException("add failer, index require > 0 and <= "+size);
		}
		add(index, e,dummyHead);
		return this;
	}
	
	//内部辅助函数，添加指定位置的结点
	private void add(int index,E e,Node currentNode) {
		if (index==0) {
			currentNode.next=new Node(e, currentNode.next);
			size++;
		}else {
			add(index-1, e,currentNode.next);
		}
	}
	
	//添加头结点
	public DummyHeadLinkedList<E> addFirst(E e){
		return add(0, e);
	}
	
	//添加尾部结点
	public DummyHeadLinkedList<E> addLast(E e) {
		return add(size, e);
	}
	
	//查找指定位置的结点
	public E get(int index) {
		if (index<0 || index >= size) {
			throw new IllegalArgumentException("get failer,index require > 0 and < "+size);
		}
		Node current=dummyHead.next;
		for(int i=0;i<index;i++) {
			current=current.next;
		}
		return current.e;
	}
	
	//修改指定位置的元素
	public DummyHeadLinkedList<E> set(int index,E e) {
		if (index<0 || index >= size) {
			throw new IllegalArgumentException("get failer,index require > 0 and < "+size);
		}
		
		Node current=dummyHead.next;
		for(int i=0;i<index;i++) {
			current=current.next;
		}
		current.e=e;
		return this;
	}
	
	//判断是否包含某个结点
	public boolean contains(E e) {
		Node current=dummyHead.next;
		for(int i=0;i<size;i++) {
			if (current.e.equals(e)) {
				return true;
			}
			current=current.next;
		}
		return false;
	}
	
	//移除指定的元素
	public E remove(int index){
		Node pre=dummyHead;
		for(int i=0;i<index;i++) {
			pre=pre.next;
		}
		Node removeNode=pre.next;
		pre.next=pre.next.next;
		size--;
		return removeNode.e;
	}
	
	//删除头结点
	public E removeFirst(){
		return this.remove(0);
	}
	
	//删除尾结点
	public E removeLast(){
		return this.remove(size-1);
	}
	
	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("DummyHeadLinkedList [size=" + size + "] ");
		Node current=dummyHead.next;
		while (current!=null) {
			buffer.append(current.e+"->");
			current=current.next;
		}
		buffer.append("NULL");
		return buffer.toString();
	}
	
	public DummyHeadLinkedList<E> display(){
		System.out.println("-----------------");
		System.out.println(this.toString());
		return this;
	}

	private class Node{
		public E e;
		public Node next;
		
		public Node(E e, Node next) {
			super();
			this.e = e;
			this.next = next;
		}
	}
}
