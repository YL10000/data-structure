/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: MyQueueTest.java
 * @Package com.life.data.structure.arrays
 * @Description: 队列测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月10日 下午2:29:50
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.arrays;

import org.junit.Test;

import com.life.data.structure.queue.MyQueue;

/**
 * @Title: MyQueueTest
 * @Description: 队列测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月10日 下午2:29:50
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class MyQueueTest {
	
	@Test
	public void myQueueTest() {
		MyQueue<Integer> myQueue=new MyQueue<>(5);
		
		myQueue.add(3);
		myQueue.add(4);
		Integer top=myQueue.element();
		System.out.println("队头元素："+top);
		myQueue.add(2);
		myQueue.remove();
		myQueue.add(5);
		myQueue.add(6);
		myQueue.add(8);
		top=myQueue.element();
		System.out.println("队头元素："+top);
		//myQueue.add(9);
		
		myQueue.remove();
		top=myQueue.element();
		System.out.println("队头元素："+top);
		
		myQueue.remove();
		myQueue.remove();
		myQueue.remove();
		myQueue.remove();
		myQueue.remove();
	}
}
