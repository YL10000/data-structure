/**
 * Copyright © 2017, Beijing XitianQujing Technology Co., Ltd.
 * @Title: BinarySearch.java
 * @Package com.life.data.structure.arrays
 * @Description: 二分法查找
 * @Author: ViaX-yanglin
 * @Date: 2018年9月3日 下午6:43:48
 * @Version V1.0
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
package com.life.data.structure.arrays;

/**
 * @Title: BinarySearch
 * @Description: 二分法查找-有序数组
 * @Author: ViaX-yanglin
 * @Date: 2018年9月3日 下午6:43:48
 * 
 * @Copyright: 2018 All Rights Reserved.北京西天取经科技有限公司
 */
public class BinarySearch {
	
	
	
	public int getIndex(int[] arr,int item ) {
		int index=-1;
		int minIndex=0;
		int maxIndex=arr.length-1;
		//定义中间数据的坐标
		int middelIndex=(maxIndex+minIndex)/2;
		while (minIndex<=maxIndex) {
			if (arr[middelIndex]>item) {
				//当中间的数比给定的数据大，就在左边的的数据中查找
				maxIndex=middelIndex-1;
			}else if(arr[middelIndex]==item) {
				return middelIndex;
			}else {
				//当中间的数比给定的数据小，就在右边的的数据中查找
				minIndex=middelIndex+1;
			}
			middelIndex=(maxIndex+minIndex)/2;
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] array=new int[] {1,4,7,8,23,45,67};
		int index=new BinarySearch().getIndex(array, 7);
		System.out.println(index);
	}

}
