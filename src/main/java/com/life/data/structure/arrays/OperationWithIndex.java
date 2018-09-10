/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: OperationWithIndex.java
 * @Package com.life.data.structure.arrays
 * @Description: 使用索引操作
 * @Author: ViaX-yanglin
 * @Date: 2018年8月26日 下午4:33:22
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.arrays;

import java.util.Arrays;

/**
 * @Title: OperationWithIndex
 * @Description: 使用索引操作
 * @Author: ViaX-yanglin
 * @Date: 2018年8月26日 下午4:33:22
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class OperationWithIndex {

	private int[] datas;
	
	private int currentIndex;

	public OperationWithIndex(int capacity) {
		super();
		this.datas=new int[capacity];
		currentIndex=0;
	}
	
	public void insert(int value) {
		datas[currentIndex++]=value;
	}
	
	public void remove(int index) {
		//将index之后的数据依次前移一位
		for(int i=index;i<currentIndex;i++) {
			this.datas[i]=this.datas[i+1];
		}
		currentIndex--;
	}
	
	public int get(int index) {
		return datas[index];
	}
	
	public void display() {
		System.out.println("===========");
		Arrays.stream(datas).forEach(System.out::print);
		System.out.println();
	}
	
}
