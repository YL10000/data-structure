/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: OperationNoIndex.java
 * @Package com.life.data.structure.arrays
 * @Description: TODO(用一句话描述该文件做什么)
 * @Author: ViaX-yanglin
 * @Date: 2018年8月26日 下午5:40:51
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.arrays;

import java.util.Arrays;

/**
 * @Title: OperationNoIndex
 * @Description: 不使用索引操作数组,数据不重复
 * @Author: ViaX-yanglin
 * @Date: 2018年8月26日 下午5:40:51
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class OperationNoIndex {

	private int[] datas;

	private int currentIndex;

	public OperationNoIndex(int capacity) {
		super();
		this.datas = new int[capacity];
		currentIndex = 0;
	}

	public void insert(int value) {
		datas[currentIndex++] = value;
	}

	public void remove(int value) {
		// 根据value获取到index
		int index = getIndex(value);
		if (index >= 0) {
			// 将index之后的数据依次前移一位
			for (int i = index; i < currentIndex; i++) {
				this.datas[i] = this.datas[i + 1];
			}
			currentIndex--;
		}

	}

	private int getIndex(int value) {
		int index = -1;
		for (int i = 0; i < currentIndex; i++) {
			if (datas[i] == value) {
				return i;
			}
		}
		return index;
	}

	public int get(int value) {
		// 根据value获取到index
		int index = getIndex(value);
		if (index >= 0) {
			return datas[index];
		}
		return 0;
	}

	public void display() {
		System.out.println("===========");
		Arrays.stream(datas).forEach(System.out::print);
		System.out.println();
	}
}
