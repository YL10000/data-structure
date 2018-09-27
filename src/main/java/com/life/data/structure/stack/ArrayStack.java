/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: ArrayStack.java
 * @Package com.life.data.structure.stack
 * @Description: 使用array实现stack
 * @Author: ViaX-yanglin
 * @Date: 2018年9月25日 下午5:51:43
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.stack;

import com.life.data.structure.arrays.Array;

/**
 * @Title: ArrayStack
 * @Description: 使用array实现stack
 * @Author: ViaX-yanglin
 * @Date: 2018年9月25日 下午5:51:43
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class ArrayStack<E> implements Stack<E> {

	//底层使用array进行数组存储，
	//由于stack每次只能在一端进行操作，而array在尾部添加、删除、查找的复杂度都是O(1)级别,故将array的尾部作为stack的栈顶
	private Array<E> array;

	public ArrayStack() {
		this(10);
	}

	public ArrayStack(int capacity) {
		this.array=new Array<>(capacity);
	}
	
	@Override
	public int getSize() {
		return array.getSize();
	}
	
	@Override
	public int getCapacity() {
		return array.getCapacity();
	}
	
	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public Stack<E> push(E e) {
		//在array的尾部添加一个元素
		array.addLast(e);
		return this;
	}

	@Override
	public E pop() {
		//删除array尾部的元素
		return array.removeLast();
	}

	@Override
	public E peek() {
		//查看array尾部的元素
		return array.find(array.getSize()-1);
	}

	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("ArrayStack [capacity = "+getCapacity()+",size = "+getSize()+"]");
		buffer.append("[");
		for(int i=0;i<getSize();i++) {
			buffer.append(array.find(i));
			if (i!=getSize()-1) {
				buffer.append(",");
			}
		}
		buffer.append("] top");
		return buffer.toString();
	}
	
	@Override
	public Stack<E> display(){
		System.out.println("--------------");
		System.out.println(this.toString());
		return this;
	}
}
