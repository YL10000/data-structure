/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: OperationNoIndexRepeatable.java
 * @Package com.life.data.structure.arrays
 * @Description: 不使用索引，数据可重复复
 * @Author: ViaX-yanglin
 * @Date: 2018年8月26日 下午6:17:23
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: OperationNoIndexRepeatable
 * @Description: 不使用索引，数据可重复复
 * @Author: ViaX-yanglin
 * @Date: 2018年8月26日 下午6:17:23
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class OperationNoIndexRepeatable {

	private int[] datas;

	private int currentIndex;

	public OperationNoIndexRepeatable(int capacity) {
		super();
		this.datas = new int[capacity];
		currentIndex = 0;
	}
	
	public void insert(int value) {
		datas[currentIndex++] = value;
	}

	public void remove(int value,int... args) {
		int beginIndex=args!=null&&args.length>0?args[0]:0;
		// 根据value获取到index
		int index = getIndex(value,beginIndex);
		while (index>=0) {
			// 将index之后的数据依次前移一位
			for (int i = index; i < currentIndex; i++) {
				this.datas[i] = this.datas[i + 1];
			}
			currentIndex--;
			index = getIndex(value,index);
		}
		

	}

	private int getIndex(int value,int...args) {
		int beginIndex=args!=null&&args.length>0?args[0]:0;
		int index = -1;
		for (int i = beginIndex; i < currentIndex; i++) {
			if (datas[i] == value) {
				return i;
			}
		}
		return index;
	}

	public List<Integer> get(int value,int...args) {
		List<Integer> values=new ArrayList<>();
		int beginIndex=args!=null&&args.length>0?args[0]:0;
		// 根据value获取到index
		int index = getIndex(value,beginIndex);
		while (index >= 0) {
			values.add(datas[index]);
			index=getIndex(value, index+1);
		}
		return values;
	}

	public void display() {
		System.out.println("===========");
		Arrays.stream(datas).forEach(System.out::print);
		System.out.println();
	}
}
