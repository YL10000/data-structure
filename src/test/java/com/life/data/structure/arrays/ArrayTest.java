/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: ArrayTest.java
 * @Package com.life.data.structure.arrays
 * @Description: 数组测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年8月26日 下午5:33:29
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.arrays;

import org.junit.Test;

import com.life.data.structure.queue.ArrayQueue;
import com.life.data.structure.queue.LoopQueue;
import com.life.data.structure.queue.Queue;
import com.life.data.structure.stack.ArrayStack;
import com.life.data.structure.stack.Stack;

/**
 * @Title: ArrayTest
 * @Description: 数组测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年8月26日 下午5:33:29
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class ArrayTest {
	
	@Test
	public void arrayTest() {
		Array<Integer> array=new Array<>();
		for(int i=0;i<10;i++)
			array.addFirst(i).display();
	
		array.display().add(88, 5).remove(3);
		array.removeFirst();
		array.removeLast();
		array.display();
		
		array.removeFirst();
		array.removeLast();
		array.remove(4);
		array.display();
	}
	
	@Test
	public void arrayStackTest() {
		Stack<Integer> stack=new ArrayStack<>();
		for(int i=0;i<10;i++) {
			stack.push(i);
		}
		
		stack.display().pop();
		
		Integer top=stack.display().peek();
		System.out.println(top);
		
		stack.display().pop();
		stack.display();
	}
	
	@Test
	public void arrayQueueTest() {
		Queue<Integer> queue=new ArrayQueue<>();
		for(int i=0;i<10;i++) {
			queue.enQueue(i);
		}
		queue.display().deQueue();
		Integer front=queue.display().getFront();
		System.out.println(front);
		queue.enQueue(88).display();
	}
	
	@Test
	public void loopQueueTest() {
		Queue<Integer> queue=new LoopQueue<>();
		for(int i=0;i<10;i++) {
			queue.enQueue(i);
		}
		queue.display().deQueue();
		Integer front=queue.display().getFront();
		System.out.println(front);
		queue.enQueue(88).display();
	}

	@Test
	public void operateWithIndex() {
		OperationWithIndex array=new OperationWithIndex(10);
		array.insert(4);
		array.insert(5);
		array.insert(2);
		array.insert(3);
		
		array.display();
		
		array.remove(2);
		array.display();
		
		System.out.println(array.get(2));
	}
	
	@Test
	public void operateNoIndex() {
		OperationNoIndex array=new OperationNoIndex(10);
		array.insert(4);
		array.insert(5);
		array.insert(2);
		array.insert(3);
		
		array.display();
		
		array.remove(5);
		array.display();
		
		System.out.println(array.get(2));
	}
	
	@Test
	public void operateNoIndexRepeatable() {
		OperationNoIndexRepeatable array=new OperationNoIndexRepeatable(10);
		array.insert(4);
		array.insert(5);
		array.insert(2);
		array.insert(4);
		array.insert(3);
		array.insert(5);
		array.insert(3);
		
		array.display();
		
		array.remove(5);
		array.display();
		
		System.out.println(array.get(4));
	}
	
}
