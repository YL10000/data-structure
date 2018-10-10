/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: LinkedList.java
 * @Package com.life.data.structure.linked_list
 * @Description: 自定义链表
 * @Author: ViaX-yanglin
 * @Date: 2018年9月26日 上午11:20:10
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.linked_list;


/**
 * @Title: LinkedList
 * @Description: 自定义链表
 * @Author: ViaX-yanglin
 * @Date: 2018年9月26日 上午11:20:10
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class LinkedList<E> {
	
	//定义头结点
	private Node head;
	
	//定义结点个数
	private int size;
	
	public LinkedList() {
		head=null;
		size=0;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	//在头部添加结点
	public LinkedList<E> addFirst(E e){
		head=new Node(e, head);
		size++;
		return this;
	}
	
	//在指定位置添加结点
	public LinkedList<E> add(int index,E e){
		if (index<0||index>size) {
			throw new IllegalArgumentException("add failer,index require >0 and <= "+size);
		}
		add(index, e, head);
		/*if (index==0) {
			return addFirst(e);
		}else {
			Node pre=head;
			for(int i=1;i<index;i++) {
				pre=pre.next;
			}
			pre.next=new Node(e, pre.next);
			size++;
		}*/
		return this;
	}
	
	//使用递归在指定的位置添加结点
	private LinkedList<E> add(int index,E e,Node currentNode){
		//头结点为空
		if (currentNode==null) {
			return addFirst(e);
		}else {
			if (index==1) {
				//当前结点为要添加的位置结点
				currentNode.next=new Node(e, currentNode.next);
				size++;
			}else {
				//获取当前结点的下一个结点
				add(index-1,e, currentNode.next);
			}
		}
		return this;
	}
	
	//在尾部添加结点
	public LinkedList<E> addLast(E e){
		return add(size, e);
	}

	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("LinkedList [size=" + size + "]");
		Node currentNode=head;
		while (currentNode!=null) {
			buffer.append(currentNode.e+"->");
			currentNode=currentNode.next;
		}
		buffer.append("NULL");
		return buffer.toString();
	}
	
	public LinkedList<E> display(){
		System.out.println("---------------");
		System.out.println(this.toString());
		return this;
	}

	//定义链表中的结点
	private class Node{
		
		//当前结点的数据
		public E e;
		
		//下一个结点的引用
		public Node next;

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}

		@Override
		public String toString() {
			return e.toString();
		}
	}
}
