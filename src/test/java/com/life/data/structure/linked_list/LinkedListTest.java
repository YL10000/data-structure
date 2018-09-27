/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: LinkedListTest.java
 * @Package com.life.data.structure.linked_list
 * @Description: 链表测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月26日 上午11:47:30
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.linked_list;

import org.junit.Test;

import com.life.data.structure.queue.LinkListQueue;
import com.life.data.structure.stack.LinkedListStack;

/**
 * @Title: LinkedListTest
 * @Description: 链表测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月26日 上午11:47:30
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class LinkedListTest {

	@Test
	public void linkedListTest() {
		LinkedList<Integer> linkedList=new LinkedList<>();
		linkedList.add(0, 666).add(0, 555).addFirst(44).display();
		linkedList.add(1, 222).display();
		
		for(int i=0;i<5;i++) {
			linkedList.addFirst(i);
		}
		linkedList.display().add(3, 88).display();//.addLast(999).display();
	}
	
	@Test
	public void dummyHeadLinkedListTest() {
		DummyHeadLinkedList<Integer> linkedList=new DummyHeadLinkedList<>();
		linkedList.add(0, 666).add(0, 555).addFirst(44).display();
		linkedList.add(1, 222).display();
		
		for(int i=0;i<5;i++) {
			linkedList.addFirst(i);
		}
		linkedList.display().add(3, 88).display().addLast(999).display();
		
		System.out.println(linkedList.get(10));
		System.out.println(linkedList.contains(555));
		linkedList.set(4, 100).display();
		System.out.println(linkedList.remove(3));
		linkedList.display();
		System.out.println(linkedList.removeFirst());
		System.out.println(linkedList.removeLast());
		linkedList.display();
	}
	
	@Test
	public void stackTest() {
		LinkedListStack<Integer> stack=new LinkedListStack<>();
		for(int i=0;i<5;i++) {
			stack.push(i);
		}
		stack.display();
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		stack.display();
	}
	
	@Test
	public void queueTest() {
		LinkListQueue<Integer> queue=new LinkListQueue<>();
		for(int i=0;i<5;i++) {
			queue.enQueue(i);
		}
		Integer top=queue.display().deQueue();
		System.out.println(top);
		top=queue.enQueue(88).display().getFront();
		System.out.println(top);
		
	}
}
