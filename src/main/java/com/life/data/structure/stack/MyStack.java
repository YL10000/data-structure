/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: MyStack.java
 * @Package com.life.data.structure.stack
 * @Description: 栈的实现原理
 * @Author: ViaX-yanglin
 * @Date: 2018年9月4日 下午1:38:32
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.stack;

/**
 * @Title: MyStack
 * @Description: 栈的实现原理
 * @Author: ViaX-yanglin
 * @Date: 2018年9月4日 下午1:38:32
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class MyStack<E> {
	
	private Object[] datas;
	
	private int topIndex=0;
	

	public MyStack(int size) {
		super();
		this.datas = new Object[size];
	}
	
	public MyStack<E> push(E e) {
		datas[topIndex++]=e;
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public E pop() {
		return (E) datas[--topIndex];
	}
	
	@SuppressWarnings("unchecked")
	public E peek() {
		int currentIndex=topIndex-1;
		return (E) datas[currentIndex];
	}
	
	public boolean isEmpty() {
		return topIndex==0;
	}
	
	public int size() {
		return topIndex;
	}
}
