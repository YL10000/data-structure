/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: SegmentTree.java
 * @Package com.life.data.structure.tree
 * @Description: 线段树
 * @Author: ViaX-yanglin
 * @Date: 2018年9月29日 下午4:59:57
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.tree;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * @Title: SegmentTree
 * @Description: 线段树
 * @Author: ViaX-yanglin
 * @Date: 2018年9月29日 下午4:59:57
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class SegmentTree<E> {
	
	//元素节点
	private E[] datas;
	
	//线段树节点
	private E[] tree;
	
	//两个数组合并的方法
	private BiFunction<E, E, E> function;

	@SuppressWarnings("unchecked")
	public SegmentTree(E[] datas,BiFunction<E, E, E> function) {
		super();
		this.datas = datas;
		
		//线段树节点的个数大致等于节点数的4倍(满二叉树树是，叶子节点的个数=非叶子节点个数+1)
		this.tree=(E[]) new Object[4*this.datas.length];
		this.function=function;
		buildTree(0, 0, getSize()-1);
	}
	
	//构建线段树
	private void buildTree(int index,int startIndex,int endIndex) {
		
		//如果是叶子节点，直接进行设置
		if (endIndex==startIndex) {
			this.tree[index]=datas[startIndex];
			return;
		}
		
		//找到中间索引
		int midIndex=startIndex+(endIndex-startIndex)/2;
		
		//构件左侧的线段树
		buildTree(getLeftIndex(index), startIndex, midIndex);
		
		//构件右侧的线段树
		buildTree(getRightIndex(index), midIndex+1, endIndex);
		
		//设置当前节点的值
		this.tree[index]=function.apply(this.tree[getLeftIndex(index)], this.tree[getRightIndex(index)]);
	}
	
	//查询stratIndex到endIndex的结果
	public E query(int startIndex,int endIndex) {
		if (!(startIndex<=endIndex&&startIndex>=0&&endIndex<datas.length)) {
			throw new IllegalArgumentException("startIndex and endIndex is illegal");
		}
		return query(0, 0, datas.length-1, startIndex, endIndex);
	}
	
	//查询以index为根节点的startIndex到endIndex的值，其中leftIndex和rightIndex代表index节点所表示的区间
	private E query(int index,int leftIndex,int rightIndex,int startIndex,int endIndex) {
		
		int midIndex=leftIndex+(rightIndex-leftIndex)/2;
		//如果区间整个匹配，直接返回
		if (leftIndex==startIndex&&rightIndex==endIndex) {
			return tree[index];
		}else if (endIndex<=midIndex) {
			//在左节点中
			return query(getLeftIndex(index), leftIndex,midIndex,startIndex,endIndex);
		}else if (startIndex>=midIndex+1) {
			//在右节点中
			return query(getRightIndex(index), midIndex+1, rightIndex, startIndex, endIndex);
		}else {
			//在左右两个部分
			E leftNode=query(getLeftIndex(index), leftIndex, midIndex, startIndex, midIndex);
			E rightNode=query(getRightIndex(index), midIndex+1, rightIndex, midIndex+1, endIndex);
			return function.apply(leftNode, rightNode);
		}
	}
	
	//修改datas指定index的值
	public  void set(int index,E e) {
		if (index<0||index>=getSize()) {
			throw new IllegalArgumentException("set index failer,index require >=0 and < "+getSize());
		}
		datas[index]=e;
		set(index, e,0,0,datas.length-1);
	}
	
	private void set(int index,E e,int treeIndex,int startIndex,int endIndex) {
		if (startIndex==endIndex) {
			//找到了指定的节点
			tree[treeIndex]=e;
			return;
		}
		int leftIndex=getLeftIndex(treeIndex);
		int rightIndex=getRightIndex(treeIndex);
		
		int midIndex=startIndex+(endIndex-startIndex)/2;
		
		if (midIndex>=index) {
			//在左侧
			set(index, e,leftIndex, startIndex, midIndex);
		}else {
			//在右侧
			set(index, e, rightIndex, midIndex+1, endIndex);
		}
		tree[treeIndex]=function.apply(tree[leftIndex],tree[rightIndex]);
	}
	
	public int getSize() {
		return datas.length;
	}
	
	//获取左子节点的坐标
	private int getLeftIndex(int index) {
		return index*2+1;
	}
	
	//获取右子节点的坐标
	private int getRightIndex(int index) {
		return index*2+2;
	}

	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("SegmentTree data="+Arrays.toString(datas));
		buffer.append(" tree="+Arrays.toString(tree));
		return buffer.toString();
	}
	
	public void display() {
		System.out.println(this.toString());
	}
}
