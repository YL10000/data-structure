/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: BinarySeachTreeSet.java
 * @Package com.life.data.structure.set
 * @Description: 使用二分搜索树实现集合
 * @Author: ViaX-yanglin
 * @Date: 2018年9月28日 下午3:40:06
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.set;

import com.life.data.structure.tree.BinarySearchTree;

/**
 * @Title: BinarySeachTreeSet
 * @Description: 使用二分搜索树实现集合
 * @Author: ViaX-yanglin
 * @Date: 2018年9月28日 下午3:40:06
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class BinarySeachTreeSet<E extends Comparable<E>> implements Set<E> {

	//使用二分搜索树进行集合底层数据存储结构
	private BinarySearchTree<E> tree=new BinarySearchTree<>();
	
	@Override
	public Integer getSize() {
		return tree.getSize();
	}

	@Override
	public boolean isEmpty() {
		return tree.isEmpty();
	}

	@Override
	public boolean contains(E e) {
		return tree.contains(e);
	}

	@Override
	public Set<E> add(E e) {
		//二分搜索树本身不能存在重复元素
		tree.add(e);
		return this;
	}

	@Override
	public Set<E> remove(E e) {
		tree.remove(e);
		return this;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("BinarySeachTreeSet [size=" + getSize() + "]");
		return buffer.toString();
	}

	@Override
	public Set<E> display() {
		System.out.println("---------------");
		System.out.println(this.toString());
		tree.displayLayerOrder();
		return this;
	}
}
