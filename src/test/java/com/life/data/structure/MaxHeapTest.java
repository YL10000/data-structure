/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: MaxHeapTest.java
 * @Package com.life.data.structure
 * @Description: TODO(用一句话描述该文件做什么)
 * @Author: ViaX-yanglin
 * @Date: 2018年9月29日 下午2:00:46
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure;

import java.util.Random;

import org.junit.Test;

import com.life.data.structure.heap.MaxHeap;
import com.life.data.structure.queue.PriorityQueue;
import com.life.data.structure.queue.Queue;

/**
 * @Title: MaxHeapTest
 * @Description: 最大堆测试类
 * @Author: ViaX-yanglin
 * @Date: 2018年9月29日 下午2:00:46
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class MaxHeapTest {
	
	@Test
	public void maxHeapTest() {
		Random random=new Random(100);
		MaxHeap<Integer> heap=new MaxHeap<>((a,b)->a.compareTo(b));
		
		for(int i=0;i<10;i++) {
			heap.add(random.nextInt(100));
		}
		
		
		
		heap.display();
		System.out.println(heap.getFront());
		System.out.println(heap.display().extract());
		heap.display();
		System.out.println(heap.extract());
		heap.display();
		
		/*Integer[] nums=new Integer[10];
		for(int i=0;i<10;i++)
			nums[i]=random.nextInt(100);
		
		MaxHeap<Integer> heap2=new MaxHeap<>(nums, (a,b)->a.compareTo(b)) ;
		heap2.display();*/
	}
	
	@Test
	public void priorityQueueTest() {
		Queue<Integer> priorityQueue=new PriorityQueue<>((a,b)->a.compareTo(b));
		Random random=new Random(100);
		for(int i=0;i<10;i++) {
			priorityQueue.enQueue(random.nextInt(100));
		}
		priorityQueue.display();
		System.out.println(priorityQueue.getFront());
		priorityQueue.display();
		System.out.println(priorityQueue.deQueue());
		priorityQueue.display();
		
	}

}
