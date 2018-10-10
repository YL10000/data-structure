/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: MaxHeap.java
 * @Package com.life.data.structure.heap
 * @Description: 自定义最大堆
 * @Author: ViaX-yanglin
 * @Date: 2018年9月29日 上午11:14:52
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.heap;

import java.util.Comparator;

import com.life.data.structure.arrays.Array;

/**
 * @Title: MaxHeap
 * @Description: 自定义最大堆
 * @Author: ViaX-yanglin
 * @Date: 2018年9月29日 上午11:14:52
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class MaxHeap<E> {

	//使用数组作为堆的底层数据存储
	private Array<E> array=null;
	
	//堆中元素的比较规则
	private Comparator<E> comparator;

	public MaxHeap(Comparator<E> comparator) {
		this.comparator=comparator;
		this.array=new Array<>();
	}
	
	public MaxHeap(E[] nums, Comparator<E> comparator) {
		this.array = nums!=null?new Array<>(nums):new Array<>();
		this.comparator = comparator;
		
		//将传入的数组调整为一个最大堆
		//从最后开始将非叶子节点依次下浮调整
		int firsParentIndex=getParentIndex(getSize()-1);//最后一个非叶子节点
		while (firsParentIndex!=-1) {
			siftDown(firsParentIndex);
			firsParentIndex--;
		}
	}

	public int getSize() {
		return array.getSize();
	}
	
	public boolean isEmpty() {
		return array.isEmpty();
	}
	
	//向堆中添加元素
	public MaxHeap<E> add(E e){
		
		//将元素添加到数组尾部
		array.addLast(e);
		
		//调整堆尾元素的位置
		siftUp(array.getSize()-1);
		return this;
	}
	
	//提取堆顶的元素
	public E extract() {
		
		//首先获取堆顶元素
		E removeNode=array.find(0);
		
		//将最后一个元素放入到堆顶
		array.swap(0, getSize()-1);
		
		//删除最后一个元素
		array.removeLast();
		
		//将堆顶元素进行位置调整
		siftDown(0);
		
		//返回堆顶元素
		return removeNode;
	}
	
	//查看堆顶元素
	public E getFront() {
		return array.find(0);
	}
	
	private void siftUp(Integer index) {
		//如果已经到了堆顶，直接返回即可
		if (index==0) {
			return;
		}
		//如果父节点比该节点小，进行交互交互
		Integer parentIndex=getParentIndex(index);
		if (comparator.compare(array.find(parentIndex), array.find(index))<0) {
			array.swap(parentIndex, index);
			siftUp(parentIndex);
		}
	}
	
	private void siftDown(Integer index) {
		
		if (getRightIndex(index)>=getSize()&&getLeftIndex(index)>=getSize()) {
			//没有子节点,直接返回
			return;
		}else if (getRightIndex(index)>=getSize()&&comparator.compare(array.find(getLeftIndex(index)), array.find(index))>0) {
			//只有左子节点，且左子节点大于当前节点的值，进行交互
			array.swap(index, getLeftIndex(index));
		}else if (getRightIndex(index)<getSize()) {
			//左右节点都存在，获取最大的子节点
			int changeIndex=comparator.compare(array.find(getLeftIndex(index)), array.find(getRightIndex(index)))>0?getLeftIndex(index):getRightIndex(index);
			//如果子节点中的最大值大于该节点，进行交换
			if (comparator.compare(array.find(changeIndex), array.find(index))>0) {
				array.swap(index, changeIndex);
				siftDown(changeIndex);
			}
		}
	}
	
	//获取指定节点的下标获取左子节点的下标
	private int getLeftIndex(int index) {
		return 2*index+1;
	}
	
	//根据指定节点的下标获取右子节点的下标
	private int getRightIndex(int index) {
		return 2*index+2;
	}
	
	//根据指定节点的下标获取父节点的下标
	private Integer getParentIndex(int index) {
		if (index==0) {
			return -1;
		}
		return (index-1)/2;
	}

	@Override
	public String toString() {
		return "MaxHeap [size=" + getSize() + "]";
	}
	
	public MaxHeap<E> display() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("MaxHeap [size=" + getSize() + "] [");
		for(int i=0;i<getSize();i++) {
			buffer.append(array.find(i));
			if (i!=getSize()-1) {
				buffer.append(",");
			}
		}
		buffer.append("]");
		System.out.println(buffer.toString());
		return this;
	}
}
