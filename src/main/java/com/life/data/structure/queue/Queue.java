/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: Queue.java
 * @Package com.life.data.structure.queue
 * @Description: 自定义队列
 * @Author: ViaX-yanglin
 * @Date: 2018年9月25日 下午6:39:22
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.queue;

/**
 * @Title: Queue
 * @Description: 自定义队列
 * @Author: ViaX-yanglin
 * @Date: 2018年9月25日 下午6:39:22
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public interface Queue<E> {

	public int getCapacity();
	
	public int getSize();
	
	public boolean isEmpty();
	
	//入队
	public Queue<E> enQueue(E e);
	
	//出队
	public E deQueue();
	
	//查看队头的元素
	public E getFront();
	
	public Queue<E> display();
}
