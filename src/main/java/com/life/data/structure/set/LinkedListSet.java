/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: LinkedListSet.java
 * @Package com.life.data.structure.set
 * @Description: 使用链表实现集合
 * @Author: ViaX-yanglin
 * @Date: 2018年9月28日 下午2:26:08
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.set;

import com.life.data.structure.linked_list.DummyHeadLinkedList;

/**
 * @Title: LinkedListSet
 * @Description: 使用链表实现集合
 * @Author: ViaX-yanglin
 * @Date: 2018年9月28日 下午2:26:08
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class LinkedListSet<E> implements Set<E> {
	
	//使用链表作为集合的数据存储
	private DummyHeadLinkedList<E> list;

	public LinkedListSet() {
		this.list=new DummyHeadLinkedList<>();
	}
	
	@Override
	public Integer getSize() {
		return list.getSize();
	}
	
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean contains(E e) {
		return list.contains(e);
	}

	@Override
	public Set<E> add(E e) {
		//首先判断链表中是否已经存在该元素，不存在的时候再进行添加
		if (!list.contains(e)) {
			list.addFirst(e);
		}
		return this;
	}

	@Override
	public Set<E> remove(E e) {
		list.removeElement(e);
		return this;
	}

	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("LinkedListSet [size=" + getSize() + "] ");
		for(int i=0;i<getSize();i++) {
			buffer.append(list.get(i)+"->");
		}
		buffer.append("NULL");
		return buffer.toString();
	}
	
	@Override
	public Set<E> display(){
		System.out.println("-------------------");
		System.out.println(this.toString());
		return this;
	}
}
