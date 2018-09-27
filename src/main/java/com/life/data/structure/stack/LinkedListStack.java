/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: LinkedListStack.java
 * @Package com.life.data.structure.stack
 * @Description: 使用链表实现栈
 * @Author: ViaX-yanglin
 * @Date: 2018年9月26日 下午3:26:18
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.stack;

import com.life.data.structure.linked_list.DummyHeadLinkedList;

/**
 * @Title: LinkedListStack
 * @Description: 使用链表实现栈
 * @Author: ViaX-yanglin
 * @Date: 2018年9月26日 下午3:26:18
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class LinkedListStack<E> implements Stack<E> {
	
	//使用链表的头结点作为栈顶元素进行实现
	private DummyHeadLinkedList<E> linkedList = new DummyHeadLinkedList<>();

	@Override
	public int getSize() {
		return linkedList.getSize();
	}

	@Override
	public int getCapacity() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

	@Override
	public Stack<E> push(E e) {
		linkedList.addFirst(e);
		return this;
	}

	@Override
	public E pop() {
		return linkedList.removeFirst();
	}

	@Override
	public E peek() {
		return linkedList.get(0);
	}

	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("LinkedListStack [size=" + getSize() + "] top ");
		for(int i=0;i<getSize();i++) {
			buffer.append(linkedList.get(i)+"->");
		}
		buffer.append("NULL tail");
		return buffer.toString();
	}

	@Override
	public Stack<E> display() {
		System.out.println("--------------");
		System.out.println(this.toString());
		return this;
	}
}
